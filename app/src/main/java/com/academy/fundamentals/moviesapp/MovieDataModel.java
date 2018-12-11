package com.academy.fundamentals.moviesapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieDataModel implements Parcelable
{
    private String name;
    private int imageResourceId;
    private String overview;
    private int backImageRes;
    private String releaseDate;
    private String trailerUrl;

    public MovieDataModel() { }

    protected MovieDataModel(Parcel in)
    {
        name = in.readString();
        imageResourceId = in.readInt();
        overview = in.readString();
        backImageRes = in.readInt();
        releaseDate = in.readString();
        trailerUrl = in.readString();
    }

    public static final Creator<MovieDataModel> CREATOR = new Creator<MovieDataModel>() {
        @Override
        public MovieDataModel createFromParcel(Parcel in) {
            return new MovieDataModel(in);
        }

        @Override
        public MovieDataModel[] newArray(int size) {
            return new MovieDataModel[size];
        }
    };

    //actions on the name
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        this.name = n;
    }

    //actions on the image id, that directs to the image
    public int getImageResourceId()
    {
        return imageResourceId;
    }
    public void setImageResourceId(int imageResId)
    {
        this.imageResourceId = imageResId;
    }

    //actions on the overview
    public String getOverview()
    {
        return overview;
    }
    public void setOverview(String ov)
    {
        this.overview = ov;
    }

    public int getBackImageRes() { return backImageRes; }
    public void setBackImageRes(int backImageRes) { this.backImageRes = backImageRes; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public String getTrailerUrl() { return trailerUrl; }
    public void setTrailerUrl(String trailerUrl) { this.trailerUrl = trailerUrl; }

    @Override
    public String toString()
    {
        return "MovieDataModel{"+"name='"+name+"'"+",overview='"+overview+"'"+",imageResourceId="+imageResourceId+",releaseDate='"+releaseDate+"'"+",trailerUrl='"+trailerUrl+"'"+",backImageRes="+backImageRes+'}';
    }

    public static final Creator<MovieDataModel> C = new Creator<MovieDataModel>() {
        @Override
        public MovieDataModel createFromParcel(Parcel in) {
            return new MovieDataModel(in);
        }

        @Override
        public MovieDataModel[] newArray(int size) {
            return new MovieDataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResourceId);
        dest.writeString(overview);
        dest.writeInt(backImageRes);
        dest.writeString(releaseDate);
        dest.writeString(trailerUrl);
    }
}
