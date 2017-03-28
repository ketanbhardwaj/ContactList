package com.contactlist.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ketan on 3/17/17.
 */

public class MovieResultResponse implements Parcelable {

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("adult")
    private String adult;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("id")
    private String id;

    @SerializedName("original_title")
    private String original_title;

    @SerializedName("original_language")
    private String original_language;

    @SerializedName("title")
    private String title;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("vote_count")
    private String vote_count;

    @SerializedName("video")
    private String video;

    @SerializedName("vote_average")
    private String vote_average;

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.poster_path);
        dest.writeString(this.adult);
        dest.writeString(this.overview);
        dest.writeString(this.release_date);
        dest.writeString(this.id);
        dest.writeString(this.original_title);
        dest.writeString(this.original_language);
        dest.writeString(this.title);
        dest.writeString(this.backdrop_path);
        dest.writeString(this.popularity);
        dest.writeString(this.vote_count);
        dest.writeString(this.video);
        dest.writeString(this.vote_average);
    }

    public MovieResultResponse() {
    }

    protected MovieResultResponse(Parcel in) {
        this.poster_path = in.readString();
        this.adult = in.readString();
        this.overview = in.readString();
        this.release_date = in.readString();
        this.id = in.readString();
        this.original_title = in.readString();
        this.original_language = in.readString();
        this.title = in.readString();
        this.backdrop_path = in.readString();
        this.popularity = in.readString();
        this.vote_count = in.readString();
        this.video = in.readString();
        this.vote_average = in.readString();
    }

    public static final Creator<MovieResultResponse> CREATOR = new Creator<MovieResultResponse>() {
        @Override
        public MovieResultResponse createFromParcel(Parcel source) {
            return new MovieResultResponse(source);
        }

        @Override
        public MovieResultResponse[] newArray(int size) {
            return new MovieResultResponse[size];
        }
    };
}
