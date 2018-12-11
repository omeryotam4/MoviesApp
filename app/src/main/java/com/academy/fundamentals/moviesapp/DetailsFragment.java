package com.academy.fundamentals.moviesapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment implements View.OnClickListener
{
    //private static final String TAG="MovieDetailsFragment";
    private static final String ARG_MOVIE="arg_movie_list_model";
    private ImageView thumbnail;
    private ImageView background;
    private TextView title;
    private TextView overview;
    private TextView releaseDate;
    private MovieDataModel model;

    public DetailsFragment(){ }

    public static DetailsFragment newInstance(MovieDataModel model)
    {
        DetailsFragment detailsFragment=new DetailsFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable(ARG_MOVIE,model);
        detailsFragment.setArguments(bundle);
        return detailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null)
        {
            model=getArguments().getParcelable(ARG_MOVIE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //View layout=view.findViewById(R.id.fragment_details_layout);
        //TextView textView=view.findViewById(R.id.fragment_details_overview);
        //need to find out what to do with this "layout" and "textView"...
        return inflater.inflate(R.layout.fragment_details,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View v,@Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(v,savedInstanceState);
        thumbnail=v.findViewById(R.id.main_thumbnail);
        background=v.findViewById(R.id.imageView);
        title=v.findViewById(R.id.movie_name);
        overview=v.findViewById(R.id.details_overview);
        releaseDate=v.findViewById(R.id.details_release_date);
        Button trlr_btn_v=v.findViewById(R.id.trailer_btn);

        trlr_btn_v.setOnClickListener(this);

        setMovie();

    }

    private void setMovie()
    {
        if(model==null) return;
        thumbnail.setImageResource(model.getImageResourceId());
        background.setImageResource(model.getBackImageRes());
        title.setText(model.getName());
        overview.setText(model.getOverview());
        releaseDate.setText(model.getReleaseDate());
    }

    @Override
    public void onClick(View view)
    {
        if(model==null)return;
        String muv_url = model.getTrailerUrl();
        if (TextUtils.isEmpty(muv_url)) return;
        //String muv_url = DetailsActivity.this.getString(R.string.IW_url);
        Intent act = new Intent(Intent.ACTION_VIEW, Uri.parse(muv_url));
        startActivity(act);
    }


}
