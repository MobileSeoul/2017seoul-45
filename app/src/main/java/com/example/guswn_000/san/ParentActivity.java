package com.example.guswn_000.san;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class ParentActivity extends AppCompatActivity {
    private ActivityManager am = ActivityManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        am.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        am.removeActivity(this);
    }
}
