package com.example.guswn_000.san;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class temple_search extends ParentActivity {
    double position1,position2;
    String TempleName,  myogagsa, bomunsa, jeongbeobsa,
            deasungsa, inwangsa, hwagyesa, hogugjijangsa, gilsangsa,
            bongeunsa, jogyesa, bongwonsa, baeglyeonsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temple_search);


        ImageView iv_myogagsa = (ImageView) findViewById(R.id.iv_myogagsa);
        iv_myogagsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/myogagsa01";
                myogagsa = "묘각사";
                position1 = 37.5754820;
                position2 = 127.0187540;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",myogagsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_bomunsa = (ImageView) findViewById(R.id.iv_bomunsa);
        iv_bomunsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/bomunsa01";
                bomunsa ="보문사";
                position1 = 37.5844590;
                position2 = 127.0160870;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",bomunsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_jeongbeobsa = (ImageView) findViewById(R.id.iv_jeongbeobsa);
        iv_jeongbeobsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/jeongbeobsa01";
                jeongbeobsa = "정법사";
                position1 = 37.6017220;
                position2 = 126.9908480;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",jeongbeobsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_deasungsa = (ImageView) findViewById(R.id.iv_deasungsa);
        iv_deasungsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/deasungsa01";
                deasungsa = "대성사";
                position1 = 37.4760560;
                position2 = 127.0134380;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",deasungsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_inwangsa = (ImageView) findViewById(R.id.iv_inwangsa);
        iv_inwangsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/inwangsa01";
                inwangsa = "인왕사";
                position1 = 37.5786050;
                position2 = 126.9597030;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",inwangsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_hwagyesa = (ImageView) findViewById(R.id.iv_hwagyesa);
        iv_hwagyesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/hwagyesa01";
                hwagyesa = "화계사";
                position1 = 37.6325550;
                position2 = 127.0071470;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",hwagyesa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_hogugjijangsa = (ImageView) findViewById(R.id.iv_hogugjijangsa);
        iv_hogugjijangsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/hogugjijangsa01";
                hogugjijangsa = "호국지장사";
                position1 = 37.4987150;
                position2 = 126.9647190;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",hogugjijangsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_gilsangsa = (ImageView) findViewById(R.id.iv_gilsangsa);
        iv_gilsangsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/gilsangsa01";
                gilsangsa = "길상사";
                position1 = 37.5991320;
                position2 = 126.9942650;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",gilsangsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_bongeunsa = (ImageView) findViewById(R.id.iv_bongeunsa);
        iv_bongeunsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/bongeunsa01";
                bongeunsa = "봉은사";
                position1 = 37.5152010;
                position2 = 127.0574370;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",bongeunsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_jogyesa = (ImageView) findViewById(R.id.iv_jogyesa);
        iv_jogyesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/jogyesa01";
                jogyesa = "조계사";
                position1 = 37.5737850;
                position2 = 126.9818970;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",jogyesa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });
        ImageView iv_bongwonsa = (ImageView) findViewById(R.id.iv_bongwonsa);
        iv_bongwonsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/bongwonsa01";
                bongwonsa = "봉원사";
                position1 = 37.5718200;
                position2 = 126.9475880;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",bongwonsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });

        ImageView iv_baeglyeonsa = (ImageView) findViewById(R.id.iv_baeglyeonsa);
        iv_baeglyeonsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempleName = "http://over7000.dothome.co.kr/jul/baeglyeonsa01";
                baeglyeonsa = "백련사";
                position1 = 34.5877230;
                position2 = 126.7482080;
                Intent intent = new Intent(temple_search.this, temple_Information.class);
                intent.putExtra("key", TempleName);
                intent.putExtra("templename",baeglyeonsa);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(temple_search.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}