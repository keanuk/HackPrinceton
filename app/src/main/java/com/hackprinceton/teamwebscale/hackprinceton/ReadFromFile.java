package com.hackprinceton.teamwebscale.hackprinceton;

import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Trevor on 11/11/2017.
 */

public class ReadFromFile extends FileInteraction {
    public static JSONObject readFromFileToJSON(AppCompatActivity ctx){
        JSONObject jsonObject=new JSONObject();
        try{
            FileInputStream in = ctx.openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            ArrayList<JSONObject> foodDataJSONObjectList=new ArrayList<JSONObject>();
            while ((line = bufferedReader.readLine()) != null) {
                String [] currentFoodDataString=line.split(",");
                JSONObject currentFoodDataJSONObject=new JSONObject();
                currentFoodDataJSONObject.put("date",currentFoodDataString[0]);
                currentFoodDataJSONObject.put("foodName",currentFoodDataString[1]);
                currentFoodDataJSONObject.put("calories",currentFoodDataString[2]);
                foodDataJSONObjectList.add(currentFoodDataJSONObject);
            }
            jsonObject.put("foodData",new JSONArray(foodDataJSONObjectList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    public static ArrayList<String> readFromFileToFoodDataStrings(AppCompatActivity ctx){
            return null;
    }
}
