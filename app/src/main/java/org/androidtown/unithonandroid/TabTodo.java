package org.androidtown.unithonandroid;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by sooo on 2018-01-28.
 */

public class TabTodo extends Fragment {

    public static ArrayList<ImageView> tab;
    public static ArrayList<ImageView> under;
    public static ArrayList<int[]> color;
    public static ArrayList<Integer> resId;

    public static void setArr(ArrayList<ImageView> t, ArrayList<ImageView> u, ArrayList<int[]> c, ArrayList<Integer> r) {
        tab = t;
        under = u;
        color = c;
        resId = r;
    }
    public TabTodo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.todo, container, false);
        return layout;
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            for (int i = 0; i < tab.size(); ){
                tab.remove(0).setImageResource(resId.remove(0));
            }
            for (int i = 0; i < under.size(); ){
                int[] rgb = color.remove(0);
                under.remove(0).setBackgroundColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
            }
        } else {
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
