package com.mngoodwin.clickergamev2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private Button clickButton;
    private TextView monies;
    private int moneyInt;
    private Clicker clicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clickButton = findViewById(R.id.clicker);
        monies = findViewById(R.id.dollars);

        clicker = new Clicker( this );

        clickButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clicker.updateMonies(monies);
            }
        });
    }

    @Override
    protected void onResume( ) {
        super.onResume( );
        Log.w( "MA", "Inside MainActivity::onResume" );
        //clicker.updateMonies(monies);
    }

    @Override
    protected void onStart( ) {
        super.onStart( );
        Log.w( "MA", "Inside MainActivity::onStart" );
        clicker.setMoneyLable(monies);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        clicker.setPreferences( this );
        Log.w("MA", "destroyed");
    }
}