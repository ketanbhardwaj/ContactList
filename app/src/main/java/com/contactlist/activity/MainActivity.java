package com.contactlist.activity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.contactlist.R;
import com.contactlist.adapter.CallLogsAdapter;
import com.contactlist.base.AppConstants;
import com.contactlist.helper.AppUtil;
import com.contactlist.helper.BLog;
import com.contactlist.helper.PhonebookUtil;
import com.contactlist.helper.ViewUtil;
import com.contactlist.helper.retrofit.UenApiClient;
import com.contactlist.helper.retrofit.UenApiInterface;
import com.contactlist.model.CallLogsModel;
import com.contactlist.model.MovieResultResponse;
import com.contactlist.model.UpcomingMovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";
    private RecyclerView recyclerView;
    List<MovieResultResponse> items  = new ArrayList<>();
    private int page = 1;
    private CallLogsAdapter phonebookAdapter;
    private ProgressBar progressBar;

    private boolean loading = true;
    private int pastVisibleItems, visibleItemCount, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getUpcomingMoviesApi(true);
    }

    private void initViews(){
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = layoutManager.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                int[] firstVisibleItems = null;
                firstVisibleItems = layoutManager.findFirstVisibleItemPositions(firstVisibleItems);
                if(firstVisibleItems != null && firstVisibleItems.length > 0) {
                    pastVisibleItems = firstVisibleItems[0];
                }

                if (loading) {
                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        loading = false;
                        BLog.e("tag", "LOAD NEXT ITEM");
                        page++;
                        getUpcomingMoviesApi(false);
                    }
                }
            }
        });
        phonebookAdapter = new CallLogsAdapter(MainActivity.this, items);
        recyclerView.setAdapter(phonebookAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void getUpcomingMoviesApi(boolean showProgress){
        if(!AppUtil.check_internet(this, true, false)){
            return;
        }
        if(showProgress){
            ViewUtil.showLoadingProgressDialog(this);
        }else{
            progressBar.setVisibility(View.VISIBLE);
        }
        UenApiInterface apiService = UenApiClient.getClient().create(UenApiInterface.class);
        Call<UpcomingMovieResponse> call = apiService.getUpcomingMovies(AppConstants.API_KEY, AppConstants.LANG, String.valueOf(page));
        call.enqueue(new Callback<UpcomingMovieResponse>() {
            @Override
            public void onResponse(Call<UpcomingMovieResponse> call, Response<UpcomingMovieResponse> response) {
                BLog.e(LOG_TAG, "body - "+response.body());
                BLog.e(LOG_TAG, "url - "+call.request().url());
                if(response.body() != null){
                    if(response.body().getMovieResultResponses() != null){
//                        items = response.body().getMovieResultResponses();
                        items.addAll(response.body().getMovieResultResponses());
//                        phonebookAdapter = new CallLogsAdapter(MainActivity.this, items);
//                        recyclerView.setAdapter(phonebookAdapter);
                        phonebookAdapter.notifyDataSetChanged();
                    }

                }else{
                }
                progressBar.setVisibility(View.GONE);
                ViewUtil.hideLoadingProgressDialog();
            }

            @Override
            public void onFailure(Call<UpcomingMovieResponse> call, Throwable t) {
                BLog.e(LOG_TAG, "failure - "+call.request().url());
                progressBar.setVisibility(View.GONE);
                ViewUtil.hideLoadingProgressDialog();
            }
        });
    }


}
