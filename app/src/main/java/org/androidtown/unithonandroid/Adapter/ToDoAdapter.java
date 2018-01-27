package org.androidtown.unithonandroid.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.androidtown.unithonandroid.Data.ToDoData;
import org.androidtown.unithonandroid.R;

import java.util.ArrayList;

/**
 * Created by YTW on 2018. 1. 27..
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>{

    private ArrayList<ToDoData> todoList = new ArrayList<ToDoData>();
    private Context context;

    public ToDoAdapter(Context context, ArrayList<ToDoData> toDoList) {

        this.context = context;
        this.todoList = toDoList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ToDoData todo = todoList.get(position);

        if(todo != null){

            switch (todo.getOid()){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
            holder.tvDayNum.setText(todo.getDayNum());
            holder.tvDayChar.setText(todo.getDayChar());
            holder.tvContents.setText(todo.getContents());
            holder.tvReward.setText(todo.getReward());
        }
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }




    class ViewHolder extends RecyclerView.ViewHolder{
        //
        ImageButton owner, target1, target2, target3;
        TextView tvContents, tvReward, tvDayNum, tvDayChar;
        public ViewHolder(View itemView) {

            super(itemView);

            owner = (ImageButton)itemView.findViewById(R.id.imgBtn_owner);

            tvContents = (TextView)itemView.findViewById(R.id.tv_contents);
            tvContents.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "yoongothic740.ttf"));
            tvReward = (TextView)itemView.findViewById(R.id.tv_reward);
            tvReward.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "yoongothic740.ttf"));
            tvDayNum = (TextView)itemView.findViewById(R.id.tv_day_num);
            tvDayNum.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "HurmeGeometricSans1.otf"));
            tvDayChar = (TextView)itemView.findViewById(R.id.tv_day_char);
            tvReward.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "yoongothic740.ttf"));

        }



    }

}
