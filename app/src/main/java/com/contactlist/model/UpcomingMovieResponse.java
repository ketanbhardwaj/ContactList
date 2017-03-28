package com.contactlist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ketan on 3/17/17.
 */

public class UpcomingMovieResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("results")
    private List<MovieResultResponse> movieResultResponses;

    @SerializedName("total_pages")
    private String total_pages;

    @SerializedName("total_results")
    private String total_results;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<MovieResultResponse> getMovieResultResponses() {
        return movieResultResponses;
    }

    public void setMovieResultResponses(List<MovieResultResponse> movieResultResponses) {
        this.movieResultResponses = movieResultResponses;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }
}
