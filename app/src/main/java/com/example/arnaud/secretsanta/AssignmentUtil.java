package com.example.arnaud.secretsanta;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AssignmentUtil {
    /*
     * gets a comma separated list and randomly pairs its elements
     * if list size < 2, ask a user to enter more than one name
     * @parameter - list: the "," separated list
     * @return - hashmap of pairing if list size > 1
     * else return null
     */
    public HashMap<String, String> pair(String list){

        if(list instanceof String){
            if(list != null){

                // remove empty string in names
                ArrayList<String> names = new ArrayList<String>(Arrays.asList(list.replaceAll("\\s+","").split(",")));
                names.removeAll(Arrays.asList(""));

                HashMap<String, String> exchange = new HashMap<String, String>();

                Random generator = new Random();

                if(names.size() > 1){
                    int offset = generator.nextInt(names.size() - 1) + 1;
                    for(int i = 0; i < names.size(); i++)
                    {
                            String name = names.get(i).trim();
                            if(!name.isEmpty()){
                                String receives = names.get((i + offset) % names.size());
                                exchange.put(names.get(i), receives);
                            }
                            else{
                                names.remove(names.get(i));
                            }
                    }

                    if(exchange.size() >= 2) {
                        return exchange;
                    }
                    else
                        return null;
                }
                // if list of names is less or equal to 1 return null
                else{
                    return null;
                }
            }
            else {
                return null;
            }
        }
        else
            return null;

    }
}
