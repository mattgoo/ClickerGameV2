package com.mngoodwin.clickergamev2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Clicker {
    private int clickValue;
    private int money;
    private int netWorth;
    public final DecimalFormat MONEY = new DecimalFormat( "$#,##0.00" );


    // Read from user preferences
    public Clicker( Context context ) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(  context );
        setClickValue( pref.getInt( "clickerValue", 1 ) );
        setMoney( pref.getInt( "money", 3 ) );
        setNetWorth( pref.getInt("netWorth", 0));
    }

    // method to write the data inside *this* Mortgage object to preferences
    public void setPreferences( Context context ) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(  context );
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt( "clickerValue", clickValue );
        Log.w( "MA", "cv is " + clickValue );
        editor.putInt( "money", money);
        Log.w( "MA", "money is " + money );
        editor.putInt( "netWorth", netWorth );
        editor.commit();
    }

    public void setClickValue( int newClickValue ) {
        clickValue = newClickValue;
    }

    public void setMoney( int newMoney ) {
        money = newMoney;
    }

    public int getMoney(){
        return money;
    }


    public void setNetWorth( int newNetWorth ) {
        netWorth = newNetWorth;
    }

    public void setMoneyLable(TextView view){
        view.setText(String.valueOf(money));
    }

    public void updateMonies(TextView view){
        //String mString = view.getText().toString();
        //Log.w( "MA", "mString is " + mString );
        //int moniesInt = Integer.parseInt(mString);
        //Log.w( "MA", "monies is " + moniesInt );
        //moniesInt += clickValue;
        money += clickValue;
        Log.w( "MA", "money = " + money );
        //mString = String.valueOf(money);
        //Log.w( "MA", "mString+1 is " + mString );
        //view.setText(mString);
        view.setText(String.valueOf(money));
    }

}
