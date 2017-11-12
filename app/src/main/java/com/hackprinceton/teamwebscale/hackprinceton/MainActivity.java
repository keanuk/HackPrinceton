package com.hackprinceton.teamwebscale.hackprinceton;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    JSONArray fullData;
    String food, calories, date;
    ListView myFood, myCal, myDate;


    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            fullData=ReadFromFile.readFromFileToJSON(this).getJSONArray("foodData");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_main);

        myFood = (ListView) findViewById(R.id.Food);
        myCal = (ListView) findViewById(R.id.Calories);
        myDate = (ListView) findViewById(R.id.Date);

        String[] foodArray = new String[fullData.length()];
        String[] calArray = new String[fullData.length()];
        String[] dateArray = new String[fullData.length()];

        try {
            for(int i=0; i<fullData.length(); i++) {
                foodArray[i] = "Food: " + fullData.getJSONObject(i).getString("foodName");
                calArray[i] = "Calories: " + fullData.getJSONObject(i).getString("calories");
                dateArray[i] = "Date: " + fullData.getJSONObject(i).getString("date");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> foodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,android.R.id.text1,foodArray);
        ArrayAdapter<String> calAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,android.R.id.text1,calArray);
        ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,android.R.id.text1,dateArray);

        myFood.setAdapter(foodAdapter);
        myCal.setAdapter(calAdapter);
//        myDate.setAdapter(dateAdapter);

//        try {
//            food = transaction.getString("food");
//            calories = transaction.getString("calories");
//            date = transaction.getString("date");
//            myFood.setText(food);
//            myCal.setText(calories);
//            myDate.setText(date);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
