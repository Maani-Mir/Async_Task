package com.example.asynctask_j;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;


public class MyAsyncTask extends AsyncTask <Void, Void, String> {

    private WeakReference<TextView> textView;

    MyAsyncTask(TextView tv){
        textView = new WeakReference<>(tv);
    }




    @Override
    protected String doInBackground(Void... voids) {
        Random rand = new Random();
        int num = rand.nextInt(11);
        int slep = num * 500;
        try {
            Thread.sleep(slep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "Awake at last after sleeping for " + slep + " milliseconds!!";
    }



    protected void onPostExecute (String result) {
        textView.get().setText(result);
        Log.d("MainActivity", "Awake String is on text view");
    }

    
}
