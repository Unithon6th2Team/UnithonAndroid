package org.androidtown.unithonandroid.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidtown.unithonandroid.Data.ApiResBody;
import org.androidtown.unithonandroid.MyApplication;
import org.androidtown.unithonandroid.R;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by YTW on 2018. 1. 28..
 */

public class CompletedAdapter extends RecyclerView.Adapter<CompletedAdapter.ViewHolder> {
    private ArrayList<ApiResBody> completedList = new ArrayList<ApiResBody>();
    private Context context;

    public CompletedAdapter(Context context) {
        this.context = context;
    }

    public void AddAllItem(ApiResBody[] apiResBodies) {
        Collections.addAll(completedList, apiResBodies);
        notifyDataSetChanged();
    }

    public void AddItem(ApiResBody apiResBody) {
        completedList.add(apiResBody);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ApiResBody todo = completedList.get(position);

        if (todo != null) {
            try {
                holder.tvDayNum.setText(todo.getDate());
                holder.tvDayChar.setText(todo.getDayChars());
                holder.tvContents.setText(todo.getContent());
                holder.tvReward.setText(todo.getReward());

                Glide.with(context)
                        .load(MyApplication.Did2ImgSrc(todo.getOwner_id()))
                        .into(holder.owner);

                Glide.with(context)
                        .load(MyApplication.Did2ImgSrc(todo.getTarget_id()))
                        .into(holder.imgBtn_target);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return completedList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        //
        ImageButton owner, target1, target2, target3, imgBtn_target;
        TextView tvContents, tvReward, tvDayNum, tvDayChar;

        public ViewHolder(View itemView) {

            super(itemView);

            owner = (ImageButton) itemView.findViewById(R.id.imgBtn_owner);

            tvContents = (TextView) itemView.findViewById(R.id.tv_contents);
            tvReward = (TextView) itemView.findViewById(R.id.tv_reward);
            tvDayNum = (TextView) itemView.findViewById(R.id.tv_day_num);
            tvDayChar = (TextView) itemView.findViewById(R.id.tv_day_char);
            imgBtn_target = itemView.findViewById(R.id.imgBtn_target);
        }
    }
}
