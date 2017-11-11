package com.hackprinceton.teamwebscale.hackprinceton;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String JSON_STRING = "{\"transaction\":{\"food\":\"hamburger\",\"calories\":666\",\"date\":test}}";
    String food, calories, date;
    TextView myFood, myCal, myDate;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFood = (TextView) findViewById(R.id.Food);
        myCal = (TextView) findViewById(R.id.Calories);
        myDate = (TextView) findViewById(R.id.Date);

        try {
            JSONObject obj = new JSONObject(JSON_STRING);
            JSONObject transaction = obj.getJSONObject("transaction");
            food = transaction.getString("food");
            calories = transaction.getString("calories");
            date = transaction.getString("date");
            myFood.setText(food);
            myCal.setText(calories);
            myDate.setText(date);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
