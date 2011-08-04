package ngram;

import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Sinu John
 *     sinuvian at gmail dot com
 *     www.sinujohn.wordpress.com
 */

/**
 *
 * Trigram database is modelled using 3 Levels of Java Collections
 * Levels 1,2 - HashMap
 * Level 3 - ArrayList
 */
public class trigrams {

    HashMap l1 = new HashMap();

    /**
     * populates the hashmap l1 with the words s1, s2, s3
     * @param s1 first word of the trigram
     * @param s2 second word of the trigram
     * @param s3 third word of the trigram
     */
    void populate(String s1, String s2, String s3) {
        if(l1.containsKey(s1)) {
            HashMap l2 = (HashMap) l1.get(s1);
            if(l2.containsKey(s2)) {
                ArrayList l3 = (ArrayList) l2.get(s2);
                if(!l3.contains(s3)) l3.add(s3);
            } else {
                ArrayList l3 = new ArrayList();
                l3.add(s3);
                l2.put(s2, l3);
            }
        } else {
            HashMap l2 = new HashMap();
            ArrayList l3 = new ArrayList();
            l3.add(s3);
            l2.put(s2, l3);
            l1.put(s1, l2);
        }
    }

    /**
     * display() - Displays the trigrams stored
     * Useful for debugging purposes
     */
    void display() {
        Set s1 = l1.entrySet();
        Iterator i = s1.iterator();

        while(i.hasNext()) {
            Map.Entry me1 = (Map.Entry) i.next();
            Set s2 = ((HashMap)me1.getValue()).entrySet();
            Iterator j = s2.iterator();
            while(j.hasNext()) {
                Map.Entry me2 = (Map.Entry) j.next();
                ArrayList l3 = (ArrayList) me2.getValue();
                for(int k=0; k<l3.size(); k++) {
                    System.out.println(me1.getKey() + " " + me2.getKey() + " " + l3.get(k));
                }
            }
        }
    }

    /**
     * creates story from the trigrams
     * @return the String containing the story
     */
    String getStory() {
        Random r = new Random();
        int pos=0;
        int THRESHOLD=4000; // Limit for the Initial search for words
        int LIMIT = 200; //Word count for story

        String[] keyArr = (String[]) l1.keySet().toArray(new String[0]);
        String str = "", key1 = null, key2 = null;
        HashMap l2;
        ArrayList l3;

        for(int i=0; i<THRESHOLD; i++) { //Finds the first 3 suitable words
            pos = r.nextInt(keyArr.length);
            str = "";
            if(keyArr[pos].charAt(0)>='A' && keyArr[pos].charAt(0)<='Z' && !keyArr[pos].endsWith(".")) {
                key1 = keyArr[pos];
                str = key1; //first word
                l2 = (HashMap) l1.get(key1);
                pos = r.nextInt(l2.size());
                keyArr = (String[]) l2.keySet().toArray(new String[0]);
                key1 = keyArr[pos];
                str = str + " " + key1; //second word
                l3 = (ArrayList) l2.get(key1);
                pos = r.nextInt(l3.size());
                key2 = (String) l3.get(pos);
                str = str + " " + key2; // third word
                if(!key1.endsWith(".") && !key2.endsWith(".")) break;
            }
        }
        
        int count = 3; //No. of words found

        boolean run = true;

        /**
         * This loop finds the remaining words.
         * key1 is the second word of the previous trigram
         * key2 is the third word of the previous trigram
         * Using the keys 'key1' and 'key2' the next word is found
         */
        while(run) {
            count++;

            try {
                l2 = (HashMap) l1.get(key1);
                l3 = (ArrayList) l2.get(key2);

                key1 = key2;

                pos = r.nextInt(l3.size());
                key2 = (String) l3.get(pos);

                str = str + " " + key2; // next word

                if(key2.endsWith(".")) {
                    if(count>LIMIT) run = false; //We have reached the end of a sentence. And we also have got a story of required wordlength(LIMIT)
                }
            } catch(NullPointerException e){
                run = false;
                break;
            }
        }

        return str; //The Trigram Story!
    }
}
