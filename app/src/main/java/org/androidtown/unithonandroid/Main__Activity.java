package org.androidtown.unithonandroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.androidtown.unithonandroid.Fragment.ToDoMainFragment;

public class Main__Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btnHome, btnToDo, btnChatiing, btnAlbum, btnNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity___main);

        initialize();
        setUpListener();

    }

    private void initialize() {
        btnHome = findViewById(R.id.btn_home);
        btnToDo = findViewById(R.id.btn_to_do);
        btnChatiing = findViewById(R.id.btn_chatting);
        btnAlbum = findViewById(R.id.btn_album);
        btnNotification = findViewById(R.id.btn_notification);

    }

    private void setUpListener() {
        btnHome.setOnClickListener(this);
        btnToDo.setOnClickListener(this);
        btnChatiing.setOnClickListener(this);
        btnAlbum.setOnClickListener(this);
        btnNotification.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:

                break;

            case R.id.btn_to_do:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                ToDoMainFragment toDoMainFragment = new ToDoMainFragment();
//                fragmentTransaction.add(R.id.main_todo_frame, toDoMainFragment);
                fragmentTransaction.commit();

                break;

            case R.id.btn_chatting:

                break;

            case R.id.btn_album:

                break;

            case R.id.btn_notification:

                break;
        }
    }
}
