package org.androidtown.unithonandroid.ToDoList;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import org.androidtown.unithonandroid.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InsertToDoActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    private int year, month, day, hour, min;
    private EditText editContents, editReward;


    private TimePickerDialog timeDialog;
    private DatePickerDialog dateDialog;
    private int timeSelected, dateSelected;
    private Calendar dateAndTime;



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



        private void initialize() {
            editContents = (EditText) findViewById(R.id.edit_contents);
            editReward = (EditText) findViewById(R.id.edit_reward);


                    tvStartDate = (TextView) findViewById(R.id.tv_start_date);
            tvStartTime = (TextView) findViewById(R.id.tv_start_time);
            tvEndDate = (TextView) findViewById(R.id.tv_end_date);
            tvEndTime = (TextView) findViewById(R.id.tv_end_time);


                    dateAndTime = Calendar.getInstance();

            GregorianCalendar calendar = new GregorianCalendar();
            year = calendar.get(calendar.YEAR);
            month = calendar.get(calendar.MONTH);
            day = calendar.get(calendar.DAY_OF_MONTH);
            hour = calendar.get(calendar.HOUR_OF_DAY);
            min = calendar.get(calendar.MINUTE);


            timeDialog = new TimePickerDialog(this,  TimePickerDialog.THEME_HOLO_LIGHT, this, 15, 24, false);
            dateDialog = new DatePickerDialog(this, DatePickerDialog.THEME_HOLO_LIGHT, this, dateAndTime.get(Calendar.YEAR), dateAndTime.get(Calendar.MONTH), dateAndTime.get(Calendar.DAY_OF_MONTH));
        }

    private void setUpListener() {
        btnSave.setOnClickListener(this);
        tvStartDate.setOnClickListener(this);
        tvStartTime.setOnClickListener(this);
        tvEndDate.setOnClickListener(this);
        tvEndTime.setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        switch(dateSelected) {
            case 0:
                try {
                    tvStartDate.setText(year + "." + getMonth(month) + "." + dayOfMonth + "(" + getDateDay(year + "-" + getMonth(month) + "-" + dayOfMonth, "yyyy-MM-dd") + ")");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    tvEndDate.setText(year + "." + getMonth(month) + "." + dayOfMonth + "(" + getDateDay(year + "-" + getMonth(month) + "-" + dayOfMonth, "yyyy-MM-dd") + ")");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        switch(timeSelected) {
            case 0:
                tvStartTime.setText(hourOfDay + "시 " + minute + "분");
                break;
            case 1:
                tvEndTime.setText(hourOfDay + "시 " + minute + "분");
                break;
        }
    }

    /**
     * 특정 날짜에 대하여 요일을 구함(일 ~ 토)
     * @param date
     * @param dateType
     * @return
     * @throws Exception
     */
    public String getDateDay(String date, String dateType) throws Exception {


        String day = "" ;

        SimpleDateFormat dateFormat = new SimpleDateFormat(dateType) ;
        Date nDate = dateFormat.parse(date) ;

        Calendar cal = Calendar.getInstance() ;
        cal.setTime(nDate);

        int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;

        switch(dayNum){
            case 1:
                day = "일";
                break ;
            case 2:
                day = "월";
                break ;
            case 3:
                day = "화";
                break ;
            case 4:
                day = "수";
                break ;
            case 5:
                day = "목";
                break ;
            case 6:
                day = "금";
                break ;
            case 7:
                day = "토";
                break ;

        }

        return day ;
    }


    private String getMonth(int month) {
        int realMonth = month + 1;
        String result = "";
        if ( realMonth < 10 ) {
            result = "0" + realMonth;
        }
        else {
            result = realMonth + "";
        }
        return result;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_contents:

                break;

            case R.id.tv_start_date :
                dateSelected = 0;
                dateDialog.show();
                break;

            case R.id.tv_start_time :
                timeSelected = 0;
                timeDialog.show();
                break;

            case R.id.tv_end_date :
                dateSelected = 1;
                dateDialog.show();
                break;

            case R.id.tv_end_time :
                timeSelected = 1;
                timeDialog.show();


        }
    }
}
