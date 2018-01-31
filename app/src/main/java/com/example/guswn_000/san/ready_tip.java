package com.example.guswn_000.san;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ready_tip extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_tip);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ready_tip.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

}
