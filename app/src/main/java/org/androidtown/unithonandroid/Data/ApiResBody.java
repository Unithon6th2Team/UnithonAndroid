package org.androidtown.unithonandroid.Data;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LikeJust on 2018-01-28.
 */

public class ApiResBody {
    private String content, date, due, target_id, reward,
            level, place, name, owner_id;
    private int id;
    private boolean finished;

    public String getContent() {
        return content;
    }

    public String getDate() {
        String da = date.substring(8, 10);
        Log.e("dd", da);
        return da;
    }

    public String getDayChars() throws ParseException {
        String longDay = "";
        String shortDay = "";
        String result = "";
        SimpleDateFormat dateFormat
                = new SimpleDateFormat("yyyy-MM-dd");
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

        if (nowChar == dayChar)
            result += "오늘(" + shortDay + ")";
        else
            result = longDay;

        return result;
    }

    public String getDue() {
        return due;
    }

    public String getTarget_id() {
        return target_id;
    }

    public String getReward() {
        return reward;
    }

    public String getLevel() {
        return level;
    }

    public String getPlace() {
        return place;
    }

    public String getName() {
        return name;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public int getId() {
        return id;
    }

    public boolean isFinished() {
        return finished;
    }
}
