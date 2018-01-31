package com.example.guswn_000.san;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class temple_manners extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_manners);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(temple_manners.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
