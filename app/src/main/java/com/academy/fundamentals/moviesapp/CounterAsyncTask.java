package com.academy.fundamentals.moviesapp;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.TextView;

public class CounterAsyncTask extends AsyncTask<Integer,Integer,String>
{
    private IAsyncTaskEvents countDown;

    public CounterAsyncTask(IAsyncTaskEvents iAsyncTaskEvents) {
        countDown = iAsyncTaskEvents;
    }

    @Override
    protected String doInBackground(Integer...numbers)
    {
        int len=10;
        for(int i=1;i<=len;i++)
        {
            if(isCancelled())
            {
                return null;
            }
            publishProgress(i);
            SystemClock.sleep(500);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (countDown != null) {
            countDown.onPreExecute();
        }
    }

    @Override
    protected void onProgressUpdate(Integer ... numbers) {
        super.onProgressUpdate(numbers);
        if (countDown != null) {
            countDown.onProgressUpdate(numbers[0]);
        }    }

    protected void onPostExecute(Void result)
    {
        //TODO:check if the wrapper "String.valueOf()" is really necessary.
        super.onPostExecute(String.valueOf(result));
        if (countDown != null)
        {
            countDown.onPostExecute();
        }
    }

    //    protected void onCancelled() {
//        countDown.setText("cancelled!");
//    }
}
