package com.example.asynctask_j;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //key
    private static final String TEXT_STATE = "currentText";

    private TextView textMain;


    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMain = findViewById(R.id.textBackground);

        if(savedInstanceState != null) {
            textMain.setText(savedInstanceState.getString(TEXT_STATE));
        }


    }


    public void startTask(View view) {

        // putting a message before starting async
        textMain.setText(R.string.napping);

        // starting async now
        new MyAsyncTask(textMain).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //save the state of textview
        outState.putString(TEXT_STATE, textMain.getText().toString());



    }


}
