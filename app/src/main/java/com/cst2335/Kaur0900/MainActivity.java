package com.cst2335.Kaur0900;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        EditText email=findViewById(R.id.et);
        SharedPreferences.Editor editor = prefs.edit();
        String emailAddress = prefs.getString("LoginName" , "");
        email.setText(emailAddress);

        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );
        Button button = (Button)findViewById(R.id.loginButton);

        button.setOnClickListener(clk->{
          Intent nextpage = new Intent(MainActivity.this , SecondActivity.class);

          editor.putString("LoginName",email.getText().toString());
          editor.putFloat("hi", 4.5f);
          editor.putInt("Age", 19);
          editor.apply();

           nextpage.putExtra("EmailAddress" , email.getText().toString());
           startActivity(nextpage);
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.w( "MainActivity", "In onStart() - The application is now visible on screen" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w( "MainActivity", "In onResume() - Loading Widgets" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w( "MainActivity", "In onPause() - Loading Widgets" );


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w( "MainActivity", "In onStop() - Loading Widgets" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w( "MainActivity", "In on() - Loading Widgets" );
    }

}