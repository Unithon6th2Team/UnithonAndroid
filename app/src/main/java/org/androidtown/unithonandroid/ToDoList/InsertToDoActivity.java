package org.androidtown.unithonandroid.ToDoList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.androidtown.unithonandroid.R;

public class InsertToDoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editContents, editDate, editPlace, editReward;
    private Button btnSave;
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
        btnSave = (Button)findViewById(R.id.btn_save);
    }

    private void setUpListener(){
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_Contents :
                break;
            case R.id.edit_Date :
                break;
            case R.id.edit_Place :
                break;
            case R.id.edit_Reward :
                break;
            case R.id.btn_save:
                break;
        }
    }
}
