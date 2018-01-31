package com.example.guswn_000.san;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

public class mountain_search extends ParentActivity {
    double position1,position2;
    String trail1,trail2,trail3,SanName, weather, goanac, surac, dobong,
    bulam, inking, bucac, woomyun, dragon, gehwasan, youngwang, namsan, demo, woojang, youngbong, ilja, gooroung, acha, ansan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mountain_search);

        ImageView iv_goanac = (ImageView) findViewById(R.id.iv_goanac);
        iv_goanac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/goanacsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09620735";
                trail1 = "http://over7000.dothome.co.kr/ridge/goanacroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/goanacroad02";
                trail3 = "http://over7000.dothome.co.kr/ridge/goanacroad03";
                goanac = "관악산";
                position1 = 37.4449834;
                position2 = 126.9643494;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",goanac);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_surac = (ImageView) findViewById(R.id.iv_surac);
        iv_surac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/suracsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09350105";
                trail1 = "http://over7000.dothome.co.kr/ridge/suracroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/suracroad02";
                trail3 = "";
                surac ="수락산";
                position1 = 37.6994242;
                position2 = 127.0819032;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",surac);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_dobong = (ImageView) findViewById(R.id.iv_dobong);
        iv_dobong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/dobongsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09320108";
                trail1 = "http://over7000.dothome.co.kr/ridge/dobongroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/dobongroad02";
                trail3 = "";
                dobong = "도봉산";
                position1 = 37.7017543;
                position2 = 127.0152548;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",dobong);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_bulam = (ImageView) findViewById(R.id.iv_bulam);
        iv_bulam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/bulamsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09350105";
                trail1 = "http://over7000.dothome.co.kr/ridge/bulamroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/bulamroad02";
                trail3 = "";
                bulam = "불암산";
                position1 = 37.6641144; //좌표
                position2 = 127.0969741;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",bulam);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_inking = (ImageView) findViewById(R.id.iv_inking);
        iv_inking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/inkingsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09110187";
                trail1 = "http://over7000.dothome.co.kr/ridge/inkingroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/inkingroad02";
                trail3 = "";
                inking = "인왕산";
                position1 = 37.5854591;
                position2 = 126.9577590;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",inking);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_bucac = (ImageView) findViewById(R.id.iv_bucac);
        iv_bucac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/bucacsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09110184";
                trail1 = "http://over7000.dothome.co.kr/ridge/bucacroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/bucacroad02";
                trail3 = "";
                bucac = "북악산";
                position1 = 37.5936405;
                position2 = 126.9741528;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",bucac);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_woomyun = (ImageView) findViewById(R.id.iv_woomyun);
        iv_woomyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/woomyunsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09650108";
                trail1 = "http://over7000.dothome.co.kr/ridge/woomyunroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/woomyunroad02";
                trail3 = "";
                woomyun = "우면산";
                position1 = 37.4716675;
                position2 = 127.0084569;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",woomyun);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_dragon = (ImageView) findViewById(R.id.iv_dragon);
        iv_dragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/dragonsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09260101";
                trail1 = "http://over7000.dothome.co.kr/ridge/dragonroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/dragonroad02";
                trail3 = "";
                dragon = "용마산";
                position1 = 37.5710303;
                position2 = 127.0959158;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",dragon);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_gehwasan = (ImageView) findViewById(R.id.iv_gehwasan);
        iv_gehwasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/gehwasan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09500110";
                trail1 = "http://over7000.dothome.co.kr/ridge/gehwaroad01";
                trail2 = "";
                trail3 = "";
                gehwasan = "개화산";
                position1 = 37.5826590;
                position2 = 126.8057129;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",gehwasan);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_youngwang = (ImageView) findViewById(R.id.iv_youngwang);
        iv_youngwang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/youngwangsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09470102";
                trail1 = "http://over7000.dothome.co.kr/ridge/youngwangroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/youngwangroad02";
                trail3 = "";
                youngwang = "용왕산";
                position1 = 37.5445018;
                position2 = 126.8786158;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",youngwang);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_namsan = (ImageView) findViewById(R.id.iv_namsan);
        iv_namsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/namsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09140121";
                trail1 = "http://over7000.dothome.co.kr/ridge/namroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/namroad02";
                trail3 = "";
                namsan = "남산";
                position1 = 37.5494720;
                position2 = 126.9907547;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",namsan);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });

        ImageView iv_demo = (ImageView) findViewById(R.id.iv_demo);
        iv_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/demosan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09680103";
                trail1 = "http://over7000.dothome.co.kr/ridge/demoroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/demoroad02";
                trail3 = "";
                demo = "대모산";
                position1 = 37.4752044;
                position2 = 127.0798780;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",demo);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_woojang = (ImageView) findViewById(R.id.iv_woojang);
        iv_woojang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/woojangsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09500103";
                trail1 = "http://over7000.dothome.co.kr/ridge/woojangroad01";
                trail2 = "";
                trail3 = "";
                woojang = "우장산";
                position1 = 37.5510401;
                position2 = 126.8415595;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",woojang);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_youngbong = (ImageView) findViewById(R.id.iv_youngbong);
        iv_youngbong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/youngbongsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09200108";
                trail1 = "http://over7000.dothome.co.kr/ridge/youngbongroad01";
                trail2 = "";
                trail3 = "";
                youngbong = "응봉산";
                position1 = 37.5482110;
                position2 = 127.0295471;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",youngbong);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_ilja = (ImageView) findViewById(R.id.iv_ilja);
        iv_ilja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/iljasan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09740105";
                trail1 = "http://over7000.dothome.co.kr/ridge/iljaroad01";
                trail2 = "";
                trail3 = "";
                ilja = "일자산";
                position1 = 37.5296671;
                position2 = 127.1507520;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",ilja);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_gooroung = (ImageView) findViewById(R.id.iv_gooroung);
        iv_gooroung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/gooroungsan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09650110";
                trail1 = "http://over7000.dothome.co.kr/ridge/gooroungroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/gooroungroad02";
                trail3 = "http://over7000.dothome.co.kr/ridge/gooroungroad03";
                gooroung = "구룡산";
                position1 = 37.4689286;
                position2 = 127.0611058;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",gooroung);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_acha = (ImageView) findViewById(R.id.iv_acha);
        iv_acha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/achasan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09215104";
                trail1 = "http://over7000.dothome.co.kr/ridge/acharoad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/acharoad02";
                trail3 = "http://over7000.dothome.co.kr/ridge/acharoad03";
                acha = "아차산";
                position1 = 37.5670020;
                position2 = 127.1026687;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",acha);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
        ImageView iv_ansan = (ImageView) findViewById(R.id.iv_ansan);
        iv_ansan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanName = "http://over7000.dothome.co.kr/drawable/ansan01";
                weather = "http://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=09410115";
                trail1 = "http://over7000.dothome.co.kr/ridge/anroad01";
                trail2 = "http://over7000.dothome.co.kr/ridge/anroad02";
                trail3 = "";
                ansan = "안산";
                position1 = 37.5771772;
                position2 = 126.9448283;
                Intent intent = new Intent(mountain_search.this, mountain_Information.class);
                intent.putExtra("key", SanName);
                intent.putExtra("key2", weather);
                intent.putExtra("sanname",ansan);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("trail1",trail1);
                intent.putExtra("trail2",trail2);
                intent.putExtra("trail3",trail3);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(mountain_search.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}