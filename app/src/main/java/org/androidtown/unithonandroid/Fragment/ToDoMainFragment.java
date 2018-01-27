package org.androidtown.unithonandroid.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import org.androidtown.unithonandroid.FragmentInFragment.CompletedFragment;
import org.androidtown.unithonandroid.FragmentInFragment.ToDoFragment;
import org.androidtown.unithonandroid.R;


public class ToDoMainFragment extends Fragment implements View.OnClickListener{
    FrameLayout btnToDoProgressBar, btnCompletedProgressBar, btnOwnToDoProgressBar;

    ProgressBar toDoProgressBar, completedProgressBar, ownToDoProgressBar;
    private final int FRAGMENT_TO_DO_LIST = 1;
    private final int FRAGMENT_COMPLETED_LIST = 2;
    private final int FRAGMENT_OWN_TO_DO_LIST = 3;


    public static ToDoMainFragment newInstance(){
        return new ToDoMainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do_main, container, false);

        initialize(view);
        setUpListener();

        return view;
    }

    private void initialize(View view){
        toDoProgressBar = (ProgressBar)view.findViewById(R.id.progress_to_do);
        completedProgressBar = (ProgressBar)view.findViewById(R.id.progress_completed);
        ownToDoProgressBar = (ProgressBar)view.findViewById(R.id.progress_own_to_do);

        btnToDoProgressBar = (FrameLayout)view.findViewById(R.id.btn_to_do_progress_bar);
        btnCompletedProgressBar = (FrameLayout)view.findViewById(R.id.btn_completed_progress_bar);
        btnOwnToDoProgressBar = (FrameLayout)view.findViewById(R.id.btn_own_to_do_progress_bar);

    }

    private void setUpListener(){
        btnToDoProgressBar.setOnClickListener(this);
        btnCompletedProgressBar.setOnClickListener(this);
        btnOwnToDoProgressBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment;
        switch (view.getId()){
            case R.id.btn_to_do_progress_bar :
                fragment = new ToDoFragment();
                setFragmentInFragment(fragment);
                break;
            case R.id.btn_completed_progress_bar :
                fragment = new CompletedFragment();
                setFragmentInFragment(fragment);
                break;
            case R.id.btn_own_to_do_progress_bar :
                break;

        }
    }

    private void setFragmentInFragment(Fragment childFragment) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();


        if (!childFragment.isAdded()) {
            childFt.replace(R.id.child_fragment_container, childFragment);
            childFt.addToBackStack(null);
            childFt.commit();
        }
    }
}
