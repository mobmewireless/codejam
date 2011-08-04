/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sandboxserver;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Sanoob
 */
public class sandbox_time {


    public String ret_time(){
        String time = null;
        
        Calendar cal = new GregorianCalendar();
        String am_pm;
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        if(cal.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";
        time = ""+hour+" :"+" "+minute+": "+second+" "+am_pm;
        
        return(time);
    }



}
