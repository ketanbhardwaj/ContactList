package com.contactlist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ketan on 3/18/17.
 */

public class VideoResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("results")
    private List<VideoResultsResponse> movieResultResponses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<VideoResultsResponse> getMovieResultResponses() {
        return movieResultResponses;
    }

    public void setMovieResultResponses(List<VideoResultsResponse> movieResultResponses) {
        this.movieResultResponses = movieResultResponses;
    }
}
