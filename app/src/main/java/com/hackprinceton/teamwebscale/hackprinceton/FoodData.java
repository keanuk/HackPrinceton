package com.hackprinceton.teamwebscale.hackprinceton;

import java.util.Date;

/**
 * Created by Trevor on 11/11/2017.
 */

public class FoodData {
    private Date date;
    private String foodName;
    private int calories;
    FoodData(Date date,String foodName, int calories ){
        this.date=date;
        this.foodName=foodName;
        this.calories=calories;
    }
    public java.util.Date getDate(){
        return date;
    }
    public  String getFoodName(){
        return foodName;
    }
    public int getCalories(){
        return calories;
    }

}
