package com.contactlist.helper.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UenApiClient {
    private static final String LOG_TAG = "UenApiClient";
    public static String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/";
    private static Retrofit mRetrofit = null;
    private static Gson gson;


    public static Retrofit getClient(){
        if(gson == null){
            gson = new GsonBuilder()
                    .setLenient()
                    .create();
        }
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return mRetrofit;
    }

}
