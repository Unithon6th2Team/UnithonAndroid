package org.androidtown.unithonandroid.Data;

import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by YTW on 2018. 1. 27..
 */

public class ToDoData implements Cloneable {

    private int cid, oid, tid, dayNum; //oid == ownerId , tid == targetId
    private String owner, contents, date, place, reward, target, dayChar;
    private boolean finished;
    public ToDoData(){}


    public ToDoData(int cid, int oid, int tid, String owner, String contents, String date, String place, String reward, String target) throws Exception {
        this.cid = cid;
        this.oid = oid;
        this.tid = tid;

        this.owner = owner;
        this.contents = contents;
        this.date = date;
        this.place = place;
        this.reward = reward;
        this.target = target;

        this.finished = false;

        dayChar = getDateDay(date, "yyyy-MM-dd");
        dayNum = getDayNum(date, "yyyy-MM-dd");
    }

    public int getDayNum(String date, String dateType) throws Exception{
        int dayNum;
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateType);
        Date nDate = dateFormat.parse(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(nDate);

        dayNum = cal.get(Calendar.DAY_OF_MONTH);

        return dayNum;
    }

    public static String getDateDay(String date, String dateType) throws Exception {

        String longDay = "";
        String shortDay = "";
        String result = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateType);
        Date nDate = dateFormat.parse(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(nDate);

        Calendar now = Calendar.getInstance();

        int nowChar = now.get(Calendar.DAY_OF_WEEK);

        int dayChar = cal.get(Calendar.DAY_OF_WEEK);


        switch (dayChar) {
            case 1:
                longDay = "일요일";
                shortDay = "일";
                break;
            case 2:
                longDay = "월요일";
                shortDay = "월";
                break;
            case 3:
                longDay = "화요일";
                shortDay = "화";
                break;
            case 4:
                longDay = "수요일";
                shortDay = "수";
                break;
            case 5:
                longDay = "목요일";
                shortDay = "목";
                break;
            case 6:
                longDay = "금요일";
                shortDay = "금";
                break;
            case 7:
                longDay = "토요일";
                shortDay = "토";
                break;

        }


        if(nowChar == dayChar)
            result += "오늘("+shortDay+")";
        else
            result = longDay;

        return result;
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

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public String getDayChar() {
        return dayChar;
    }

    public void setDayChar(String dayChar) {
        this.dayChar = dayChar;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
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
