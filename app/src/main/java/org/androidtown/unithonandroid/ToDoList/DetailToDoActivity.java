package org.androidtown.unithonandroid.ToDoList;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.androidtown.unithonandroid.R;

public class DetailToDoActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView viewContents, viewDate, viewPlace, viewReward;
    private Button btnDelete, btnEdit;
    private static Typeface typeface; //서


//    @Override
//    public void setContentView(int layoutResID) {
//        super.setContentView(layoutResID);
//        if(typeface == null) {
//            typeface = Typeface.createFromAsset(this.getAssets(), "BMHANNA_11yrs_ttf.ttf");
//        }
//        setGlobalFont(getWindow().getDecorView());
//    }
//
//    private void setGlobalFont(View view) {
//        if(view != null) {
//            if(view instanceof ViewGroup) {
//                ViewGroup viewGroup = (ViewGroup)view;
//                int vgCnt = viewGroup.getChildCount();
//                for(int i = 0; i<vgCnt; i++) {
//                    View v = viewGroup.getChildAt(i);
//                    if(v instanceof TextView) {
//                        ((TextView) v).setTypeface(typeface);
//                    }
//                    setGlobalFont(v);
//                }
//            }
//        }
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_to_do);

        initialize();
        setUpListener();
    }

    private void initialize(){
        viewContents = (TextView)findViewById(R.id.view_contents);
        viewDate = (TextView)findViewById(R.id.view_date);
        viewPlace = (TextView)findViewById(R.id.view_place);
        viewReward = (TextView)findViewById(R.id.view_reward);
        btnDelete = (Button)findViewById(R.id.btn_delete);
        btnEdit = (Button)findViewById(R.id.btn_edit);

    }

    private void setUpListener(){
        btnDelete.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_delete:
                break;

            case R.id.btn_edit:
                break;
        }
    }
}
