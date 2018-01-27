package org.androidtown.unithonandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnHome, btnToDo, btnChatiing, btnAlbum, btnNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setUpListener();

    }

    private void initialize(){
        btnHome = (Button)findViewById(R.id.btn_home);
        btnToDo = (Button)findViewById(R.id.btn_to_do);
        btnChatiing = (Button)findViewById(R.id.btn_chatting);
        btnAlbum = (Button)findViewById(R.id.btn_album);
        btnNotification = (Button)findViewById(R.id.btn_notification);

    }

    private void setUpListener(){
        btnHome.setOnClickListener(this);
        btnToDo.setOnClickListener(this);
        btnChatiing.setOnClickListener(this);
        btnAlbum.setOnClickListener(this);
        btnNotification.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_home :

                break;

            case R.id.btn_to_do :

                break;

            case R.id.btn_chatting :

                break;

            case R.id.btn_album :

                break;

            case R.id.btn_notification :

                break;
        }
    }





}
