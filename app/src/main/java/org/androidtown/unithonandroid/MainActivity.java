package org.androidtown.unithonandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.androidtown.unithonandroid.Fragment.ToDoMainFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewP;
    pagerAdapter adapter;
    ImageView tab_home;
    ImageView tab_todo;
    ImageView tab_chat;
    ImageView under_home;
    ImageView under_todo;
    ImageView under_chat;
    ArrayList<ImageView> tab = new ArrayList<ImageView>();
    ArrayList<ImageView> under = new ArrayList<ImageView>();
    ArrayList<int[]> color = new ArrayList<int[]>();
    ArrayList<Integer> resid = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewP = (ViewPager)findViewById(R.id.viewPager);
        tab_home = (ImageView)findViewById(R.id.tabHome);
        tab_todo = (ImageView)findViewById(R.id.tabTodo);
        tab_chat = (ImageView)findViewById(R.id.tabChat);
        under_home = (ImageView)findViewById(R.id.underHome);
        under_todo = (ImageView)findViewById(R.id.underTodo);
        under_chat = (ImageView)findViewById(R.id.underChat);
        setSrc();
        adapter = new pagerAdapter(getSupportFragmentManager());

        viewP.setAdapter(adapter);
        viewP.setCurrentItem(0);
    }

    View.OnClickListener movePageListener = new View.OnClickListener() {
        public void onClick(View v){
            int tag = (int)v.getTag();
            viewP.setCurrentItem(tag);
        }
    };

    private void setSrc(){
        tab.add(tab_home);
        tab.add(tab_todo);
        tab.add(tab_chat);
        under.add(under_home);
        under.add(under_todo);
        under.add(under_chat);
        color.add(new int[]{255, 87, 0});
        color.add(new int[]{252, 230, 76});
        color.add(new int[]{253, 230, 76});
        resid.add(R.mipmap.icon_navi_home_pr);
        resid.add(R.mipmap.todo);
        resid.add(R.mipmap.icon_navi_chat);
        TabHome.setArr(tab, under, color, resid);

        tab = new ArrayList<ImageView>();
        under = new ArrayList<ImageView>();
        color = new ArrayList<int[]>();
        resid = new ArrayList<Integer>();
        tab.add(tab_home);
        tab.add(tab_todo);
        tab.add(tab_chat);
        under.add(under_todo);
        under.add(under_home);
        under.add(under_chat);
        color.add(new int[]{255, 87, 0});
        color.add(new int[]{252, 230, 76});
        color.add(new int[]{253, 230, 76});
        resid.add(R.mipmap.icon_navi_home);
        resid.add(R.mipmap.icon_navi_todo);
        resid.add(R.mipmap.icon_navi_chat);
        TabTodo.setArr(tab, under, color, resid);

        tab = new ArrayList<ImageView>();
        under = new ArrayList<ImageView>();
        color = new ArrayList<int[]>();
        resid = new ArrayList<Integer>();
        tab.add(tab_home);
        tab.add(tab_todo);
        tab.add(tab_chat);
        under.add(under_chat);
        under.add(under_todo);
        under.add(under_home);
        color.add(new int[]{255, 87, 0});
        color.add(new int[]{252, 230, 76});
        color.add(new int[]{253, 230, 76});
        resid.add(R.mipmap.icon_navi_home);
        resid.add(R.mipmap.todo);
        resid.add(R.mipmap.icon_navi_chat_pr);
        TabChat.setArr(tab, under, color, resid);
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            setSrc();
            switch(position) {
                case 0 :
                    return new TabHome();
                case 1 :
                    return new ToDoMainFragment();
                case 2 :
                    return new TabChat();
                default:
                    return null;
            }
        }

        public int getCount() {
            return 3;
        }
    }
}
