package org.androidtown.unithonandroid.Data;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by YTW on 2018. 1. 27..
 */

public class ToDoData implements Cloneable {

    private int cid, oid, tid; //oid == ownerId , tid == targetId
    private String owner, contents, date, place, reward, target;

    public ToDoData(){}


    public ToDoData(int cid, int oid, int tid, String owner, String contents, String date, String place, String reward, String target) {
        this.cid = cid;
        this.oid = oid;
        this.tid = tid;
        this.owner = owner;
        this.contents = contents;
        this.date = date;
        this.place = place;
        this.reward = reward;
        this.target = target;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isValid(Context context){
        if(contents == null){
            Toast.makeText(context, "할 일을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return false;
        } else if(date == null){
            Toast.makeText(context, "날짜를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return false;
        } else{
            return true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        ToDoData todo = (ToDoData)obj;
        boolean result = true;

        if(this.contents == null){
            result = result && this.contents == todo.contents;
        } else{
            result = result && this.contents.equals(todo.contents);
        }

        if (this.date == null) {
            result &= this.date == todo.date;
        } else {
            result &= this.date.equals(todo.date);
        }


        if (this.place == null) {
            result &= this.place == todo.place;
        } else {
            result &= this.place.equals(todo.place);
        }


        if (this.reward == null) {
            result &= this.reward == todo.reward;
        } else {
            result &= this.reward.equals(todo.reward);
        }

        if (this.target == null) {
            result &= this.target == todo.target;
        } else {
            result &= this.target.equals(todo.target);
        }

        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ToDoData todo = (ToDoData)super.clone();

        todo.owner = this.owner;
        todo.contents = this.contents;
        todo.date = this.date;
        todo.place = this.place;
        todo.reward = this.reward;
        todo.target = this.target;

        return todo;
    }
}
