package com.academy.fundamentals.moviesapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity implements IAsyncTaskEvents {

    private CounterAsyncTask task;
    private static FragmentManager counterFragmentManager;
    private CounterFragment counterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        counterFragmentManager= getSupportFragmentManager();
        if(counterFragment==null)
        {
            counterFragment=new CounterFragment();
            Bundle data=new Bundle();
            data.putString(CounterFragment.FRAGMENT_TYPE,"This is AsyncTask activity!");
            counterFragment.setArguments(data);
            counterFragmentManager.beginTransaction().replace(R.id.counter_fragment, counterFragment).commit();
        }

        //counterFragment.newInstance();
    }

//    protected void onStop() {
//        super.onStop();
//        task.cancel(true);
//    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if(task!=null)
        {
            task.cancel(false);
            task=null;
        }
    }

    @Override
    public void onPreExecute(){ }

    @Override
    public void onPostExecute()
    {
        counterFragment.updateFragmentText("DONE!");
        task = null;
    }

    @Override
    public void onProgressUpdate(Integer integer)
    {
        counterFragment.updateFragmentText(String.valueOf(integer));
    }

    @Override
    public void onCancel() { }

    @Override
    public void createAsyncTask()
    {
        Toast.makeText(this,"Created, now START please!",Toast.LENGTH_SHORT).show();
        task= new CounterAsyncTask(this);

    }

    @Override
    public void startAsyncTask()
    {
        if((task==null||task.isCancelled()))
        {
            Toast.makeText(this,"Please CREATE a task first..", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Starting!", Toast.LENGTH_SHORT).show();
            task.execute(10);
        }
    }

    @Override
    public void cancelAsyncTask()
    {
        if(task==null)
        {
            Toast.makeText(this,"Please CREATE a task first..", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Cancelled!",Toast.LENGTH_SHORT).show();
            task.cancel(true);
        }
    }
}
