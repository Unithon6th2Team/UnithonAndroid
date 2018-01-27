package org.androidtown.unithonandroid.ToDoList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import org.androidtown.unithonandroid.R;

public class ToDoListActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar toDoProgressBar, completedProgressBar, ownToDoProgressBar;
    FrameLayout btnToDoProgressBar, btnCompletedProgressBar, btnOwnToDoProgressBar;

    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        initialize();
        setUpListener();
    }

    private void initialize(){
        toDoProgressBar = (ProgressBar)findViewById(R.id.progress_to_do);
        completedProgressBar = (ProgressBar)findViewById(R.id.progress_completed);
        ownToDoProgressBar = (ProgressBar)findViewById(R.id.progress_own_to_do);
        btnToDoProgressBar = (FrameLayout)findViewById(R.id.btn_to_do_progress_bar);
        btnCompletedProgressBar = (FrameLayout)findViewById(R.id.btn_completed_progress_bar);
        btnOwnToDoProgressBar = (FrameLayout)findViewById(R.id.btn_own_to_do_progress_bar);


    }

    private void setUpListener(){
        btnToDoProgressBar.setOnClickListener(this);
        btnCompletedProgressBar.setOnClickListener(this);
        btnOwnToDoProgressBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_to_do_progress_bar :
                break;

            case R.id.btn_completed_progress_bar :
                break;

            case R.id.btn_own_to_do_progress_bar :
                break;
        }
    }
}
