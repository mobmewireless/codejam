/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import USSDEngine.USSD;

/**
 *
 * @author codejam
 */
public class TestUSSD {
    
    public static void main(String args[]) {
        USSD ussd = new USSD();
        
        System.out.println(ussd.startModule("xxx","123"));
        System.out.println(ussd.getResponse("1","xxx","123"));
        System.out.println(ussd.getResponse("2","xxx","123"));



    }
}
