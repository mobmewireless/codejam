/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import USSDEngine.Settings;


/**
 *
 * @author codejam
 */
public class TestSettings {

    
    public static void main( String args[]) {
        Settings set;
        set = new Settings();
        System.out.println("Todays module : "+ set.USSDSettings.getProperty("module","ERROR"));
    }
}
