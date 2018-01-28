package org.androidtown.unithonandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Park_Soo_Young on 2018. 1. 27..
 */

public class chatAdapter extends ArrayAdapter<chatData> {

    private final SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("a h:mm", Locale.getDefault());


    public chatAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            //if(){
            convertView = inflater.inflate(R.layout.activity_chat, null);
            // }

            viewHolder = new ViewHolder();
            viewHolder.mTxtUserName = convertView.findViewById(R.id.txt_userName);
            viewHolder.mTxtMessage = convertView.findViewById(R.id.txt_message);
            viewHolder.mTxtTime = convertView.findViewById(R.id.txt_time);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        chatData data = getItem(position);
        viewHolder.mTxtUserName.setText(data.userName);
        viewHolder.mTxtMessage.setText(data.message);
        viewHolder.mTxtTime.setText(mSimpleDateFormat.format(data.time));

        return convertView;
    }

    private class ViewHolder {
        private TextView mTxtUserName;
        private TextView mTxtMessage;
        private TextView mTxtTime;
    }
}
