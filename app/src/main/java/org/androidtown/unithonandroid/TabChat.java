package org.androidtown.unithonandroid;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by sooo on 2018-01-28.
 */

public class TabChat extends Fragment implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static ArrayList<ImageView> tab;
    public static ArrayList<ImageView> under;
    public static ArrayList<int[]> color;
    public static ArrayList<Integer> resId;

    // Firebase
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;
    // Views
    private ListView mListView;
    private EditText mEdtMessage;
    // Values
    private chatAdapter mAdapter;
    private String userName;
    private String user;

    public static final int REQUEST_READ_PHONE_STATE = 0;
    private static final String TAG = "MyFirebaseIIDService";

    public static ArrayList<chatData> chatDataArrayList = new ArrayList<>();

    private Button tempBtn;

    public static void setArr(ArrayList<ImageView> t, ArrayList<ImageView> u, ArrayList<int[]> c, ArrayList<Integer> r) {
        tab = t;
        under = u;
        color = c;
        resId = r;
    }

    public TabChat() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_chat, container, false);

        initFirebaseDatabase();
        mListView = (ListView) view.findViewById(R.id.list);
        mAdapter = new chatAdapter(getContext(), 0);
        mListView.setAdapter(mAdapter);

        mEdtMessage = (EditText) view.findViewById(R.id.etText);
        view.findViewById(R.id.btnSend).setOnClickListener(this);

        return view;
    }


    private void initFirebaseDatabase() {
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        String value = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "token=" + value);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("message");

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                chatData data = dataSnapshot.getValue(chatData.class);
                data.firebaseKey = dataSnapshot.getKey();

                chatDataArrayList.add(data);
                mAdapter.add(data);
                mListView.smoothScrollToPosition(mAdapter.getCount());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String firebaseKey = dataSnapshot.getKey();
                int count = mAdapter.getCount();
                for (int i = 0; i < count; i++) {
                    if (mAdapter.getItem(i).firebaseKey.equals(firebaseKey)) {
                        mAdapter.remove(mAdapter.getItem(i));
                        break;
                    }
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        mDatabaseReference.addChildEventListener(mChildEventListener);
    }

    @SuppressLint("MissingPermission")
    private String GetDevicesUUID(Context mContext) {
        final TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(getActivity().getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String device = deviceUuid.toString();
        return device;
    }


    private void initValues() {
        int permissionCheck = ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.READ_PHONE_STATE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        } else {
            //TODO
        }

        user = GetDevicesUUID(getActivity().getApplicationContext());
        userName = "Guest" + user;

        //등록자(엄마 아들 아빠 등) 설정하면 uuide로 switch 문 설정

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mDatabaseReference.removeEventListener(mChildEventListener);
    }

    @Override
    public void onClick(View v) {
        String message = mEdtMessage.getText().toString();
        if (!TextUtils.isEmpty(message)) {
            mEdtMessage.setText("");
            chatData data = new chatData();
            data.userName = userName;
            data.message = message;
            data.time = System.currentTimeMillis();
            data.deviceId = user;
            mDatabaseReference.push().setValue(data);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    //TODO
                }
                break;

            default:
                break;
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            for (int i = 0; i < tab.size(); ) {
                tab.remove(0).setImageResource(resId.remove(0));
            }
            for (int i = 0; i < under.size(); ) {
                int[] rgb = color.remove(0);
                under.remove(0).setBackgroundColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
            }
        } else {
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
