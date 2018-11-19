package com.example.arnaud.secretsanta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText names;
    Button pair;
    TextView tv;
    ListView ls; // listview to display assignments
    HashMap<String, String> pairMe; // hashmap to hold pair of "giver, receiver"
    AssignmentUtil assignmentUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = findViewById(R.id.list);
        pair = findViewById(R.id.getSecret);
        tv = findViewById(R.id.displayList);
        ls = findViewById(R.id.mobile_list);
        ls.setVisibility(View.GONE);
        assignmentUtil = new AssignmentUtil();

        pair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(names.getText().toString().contains(",")){
                    pairMe = assignmentUtil.pair(names.getText().toString());

                    /*
                    * if pairMe is less than 2, toast to ask to enter at least two names
                    * else do the pairing
                    */
                    if(pairMe == null){
                        Toast.makeText(getApplicationContext(), "Please enter more than one name", Toast.LENGTH_LONG).show();
                    }else{
                        ls.setVisibility(View.VISIBLE);
                        DataAdapter adp = new DataAdapter(pairMe);
                        ls.setAdapter(adp);
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Please enter more than one name", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
