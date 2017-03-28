package com.contactlist.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.contactlist.R;
import com.contactlist.helper.BLog;
import com.contactlist.helper.retrofit.UenApiClient;
import com.contactlist.model.CallLogsModel;
import com.contactlist.model.MovieResultResponse;
import com.contactlist.viewholder.CallLogsViewHolder;

import java.util.List;

/**
 * Created by Ketan on 3/19/17.
 */

public class CallLogsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String LOG_TAG = "CallLogsAdapter";
    private List<MovieResultResponse> itemList;
    Activity activity;

    public CallLogsAdapter(Activity activity, List<MovieResultResponse> itemList) {
        this.itemList = itemList;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v2 = inflater.inflate(R.layout.call_log_item_layout, parent, false);
        viewHolder = new CallLogsViewHolder(v2, activity);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CallLogsViewHolder vh2 = (CallLogsViewHolder) holder;
        MovieResultResponse phonebookModel = itemList.get(position);
        if(phonebookModel.getPoster_path() != null){
            Uri pic = Uri.parse(phonebookModel.getPoster_path());
            BLog.e(LOG_TAG, "uri - "+pic);
            if (pic != null) {
                Uri uri = Uri.parse(UenApiClient.BASE_IMAGE_URL + pic);
                vh2.getIcon().setImageURI(uri);
            } else {
                vh2.getIcon().setImageResource(R.mipmap.pro_pic_ic);
            }
        }else{
            vh2.getIcon().setImageResource(R.mipmap.pro_pic_ic);
        }
        vh2.getNameTxt().setText(phonebookModel.getTitle());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
