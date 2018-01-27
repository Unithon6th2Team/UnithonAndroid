package org.androidtown.unithonandroid.FragmentInFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.androidtown.unithonandroid.Adapter.ToDoAdapter;
import org.androidtown.unithonandroid.Data.ToDoData;
import org.androidtown.unithonandroid.R;

import java.util.ArrayList;

public class ToDoFragment extends Fragment implements View.OnClickListener{
    private RecyclerView toDoView;


    private ArrayList<ToDoData> toDoList;
    int max;

    public static ToDoFragment newInstance(){
        return new ToDoFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do, container, false);
        initialize(view);

        return view;
    }

    private void initialize(View view){
        toDoView.setLayoutManager(new LinearLayoutManager(getContext()));

        // ... 추가해야함

    }

    @Override
    public void onResume() {
        super.onResume();

        refreshData();

    }

    private void refreshData(){
        toDoView.setAdapter(new ToDoAdapter(getContext(), toDoList));

    }

    @Override
    public void onClick(View view) {

    }
}
