Contest ID: emotion
Developer:
            Sinu John
            email : sinuvian@gmail.com
            blog  : www.sinujohn.wordpress.com
            mobile: +91 9747632404

1. DESIGN
	The application makes use of 'twitter4j' project for communicating with twitter. It helps in making use of the Twitter Search API. The Query is "I Love you". 
	The search returns recent 1000 tweets that match the query. (The number 1000 is assumed as the maximum number of tweets that can match the query in 10 seconds). From this the number of tweets in the last 10 seconds(initial) or till the previously looked tweet(for remaining cases) is found out. This number along with the time is used in plotting the graph.
	The application uses 'jfreechart' inorder to draw the chart. It also provides other features like zooming, etc.

2. DEPENDENCIES
	The coding is done in Java. So it should run on almost all PCs that have JVM.
	The executable is 'emotion_love.jar'. It should work out of the box.
	To compile the source, it requires twitter4j-core-2.2.3.jar, jfreechart-1.0.13.jar and jcommon-1.0.16.jar in its classpath. These dependencies are included in /lib.

3. USAGE
	Usage:
       		java -jar emotion_love.jar

