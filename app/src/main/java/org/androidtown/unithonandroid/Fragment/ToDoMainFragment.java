package org.androidtown.unithonandroid.Fragment;


import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import org.androidtown.unithonandroid.Adapter.CompletedAdapter;
import org.androidtown.unithonandroid.Data.ApiResBody;
import org.androidtown.unithonandroid.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ToDoMainFragment extends Fragment implements View.OnClickListener {
    FrameLayout btnToDoProgressBar, btnCompletedProgressBar, btnOwnToDoProgressBar;

    ProgressBar toDoProgressBar, completedProgressBar, ownToDoProgressBar;
    private RecyclerView to_do_main_recyclerview;

    private final int FRAGMENT_TO_DO_LIST = 1;
    private final int FRAGMENT_COMPLETED_LIST = 2;
    private final int FRAGMENT_OWN_TO_DO_LIST = 3;
    public CompletedAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do_main, container, false);

        initialize(view);
        setUpListener();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        to_do_main_recyclerview.setLayoutManager(layoutManager);

        adapter = new CompletedAdapter(getActivity().getApplicationContext());
        to_do_main_recyclerview.setAdapter(adapter);

        return view;
    }

    private void initialize(View view) {
        toDoProgressBar = view.findViewById(R.id.progress_to_do);
        completedProgressBar = view.findViewById(R.id.progress_completed);
        ownToDoProgressBar = view.findViewById(R.id.progress_own_to_do);

        btnToDoProgressBar = view.findViewById(R.id.btn_to_do_progress_bar);
        btnCompletedProgressBar = view.findViewById(R.id.btn_completed_progress_bar);
        btnOwnToDoProgressBar = view.findViewById(R.id.btn_own_to_do_progress_bar);
        to_do_main_recyclerview = view.findViewById(R.id.to_do_main_recyclerview);
    }

    private void setUpListener() {
        btnToDoProgressBar.setOnClickListener(this);
        btnCompletedProgressBar.setOnClickListener(this);
        btnOwnToDoProgressBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onResume() {
        super.onResume();
        new MainTodoAsync().execute();
    }

    class MainTodoAsync extends AsyncTask<String, Void, ApiResBody[]> {

        @Override
        protected ApiResBody[] doInBackground(String... strings) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://s5on5p2ca0.execute-api.ap-northeast-2.amazonaws.com/prod")
                    .get()
                    .build();
            ApiResBody[] apiResBodies = new ApiResBody[0];
            try {
                Response response = client.newCall(request).execute();
                final String body = response.body().string();

                JSONObject jsonObject = new JSONObject(body);
                JSONArray array = jsonObject.getJSONArray("Items");

                final String temp = array.toString();

                Gson gson = new Gson();
                apiResBodies = gson.fromJson(temp, ApiResBody[].class);
                Log.e("api", String.valueOf(apiResBodies));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return apiResBodies;
        }

        @Override
        protected void onPostExecute(ApiResBody[] apiResBodies) {
            super.onPostExecute(apiResBodies);
            adapter.AddAllItem(apiResBodies);
        }
    }
}
