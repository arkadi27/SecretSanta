package com.example.arnaud.secretsanta;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AssertSantaAlgo {

    /*
    * a null input should return null
    */
    @Test
    public void testNullValue() {

        AssignmentUtil assignmentUtil = new AssignmentUtil();
        HashMap<String, String> exchange = assignmentUtil.pair(null);
        assertNull(exchange);
    }

    /*
     * a single name list should return null
     */
    @Test
    public void testSingleName() {

        AssignmentUtil assignmentUtil = new AssignmentUtil();
        String list = "Arnaud";
        HashMap<String, String> exchange = assignmentUtil.pair(list);
        assertNull(exchange);
    }

    /*
      * a single name list with comma should return null
    */
    @Test
    public void testSingleNameWithComma() {

        AssignmentUtil assignmentUtil = new AssignmentUtil();
        String list1 = "Arnaud,";
        HashMap<String, String> exchange1 = assignmentUtil.pair(list1);
        assertNull(exchange1);

        String list2 = ",Arnaud,";
        HashMap<String, String> exchange2 = assignmentUtil.pair(list2);
        assertNull(exchange2);
    }

    @Test
    public void testWrongInput() {

        AssignmentUtil assignmentUtil = new AssignmentUtil();
        HashMap<String, String> exchange = assignmentUtil.pair(null);
        assertNull(exchange);
    }

    /*
       * this test assert that each value in the hashmap of names is unique
       * if it is, it means every person in the list only received a gift once,
       * it also verifies that each value (receiver) can be found in the list
       * of keys - givers (to verify each person gave)

     */
    @Test
    public void testExpectedInput() {

        AssignmentUtil assignmentUtil = new AssignmentUtil();
        HashMap<String, String> exchange = assignmentUtil.pair("Arnaud, Dan, Kevin, Glory");

        Collection<String> receivers = exchange.values();
        Set<String> givers = exchange.keySet();
        Object[] valueArray = receivers.toArray();

        for(int i=0; i < valueArray.length-1; i++){
            for(int x = i+1; x < valueArray.length-1; x++){
                assertNotEquals(valueArray[i], valueArray[x]);
            }
        }

        for(int i=0; i < valueArray.length-1; i++){
            assert(givers.contains(valueArray[i]));
        }
    }
}