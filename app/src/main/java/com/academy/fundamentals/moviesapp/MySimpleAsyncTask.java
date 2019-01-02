package com.academy.fundamentals.moviesapp;

import android.os.Looper;
import android.os.SystemClock;
import android.os.Handler;

public class MySimpleAsyncTask
{
    private boolean cancelled = false;
    private Thread backgroundThread;
    private IAsyncTaskEvents listener;

    public MySimpleAsyncTask(IAsyncTaskEvents iAsyncTaskEvents) {
        listener = iAsyncTaskEvents;
    }

    protected void onPreExecute()
   {
       listener.onPreExecute();
   }

   protected String doInBackground()
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

   protected void onPostExecute()
   {
       listener.onPostExecute();
   }

   public void execute()
   {
       runOnUiThread(new Runnable()
       {
           @Override
           public void run()
           {
               onPreExecute();

               backgroundThread = new Thread("Handler_executor_thread")
               {
                   @Override
                   public void run()
                   {
                       doInBackground();

                       runOnUiThread(new Runnable()
                       {
                           @Override
                           public void run() {
                               onPostExecute();
                           }
                       });
                   }
               };
               backgroundThread.start();
           }
       });
   }

   protected void onProgressUpdate(Integer p)
   {
       listener.onProgressUpdate(p);
   }

   protected void cancel()
   {
       cancelled=true;
       backgroundThread.interrupt();
   }

   private void runOnUiThread(Runnable runnable)
   {
       new Handler(Looper.getMainLooper()).post(runnable);
   }

   protected void publishProgress(final int p)
   {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               onProgressUpdate(p);
           }
       });
   }

    public boolean isCancelled() {
        return cancelled;
    }
}
