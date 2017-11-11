package com.hackprinceton.teamwebscale.hackprinceton;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Trevor on 11/11/2017.
 */

public class WriteToFile extends FileInteraction {
    public static void addEntryToJsonFile(AppCompatActivity ctx, FoodData foodData) {
        OutputStream outputStream = null;
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(ctx.openFileOutput(fileName, Context.MODE_PRIVATE | Context.MODE_APPEND));
            StringBuilder sb=new StringBuilder();
            sb.append(foodData.getDate());
            sb.append(",");
            sb.append(foodData.getFoodName());
            sb.append(",");
            sb.append(foodData.getCalories());
            sb.append("\n");
            outputStreamWriter.write(sb.toString());
            outputStreamWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
