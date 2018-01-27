package org.androidtown.unithonandroid.ToDoList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidtown.unithonandroid.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class InsertToDoActivity extends AppCompatActivity implements View.OnClickListener {
    private int year, month, day, hour, min;
    private EditText editContents, editDate, editPlace, editReward;
    private TextView tvStartDate, tvStartTime, tvEndDate, tvEndTime;
    private Button btnSave;
    private Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_to_do);

        initialize();
        setUpListener();
    }

    private void initialize(){
        editContents = (EditText)findViewById(R.id.edit_contents);
        editDate = (EditText)findViewById(R.id.edit_date);
        editPlace = (EditText)findViewById(R.id.edit_place);
        editReward = (EditText)findViewById(R.id.edit_reward);

        tvStartDate = (TextView)findViewById(R.id.tv_start_date);
        tvStartTime = (TextView)findViewById(R.id.tv_start_time);
        tvEndDate = (TextView)findViewById(R.id.tv_end_date);
        tvEndTime = (TextView)findViewById(R.id.tv_end_time);

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        day= calendar.get(calendar.DAY_OF_MONTH);
        hour = calendar.get(calendar.HOUR_OF_DAY);
        min = calendar.get(calendar.MINUTE);

    }

    private void setUpListener(){
        btnSave.setOnClickListener(this);
        tvStartDate.setOnClickListener(this);
        tvStartTime.setOnClickListener(this);
        tvEndDate.setOnClickListener(this);
        tvEndTime.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_contents :

                break;

            case R.id.tv_start_date :

                break;

            case R.id.tv_start_time :

                break;

            case R.id.tv_end_date :

                break;

            case R.id.tv_end_time :

                break;

            case R.id.edit_reward :

                break;

        }
    }
}
