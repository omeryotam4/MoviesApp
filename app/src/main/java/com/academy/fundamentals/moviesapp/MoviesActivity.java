package com.academy.fundamentals.moviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MoviesActivity extends AppCompatActivity implements OnMovieClickListener {
    //private List<MovieDataModel> movies = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        creatDataListOfMovies();
        //initRecyclerView();
        recyclerView.setAdapter(new MoviesViewAdapter(this,MoviesContentList.MOVIES, this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.details_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.asynctask_item:
                Toast.makeText(this,"this is async task!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,AsyncTaskActivity.class));
                return true;
            case R.id.handler_item:
                Toast.makeText(this,"this is thread handler!",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //private void initRecyclerView()
    //{
    //RecyclerView moviesRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    //RecyclerView.LayoutManager moviesLayoutManager = new LinearLayoutManager(this);
    //moviesRecyclerView.setLayoutManager(moviesLayoutManager);
    //RecyclerView.Adapter moviesAdapter = new MoviesViewAdapter(this,movies,this);
    //moviesRecyclerView.setAdapter(moviesAdapter);
    //}

    @Override
    public void onMovieListClick(int position)
    {
        if(position<0||position>=MoviesContentList.MOVIES.size()) return;
        //MovieDataModel movie=movies.get(position);
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_ITEM_POSITION,position);
        startActivity(intent);
        // if(movie==null)return;
        // Toast.makeText(this,movie.getName(),Toast.LENGTH_SHORT).show();
    }

    private void creatDataListOfMovies()
    {
        MoviesContentList.clear();

        MovieDataModel m1=new MovieDataModel();
        MovieDataModel m2=new MovieDataModel();
        MovieDataModel m3=new MovieDataModel();
        MovieDataModel m4=new MovieDataModel();
        MovieDataModel m5=new MovieDataModel();
        MovieDataModel m6=new MovieDataModel();
        MovieDataModel m7=new MovieDataModel();
        MovieDataModel m8=new MovieDataModel();
        MovieDataModel m9=new MovieDataModel();
        MovieDataModel m10=new MovieDataModel();
        MovieDataModel m11=new MovieDataModel();

        m1.setName("Black Panther");
        m2.setName("Deadpool 2");
        m3.setName("Guardians of the Galaxy");
        m4.setName("How to Train Your Dragon: The Hidden World");
        m5.setName("Interstellar");
        m6.setName("Avengers: Infinity War");
        m7.setName("Jurassic World: Fallen Kingdom");
        m8.setName("Ocean's Eight");
        m9.setName("The First Purge");
        m10.setName("The Meg");
        m11.setName("Thor: Ragnarok");

        m1.setTrailerUrl("https://www.youtube.com/watch?v=xjDjIWPwcPU");
        m2.setTrailerUrl("https://www.youtube.com/watch?v=20bpjtCbCz0");
        m3.setTrailerUrl("https://www.youtube.com/watch?v=2LIQ2-PZBC8");
        m4.setTrailerUrl("https://www.youtube.com/watch?v=SkcucKDrbOI");
        m5.setTrailerUrl("https://www.youtube.com/watch?v=zSWdZVtXT7E");
        m6.setTrailerUrl("https://www.youtube.com/watch?v=6ZfuNTqbHE8");
        m7.setTrailerUrl("https://www.youtube.com/watch?v=vn9mMeWcgoM");
        m8.setTrailerUrl("https://www.youtube.com/watch?v=n5LoVcVsiSQ");
        m9.setTrailerUrl("https://www.youtube.com/watch?v=UL29y0ah92w");
        m10.setTrailerUrl("https://www.youtube.com/watch?v=bsLk0NPRFAc");
        m11.setTrailerUrl("https://www.youtube.com/watch?v=ue80QwXMRHg");

        m1.setReleaseDate("13-02-2018");
        m2.setReleaseDate("15-05-2018");
        m3.setReleaseDate("30-07-2014");
        m4.setReleaseDate("22-02-2019");
        m5.setReleaseDate("05-11-2014");
        m6.setReleaseDate("01-01-2018");
        m7.setReleaseDate("06-06-2018");
        m8.setReleaseDate("07-06-2018");
        m9.setReleaseDate("04-07-2018");
        m10.setReleaseDate("09-08-2018");
        m11.setReleaseDate("25-10-2017");

        m1.setBackImageRes(R.drawable.bp_back);
        m2.setBackImageRes(R.drawable.dp2_back);
        m3.setBackImageRes(R.drawable.gotg_back);
        m4.setBackImageRes(R.drawable.httyd3_back);
        m5.setBackImageRes(R.drawable.is_back);
        m6.setBackImageRes(R.drawable.iw_back);
        m7.setBackImageRes(R.drawable.jw_back);
        m8.setBackImageRes(R.drawable.o8_back);
        m9.setBackImageRes(R.drawable.tfp_back);
        m10.setBackImageRes(R.drawable.tm_back);
        m11.setBackImageRes(R.drawable.tr_back);

        m1.setImageResourceId(R.drawable.bp_main);
        m2.setImageResourceId(R.drawable.dp2_main);
        m3.setImageResourceId(R.drawable.gotg_main);
        m4.setImageResourceId(R.drawable.httyd3_main);
        m5.setImageResourceId(R.drawable.is_main);
        m6.setImageResourceId(R.drawable.iw_main);
        m7.setImageResourceId(R.drawable.jw_main);
        m8.setImageResourceId(R.drawable.o8_main);
        m9.setImageResourceId(R.drawable.tfp_main);
        m10.setImageResourceId(R.drawable.tm_main);
        m11.setImageResourceId(R.drawable.tr_main);

        m1.setOverview("After the death of his father, Prince T'Challa ascends to the throne of the small African country of Wakanda. T'Challa is also Black Panther, superhero. Now not only must he govern his country but defeat a dangerous adversary.");
        m2.setOverview("Foul-mouthed mutant mercenary Wade Wilson (AKA. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg, Cable.");
        m3.setOverview("A group of intergalactic criminals are forced to work together to stop a fanatical warrior from taking control of the universe.");
        m4.setOverview("As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup's reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.");
        m5.setOverview("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
        m6.setOverview("The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.");
        m7.setOverview("When the island's dormant volcano begins roaring to life, Owen and Claire mount a campaign to rescue the remaining dinosaurs from this extinction-level event.");
        m8.setOverview("Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City's yearly Met Gala.");
        m9.setOverview("America's third political party, the New Founding Fathers of America, comes to power and conducts an experiment: no laws for 12 hours on Staten Island. No one has to stay on the island, but $5,000 is given to anyone who does.");
        m10.setOverview("After escaping an attack by what he claims was a 70-foot shark, Jonas Taylor must confront his fears to save those trapped in a sunken submersible.");
        m11.setOverview("Thor is imprisoned on the planet Sakaar, and must race against time to return to Asgard and stop Ragnarök, the destruction of his world, at the hands of the powerful and ruthless villain Hela.");

        MoviesContentList.addMovie(m1);
        MoviesContentList.addMovie(m2);
        MoviesContentList.addMovie(m3);
        MoviesContentList.addMovie(m4);
        MoviesContentList.addMovie(m5);
        MoviesContentList.addMovie(m6);
        MoviesContentList.addMovie(m7);
        MoviesContentList.addMovie(m8);
        MoviesContentList.addMovie(m9);
        MoviesContentList.addMovie(m10);
        MoviesContentList.addMovie(m11);
    }
}