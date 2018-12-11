package com.academy.fundamentals.moviesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity
{
    //private static final String FRAGMENT_TAG = "details_fragment";
    public static final String EXTRA_ITEM_POSITION = "init-position-data";
    private DetailsPagerAdapter pagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //DetailsFragment detailsFragment=new DetailsFragment();

        pagerAdapter= new DetailsPagerAdapter(getSupportFragmentManager());

        viewPager=findViewById(R.id.details_view_pager);
        viewPager.setAdapter(pagerAdapter);

        int startPosition = getIntent().getIntExtra(EXTRA_ITEM_POSITION, 0);
        viewPager.setCurrentItem(startPosition, false);

        //getSupportFragmentManager().beginTransaction().add(R.id.details_view_pager, detailsFragment,FRAGMENT_TAG).commit();

    }

    public class DetailsPagerAdapter extends FragmentStatePagerAdapter
    {

        public DetailsPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return DetailsFragment.newInstance(MoviesContentList.MOVIES.get(position));
        }

        @Override
        public int getCount()
        {
            return MoviesContentList.MOVIES.size();
        }
    }
}
