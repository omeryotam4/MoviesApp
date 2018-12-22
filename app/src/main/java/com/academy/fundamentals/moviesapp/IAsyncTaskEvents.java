package com.academy.fundamentals.moviesapp;

public interface IAsyncTaskEvents
{
    void onPreExecute();
    void onPostExecute();
    void onProgressUpdate(Integer integer);
    void onCancel();

    void createAsyncTask();
    void startAsyncTask();
    void cancelAsyncTask();
}
