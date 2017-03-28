package com.contactlist.viewholder;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.contactlist.R;
import com.facebook.drawee.view.SimpleDraweeView;

import de.hdodenhof.circleimageview.CircleImageView;

public class CallLogsViewHolder extends RecyclerView.ViewHolder {

    public CardView cardview;
    public TextView nameTxt, mobileTxt, emailTxt, lastContactTimeTxt, durationTxt;
    public SimpleDraweeView icon;
    Activity activity;

    public CallLogsViewHolder(View itemView, Activity activity) {
        super(itemView);
        this.activity = activity;
        icon = (SimpleDraweeView)itemView.findViewById(R.id.pic);
        nameTxt = (TextView)itemView.findViewById(R.id.name_txt);
        mobileTxt = (TextView) itemView.findViewById(R.id.mobile_txt);
        emailTxt = (TextView) itemView.findViewById(R.id.email_txt);
        cardview = (CardView) itemView.findViewById(R.id.cardview);
        lastContactTimeTxt = (TextView)itemView.findViewById(R.id.last_contact_time_txt);
        durationTxt = (TextView)itemView.findViewById(R.id.duration_txt);
    }

    public TextView getLastContactTimeTxt() {
        return lastContactTimeTxt;
    }

    public void setLastContactTimeTxt(TextView lastContactTimeTxt) {
        this.lastContactTimeTxt = lastContactTimeTxt;
    }

    public TextView getDurationTxt() {
        return durationTxt;
    }

    public void setDurationTxt(TextView durationTxt) {
        this.durationTxt = durationTxt;
    }

    public CardView getCardview() {
        return cardview;
    }

    public void setCardview(CardView cardview) {
        this.cardview = cardview;
    }

    public TextView getNameTxt() {
        return nameTxt;
    }

    public void setNameTxt(TextView nameTxt) {
        this.nameTxt = nameTxt;
    }

    public TextView getMobileTxt() {
        return mobileTxt;
    }

    public void setMobileTxt(TextView mobileTxt) {
        this.mobileTxt = mobileTxt;
    }

    public TextView getEmailTxt() {
        return emailTxt;
    }

    public void setEmailTxt(TextView emailTxt) {
        this.emailTxt = emailTxt;
    }

    public SimpleDraweeView getIcon() {
        return icon;
    }

    public void setIcon(SimpleDraweeView icon) {
        this.icon = icon;
    }
}
