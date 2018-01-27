package org.androidtown.unithonandroid.Data;

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
        return date;
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
