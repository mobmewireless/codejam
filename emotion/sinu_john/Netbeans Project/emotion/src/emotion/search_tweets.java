package emotion;

import java.util.Date;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import java.util.List;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class search_tweets extends ApplicationFrame implements Runnable{
    final int LIMIT = 1000;
    final int tenSeconds = 10 * 1000;
    static final String M_TITLE = "Emotion Statistics";
    static final int M_WIDTH = 700, M_HEIGHT = 400;
    Thread t;
    Query qry = new Query("\"I love you\"");
    Twitter twitter = new TwitterFactory().getInstance();
    Date lastDate;

     TimeSeries series = new TimeSeries("Per Second Data", Second.class);
     TimeSeriesCollection dataset = new TimeSeriesCollection(series);
     JFreeChart chart = createChart(dataset);
     ChartPanel chartPanel = new ChartPanel(chart);

    public void run() {
        try {
            while(true) {
                QueryResult result = twitter.search(qry);
                List<Tweet> tweets = result.getTweets();
                int count = 0;
                for (Tweet tweet : tweets) {
                    java.util.Date d = tweet.getCreatedAt();
                    if(d.before(lastDate)) break;
                    count++;
                    //System.out.println("@" + tweet.getFromUser() + " - " + d +  " - " + tweet.getText());
                }
                lastDate = tweets.get(0).getCreatedAt();
                System.out.println(lastDate + " - " + count);
                series.add(new Second(lastDate), count);
                dataset.removeAllSeries();
                dataset.addSeries(series);
                showChart();
                Thread.sleep(tenSeconds);
            }
        } catch(Exception te) {
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }

    public search_tweets(final String title) {
        super(title);
        t = new Thread(this);
        qry.setRpp(LIMIT);

        chartPanel.setPreferredSize(new Dimension(M_WIDTH, M_HEIGHT));
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setDomainZoomable(true);
        chartPanel.setHorizontalAxisTrace(true);
        chartPanel.setVerticalAxisTrace(true);
        setContentPane(chartPanel);
        try {
            QueryResult result = twitter.search(qry);
            List<Tweet> tweets = result.getTweets();
            int count = 0;
            Date d0 = tweets.get(0).getCreatedAt();
            for (Tweet tweet : tweets) {
                java.util.Date d = tweet.getCreatedAt();
                if(d0.getTime() - d.getTime() > tenSeconds) break;
                count++;
                //System.out.println("@" + tweet.getFromUser() + " - " + d +  " - " + tweet.getText());
            }
            lastDate = d0;
            System.out.println(lastDate + " - " + count);
            String str = "" + lastDate.getHours() + ":" + lastDate.getMinutes() + ":" + lastDate.getSeconds();
            //dataset.addValue(count, series1, str);
            series.add(new Second(lastDate), count);
        } catch(Exception te) {
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }

    void startSearch()
    {
        try {
            Thread.sleep(tenSeconds);
            t.start();
            t.join();
        } catch (InterruptedException ex) {
            System.out.println("Failed to search tweets: ");
            System.exit(-1);
        }
    }
    
    private void showChart() {
        chart.getXYPlot().setDataset(dataset);
    }

    private JFreeChart createChart(final TimeSeriesCollection dataset) {

        // create the chart...
        final JFreeChart tchart = ChartFactory.createTimeSeriesChart(
            M_TITLE,                     // chart title
            "Time",                    // domain axis label
            "Number of tweets",                   // range axis label
            dataset,                   // data
            false,                      // include legend
            true,                      // tooltips
            false                      // urls
        );

        tchart.setBackgroundPaint(Color.white);

        final XYPlot plot = (XYPlot) tchart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        // customise the renderer...
        final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();

        renderer.setSeriesStroke(
            0, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f)//, new float[] {10.0f, 6.0f}, 0.0f
            //)
        );
        renderer.setSeriesStroke(
            1, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            2, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {2.0f, 6.0f}, 0.0f
            )
        );
        // OPTIONAL CUSTOMISATION COMPLETED.

        return tchart;
    }


    public static void main(String args[]) {
        search_tweets st = new search_tweets(M_TITLE);
        st.setSize(M_WIDTH, M_HEIGHT);
        RefineryUtilities.centerFrameOnScreen(st);
        st.setVisible(true);
        st.startSearch();
    }
}