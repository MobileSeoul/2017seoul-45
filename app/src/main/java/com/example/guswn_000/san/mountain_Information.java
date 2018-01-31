package com.example.guswn_000.san;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;

public class mountain_Information extends ParentActivity
        implements View.OnTouchListener,NavigationView.OnNavigationItemSelectedListener {
    Handler handler = new Handler();  // 외부쓰레드 에서 메인 UI화면을 그릴때 사용
    mountain_Information.phpdo task;
    TextView introducetv;
    float down_x;
    float up_x;
    String[] imageItems;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mountain_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final int mI = 123;

        Intent intent = getIntent();
        final String sanname = intent.getStringExtra("sanname");
        final double position1 = intent.getDoubleExtra("position1",1);
        final double position2 = intent.getDoubleExtra("position2",1);
        final String trail1 = intent.getStringExtra("trail1");
        final String trail2 = intent.getStringExtra("trail2");
        final String trail3 = intent.getStringExtra("trail3");


        ImageView map_go = (ImageView) findViewById(R.id.map_go);
        map_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mountain_Information.this, map.class);
                intent.putExtra("sanname",sanname);
                intent.putExtra("position1",position1);
                intent.putExtra("position2",position2);
                intent.putExtra("ml",mI);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                if(trail2.equals("") && trail3.equals("")){
                    imageItems = new String[] { trail1 };
                } else if(trail3.equals("")) {
                    imageItems = new String[] { trail1,trail2 };
                } else {
                    imageItems = new String[] { trail1,trail2,trail3 };
                }

                // TODO Auto-generated method stub
                try {
                    // 걍 외우는게 좋다 -_-;
                    for (String i : imageItems) {
                        final ImageView image = new ImageView(mountain_Information.this);
                        URL url = new URL(i + ".png");
                        InputStream is = url.openStream();
                        final Bitmap bm = BitmapFactory.decodeStream(is);
                        handler.post(new Runnable() {

                            @Override
                            public void run() {  // 화면에 그려줄 작업
                                image.setImageBitmap(bm);
                            }
                        });
                        image.setImageBitmap(bm);
                        flipper.addView(image, new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));
                    } //비트맵 객체로 보여주기

                    flipper.setOnTouchListener(mountain_Information.this);
                } catch (Exception e) {
                }

            }
        });


        t2.start();


        ////////////////////////////산소개///////////////////////
        task = new mountain_Information.phpdo();


        task.execute(sanname);
        setTitle(sanname);
        introducetv = (TextView) findViewById(R.id.introducetv);

/////////////////////이미지 테스트////////////////////////////////
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                String str = getIntent().getStringExtra("key");
                // TODO Auto-generated method stub
                try {
                    // 걍 외우는게 좋다 -_-;
                    final ImageView iv = (ImageView) findViewById(R.id.imageView01);
                    URL url = new URL(str + ".png");
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    handler.post(new Runnable() {

                        @Override
                        public void run() {  // 화면에 그려줄 작업
                            iv.setImageBitmap(bm);
                        }
                    });
                    iv.setImageBitmap(bm); //비트맵 객체로 보여주기
                } catch (Exception e) {

                }

            }
        });

        t.start();

        //날씨 정보 가져오기

        TextView oneday1 = (TextView) findViewById(R.id.oneday_1);
        TextView oneday2 = (TextView) findViewById(R.id.oneday_2);

        TextView twoday1 = (TextView) findViewById(R.id.twoday_1);
        TextView twoday2 = (TextView) findViewById(R.id.twoday_2);
        TextView threeday1 = (TextView) findViewById(R.id.threeday_1);
        TextView fourday1 = (TextView) findViewById(R.id.fourday_1);
        TextView fiveday1 = (TextView) findViewById(R.id.fiveday_1);
        TextView sixday1 = (TextView) findViewById(R.id.sixday_1);
        TextView sevenday1 = (TextView) findViewById(R.id.sevenday_1);

        TextView day_3 = (TextView) findViewById(R.id.day_3);
        TextView day_4 = (TextView) findViewById(R.id.day_4);
        TextView day_5 = (TextView) findViewById(R.id.day_5);
        TextView day_6 = (TextView) findViewById(R.id.day_6);
        TextView day_7 = (TextView) findViewById(R.id.day_7);

        WeatherConnection weatherConnection = new WeatherConnection();
        AsyncTask<Object, Object, String[]> result = weatherConnection.execute("", "");
        System.out.println("RESULT");
        try {

            String[] msg = result.get();

            String a0 = msg[0];
            String aa0 = a0.substring(0, a0.indexOf("℃")).replaceAll(" ", "") + ".0℃";


            String a1 = msg[1];
            String[] arr = a1.split(" ");
            //arr[0]=오늘 arr[1]=9.14.오전 arr[2]=13.0'c arr[3]=맑음 arr[4]=강수확률 arr[5]=0% arr[6]=오후 arr[7]=27도

            String a2 = msg[2];
            String[] arr2 = a2.split(" ");

            String a3 = msg[3];
            int idx2 = a3.indexOf("오전");
            int idx3 = a3.indexOf("오후");
            String[] arr3 = a3.split(" ");
            day_3.setText(arr3[0]);
            String aa3 = a3.substring(idx2 + 2, a3.indexOf("℃")) + "℃" + "/" + a3.substring(idx3 + 2, a3.lastIndexOf("℃")).replaceAll(" ", "") + "℃";


            String a4 = msg[4];
            int idx4 = a4.indexOf("오전");
            int idx5 = a4.indexOf("오후");
            String[] arr4 = a4.split(" ");
            day_4.setText(arr4[0]);
            String aa4 = a4.substring(idx4 + 2, a4.indexOf("℃")) + "℃" + "/" + a4.substring(idx5 + 2, a4.lastIndexOf("℃")).replaceAll(" ", "") + "℃";

            String a5 = msg[5];
            int idx6 = a5.indexOf("오전");
            int idx7 = a5.indexOf("오후");
            String[] arr5 = a5.split(" ");
            day_5.setText(arr5[0]);
            String aa5 = a5.substring(idx6 + 2, a5.indexOf("℃")) + "℃" + "/" + a5.substring(idx7 + 2, a5.lastIndexOf("℃")).replaceAll(" ", "") + "℃";

            String a6 = msg[6];
            int idx8 = a6.indexOf("오전");
            int idx9 = a6.indexOf("오후");
            String[] arr6 = a6.split(" ");
            day_6.setText(arr6[0]);
            String aa6 = a6.substring(idx8 + 2, a6.indexOf("℃")) + "℃" + "/" + a6.substring(idx9 + 2, a6.lastIndexOf("℃")).replaceAll(" ", "") + "℃";

            String a7 = msg[7];
            int idx10 = a7.indexOf("오전");
            int idx11 = a7.indexOf("오후");
            String[] arr7 = a7.split(" ");
            day_7.setText(arr7[0]);
            String aa7 = a7.substring(idx10 + 2, a7.indexOf("℃")) + "℃" + "/" + a7.substring(idx11 + 2, a7.lastIndexOf("℃")).replaceAll(" ", "") + "℃";

            System.out.println(a1);

            String oneday2text = arr[2].toString() + "/" + arr[7].toString();
            String twoday2text = arr2[2].toString() + "/" + arr2[7].toString();

            oneday2.setTextColor(Color.parseColor("#ff0000"));
            twoday2.setTextColor(Color.parseColor("#ff0000"));
            threeday1.setTextColor(Color.parseColor("#ff0000"));
            fourday1.setTextColor(Color.parseColor("#ff0000"));
            fiveday1.setTextColor(Color.parseColor("#ff0000"));
            sixday1.setTextColor(Color.parseColor("#ff0000"));
            sevenday1.setTextColor(Color.parseColor("#ff0000"));

            SpannableStringBuilder sps1 = new SpannableStringBuilder();
            SpannableStringBuilder sps2 = new SpannableStringBuilder();
            SpannableStringBuilder sps3 = new SpannableStringBuilder();
            SpannableStringBuilder sps4 = new SpannableStringBuilder();
            SpannableStringBuilder sps5 = new SpannableStringBuilder();
            SpannableStringBuilder sps6 = new SpannableStringBuilder();
            SpannableStringBuilder sps7 = new SpannableStringBuilder();
            SpannableString s1 = new SpannableString(oneday2text);
            SpannableString s2 = new SpannableString(twoday2text);
            SpannableString s3 = new SpannableString(aa3);
            SpannableString s4 = new SpannableString(aa4);
            SpannableString s5 = new SpannableString(aa5);
            SpannableString s6 = new SpannableString(aa6);
            SpannableString s7 = new SpannableString(aa7);
            s1.setSpan(new ForegroundColorSpan(Color.parseColor("#505050")), 0, arr[2].toString().length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s1.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), 0, arr[2].toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s2.setSpan(new ForegroundColorSpan(Color.parseColor("#505050")), 0, arr2[2].toString().length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s2.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), 0, arr2[2].toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s3.setSpan(new ForegroundColorSpan(Color.parseColor("#505050")), 0, a3.substring(idx2 + 2, a3.indexOf("℃")).length() + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s3.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), 0, a3.substring(idx2 + 2, a3.indexOf("℃")).length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s4.setSpan(new ForegroundColorSpan(Color.parseColor("#505050")), 0, a4.substring(idx2 + 2, a4.indexOf("℃")).length() + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s4.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), 0, a4.substring(idx2 + 2, a4.indexOf("℃")).length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s5.setSpan(new ForegroundColorSpan(Color.parseColor("#505050")), 0, a5.substring(idx2 + 2, a5.indexOf("℃")).length() + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s5.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), 0, a5.substring(idx2 + 2, a5.indexOf("℃")).length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s6.setSpan(new ForegroundColorSpan(Color.parseColor("#505050")), 0, a6.substring(idx2 + 2, a6.indexOf("℃")).length() + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s6.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), 0, a6.substring(idx2 + 2, a6.indexOf("℃")).length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s7.setSpan(new ForegroundColorSpan(Color.parseColor("#505050")), 0, a7.substring(idx2 + 2, a7.indexOf("℃")).length() + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s7.setSpan(new ForegroundColorSpan(Color.parseColor("#0000FF")), 0, a7.substring(idx2 + 2, a7.indexOf("℃")).length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sps1.append(s1);
            sps2.append(s2);
            sps3.append(s3);
            sps4.append(s4);
            sps5.append(s5);
            sps6.append(s6);
            sps7.append(s7);

            oneday2.setText(sps1);
            twoday2.setText(sps2);
            threeday1.setText(sps3);
            fourday1.setText(sps4);
            fiveday1.setText(sps5);
            sixday1.setText(sps6);
            sevenday1.setText(sps6);
            /////
            ImageView onedayiv = (ImageView) findViewById(R.id.oneiv);
            ImageView twodayiv = (ImageView) findViewById(R.id.twoiv);
            ImageView threedayiv = (ImageView) findViewById(R.id.threeiv);
            ImageView fourdayiv = (ImageView) findViewById(R.id.fouriv);
            ImageView fivedayiv = (ImageView) findViewById(R.id.fiveiv);
            ImageView sixdayiv = (ImageView) findViewById(R.id.sixiv);
            ImageView sevendayiv = (ImageView) findViewById(R.id.seveniv);

            int idx = a5.indexOf("오후");
            Calendar now = Calendar.getInstance();
            int am_pm = now.get(now.AM_PM);

            oneday1.setText(aa0);

            if (am_pm == now.AM) {
                twoday1.setText(arr2[2].toString());
                if (a1.substring(0, idx).contains("맑음")) {
                    onedayiv.setImageResource(R.drawable.z1);
                } else if (a1.substring(0, idx).contains("흐림")) {
                    onedayiv.setImageResource(R.drawable.z4);
                } else if (a1.substring(0, idx).contains("구름조금")) {
                    onedayiv.setImageResource(R.drawable.z2);
                } else if (a1.substring(0, idx).contains("구름많음")) {
                    onedayiv.setImageResource(R.drawable.z3);
                } else if (a1.substring(0, idx).contains("비")) {
                    onedayiv.setImageResource(R.drawable.z5);
                }

                //2일차
                if (a2.substring(0, idx).contains("맑음")) {
                    twodayiv.setImageResource(R.drawable.z1);
                } else if (a2.substring(0, idx).contains("흐림")) {
                    twodayiv.setImageResource(R.drawable.z4);
                } else if (a2.substring(0, idx).contains("구름조금")) {
                    twodayiv.setImageResource(R.drawable.z2);
                } else if (a2.substring(0, idx).contains("구름많음")) {
                    twodayiv.setImageResource(R.drawable.z3);
                } else if (a2.substring(0, idx).contains("비")) {
                    twodayiv.setImageResource(R.drawable.z5);
                }

                //3일차
                if (a3.substring(0, idx).contains("맑음")) {
                    threedayiv.setImageResource(R.drawable.z1);
                } else if (a3.substring(0, idx).contains("흐림")) {
                    threedayiv.setImageResource(R.drawable.z4);
                } else if (a3.substring(0, idx).contains("구름조금")) {
                    threedayiv.setImageResource(R.drawable.z2);
                } else if (a3.substring(0, idx).contains("구름많음")) {
                    threedayiv.setImageResource(R.drawable.z3);
                } else if (a3.substring(0, idx).contains("비")) {
                    threedayiv.setImageResource(R.drawable.z5);
                }
                //4일차
                if (a4.substring(0, idx).contains("맑음")) {
                    fourdayiv.setImageResource(R.drawable.z1);
                } else if (a4.substring(0, idx).contains("흐림")) {
                    fourdayiv.setImageResource(R.drawable.z4);
                } else if (a4.substring(0, idx).contains("구름조금")) {
                    fourdayiv.setImageResource(R.drawable.z2);
                } else if (a4.substring(0, idx).contains("구름많음")) {
                    fourdayiv.setImageResource(R.drawable.z3);
                } else if (a4.substring(0, idx).contains("비")) {
                    fourdayiv.setImageResource(R.drawable.z5);
                }
                //5일차
                if (a5.substring(0, idx).contains("맑음")) {
                    fivedayiv.setImageResource(R.drawable.z1);
                } else if (a5.substring(0, idx).contains("흐림")) {
                    fivedayiv.setImageResource(R.drawable.z4);
                } else if (a5.substring(0, idx).contains("구름조금")) {
                    fivedayiv.setImageResource(R.drawable.z2);
                } else if (a5.substring(0, idx).contains("구름많음")) {
                    fivedayiv.setImageResource(R.drawable.z3);
                } else if (a5.substring(0, idx).contains("비")) {
                    fivedayiv.setImageResource(R.drawable.z5);
                }
                //6일차
                if (a6.substring(0, idx).contains("맑음")) {
                    sixdayiv.setImageResource(R.drawable.z1);
                } else if (a6.substring(0, idx).contains("흐림")) {
                    sixdayiv.setImageResource(R.drawable.z4);
                } else if (a6.substring(0, idx).contains("구름조금")) {
                    sixdayiv.setImageResource(R.drawable.z2);
                } else if (a6.substring(0, idx).contains("구름많음")) {
                    sixdayiv.setImageResource(R.drawable.z3);
                } else if (a6.substring(0, idx).contains("비")) {
                    sixdayiv.setImageResource(R.drawable.z5);
                }
                //7일차
                if (a7.substring(0, idx).contains("맑음")) {
                    sevendayiv.setImageResource(R.drawable.z1);
                } else if (a7.substring(0, idx).contains("흐림")) {
                    sevendayiv.setImageResource(R.drawable.z4);
                } else if (a7.substring(0, idx).contains("구름조금")) {
                    sevendayiv.setImageResource(R.drawable.z2);
                } else if (a7.substring(0, idx).contains("구름많음")) {
                    sevendayiv.setImageResource(R.drawable.z3);
                } else if (a7.substring(0, idx).contains("비")) {
                    sevendayiv.setImageResource(R.drawable.z5);
                }
            } else {
                twoday1.setText(arr2[7].toString());
                if (a1.substring(idx + 1).contains("맑음")) {
                    onedayiv.setImageResource(R.drawable.z1);
                } else if (a1.substring(idx + 1).contains("흐림")) {
                    onedayiv.setImageResource(R.drawable.z4);
                } else if (a1.substring(idx + 1).contains("구름조금")) {
                    onedayiv.setImageResource(R.drawable.z2);
                } else if (a1.substring(idx + 1).contains("구름많음")) {
                    onedayiv.setImageResource(R.drawable.z3);
                } else if (a1.substring(idx + 1).contains("비")) {
                    onedayiv.setImageResource(R.drawable.z5);
                }
                if (a2.substring(idx + 1).contains("맑음")) {
                    twodayiv.setImageResource(R.drawable.z1);
                } else if (a2.substring(idx + 1).contains("흐림")) {
                    twodayiv.setImageResource(R.drawable.z4);
                } else if (a2.substring(idx + 1).contains("구름조금")) {
                    twodayiv.setImageResource(R.drawable.z2);
                } else if (a2.substring(idx + 1).contains("구름많음")) {
                    twodayiv.setImageResource(R.drawable.z3);
                } else if (a2.substring(idx + 1).contains("비")) {
                    twodayiv.setImageResource(R.drawable.z5);
                }
                //3일차
                if (a3.substring(idx + 1).contains("맑음")) {
                    threedayiv.setImageResource(R.drawable.z1);
                } else if (a3.substring(idx + 1).contains("흐림")) {
                    threedayiv.setImageResource(R.drawable.z4);
                } else if (a3.substring(idx + 1).contains("구름조금")) {
                    threedayiv.setImageResource(R.drawable.z2);
                } else if (a3.substring(idx + 1).contains("구름많음")) {
                    threedayiv.setImageResource(R.drawable.z3);
                } else if (a3.substring(idx + 1).contains("비")) {
                    threedayiv.setImageResource(R.drawable.z5);
                }
                //4일차
                if (a4.substring(idx + 1).contains("맑음")) {
                    fourdayiv.setImageResource(R.drawable.z1);
                } else if (a4.substring(idx + 1).contains("흐림")) {
                    fourdayiv.setImageResource(R.drawable.z4);
                } else if (a4.substring(idx + 1).contains("구름조금")) {
                    fourdayiv.setImageResource(R.drawable.z2);
                } else if (a4.substring(idx + 1).contains("구름많음")) {
                    fourdayiv.setImageResource(R.drawable.z3);
                } else if (a4.substring(idx + 1).contains("비")) {
                    fourdayiv.setImageResource(R.drawable.z5);
                }
                //5일차
                if (a5.substring(idx + 1).contains("맑음")) {
                    fivedayiv.setImageResource(R.drawable.z1);
                } else if (a5.substring(idx + 1).contains("흐림")) {
                    fivedayiv.setImageResource(R.drawable.z4);
                } else if (a5.substring(idx + 1).contains("구름조금")) {
                    fivedayiv.setImageResource(R.drawable.z2);
                } else if (a5.substring(idx + 1).contains("구름많음")) {
                    fivedayiv.setImageResource(R.drawable.z3);
                } else if (a5.substring(idx + 1).contains("비")) {
                    fivedayiv.setImageResource(R.drawable.z5);
                }
                //6일차
                if (a6.substring(idx + 1).contains("맑음")) {
                    sixdayiv.setImageResource(R.drawable.z1);
                } else if (a6.substring(idx + 1).contains("흐림")) {
                    sixdayiv.setImageResource(R.drawable.z4);
                } else if (a6.substring(idx + 1).contains("구름조금")) {
                    sixdayiv.setImageResource(R.drawable.z2);
                } else if (a6.substring(idx + 1).contains("구름많음")) {
                    sixdayiv.setImageResource(R.drawable.z3);
                } else if (a6.substring(idx + 1).contains("비")) {
                    sixdayiv.setImageResource(R.drawable.z5);
                }
                //7일차
                if (a7.substring(idx + 1).contains("맑음")) {
                    sevendayiv.setImageResource(R.drawable.z1);
                } else if (a7.substring(idx + 1).contains("흐림")) {
                    sevendayiv.setImageResource(R.drawable.z4);
                } else if (a7.substring(idx + 1).contains("구름조금")) {
                    sevendayiv.setImageResource(R.drawable.z2);
                } else if (a7.substring(idx + 1).contains("구름많음")) {
                    sevendayiv.setImageResource(R.drawable.z3);
                } else if (a7.substring(idx + 1).contains("비")) {
                    sevendayiv.setImageResource(R.drawable.z5);
                }
            }

            /////
        } catch (Exception e) {
        }

    }

    public class WeatherConnection extends AsyncTask<Object, Object, String[]> {
        // 백그라운드에서 작업하게 한다
        @Override
        protected String[] doInBackground(Object... params) {
            // Jsoup을 이용한 날씨데이터 Pasing하기.
            try {
                String str = getIntent().getStringExtra("key2");
                String path = str;
                Document document = Jsoup.connect(path).get();
                Elements elements = document.select("th");
                Elements elements2 = document.select("td");
                Elements elements3 = document.select("tr");
                Elements elements4 = document.select("em");
                System.out.println(elements);

                Element targetElement0 = elements4.get(2);
                String text0 = targetElement0.text();

                Element targetElement1 = elements.get(0);
                String text1 = targetElement1.text();

                Element targetElement = elements2.get(0);
                String text = targetElement.text();

                Element targetElement_1 = elements.get(1);
                String text_1 = targetElement_1.text();

                Element targetElement_2 = elements2.get(1);
                String text_2 = targetElement_2.text();

                Element targetElement2 = elements3.get(2);
                String text2 = targetElement2.text();


                Element targetElement3 = elements3.get(3);
                String text3 = targetElement3.text();

                Element targetElement4 = elements3.get(4);
                String text4 = targetElement4.text();

                Element targetElement5 = elements3.get(5);
                String text5 = targetElement5.text();

                Element targetElement6 = elements3.get(6);
                String text6 = targetElement6.text();

                String d0 = text0;
                String d1 = text1 + "" + text;
                String d2 = text_1 + text_2;
                String d3 = text2;
                String d4 = text3;
                String d5 = text4;
                String d6 = text5;
                String d7 = text6;
                String[] test1 = {d0, d1, d2, d3, d4, d5, d6, d7};

                return test1;


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    // end onCreate

    //////////////////////////////////산소개//////////////////////////////////
    private class phpdo extends AsyncTask<String,Void,String> {
        protected void onPreExecute(){
        }

        @Override
        protected String doInBackground(String... arg0) {
            try {
                String sanname =  arg0[0];


                String link = "http://over7000.dothome.co.kr/sansoge/san_soge.php?sanname=" + sanname ;
                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();

            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result){
            introducetv.setText(result);

        }

    }
    ///////////////////////////////산소개////////////////////////////////////
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acha_activity, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            openOptionsDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    private void openOptionsDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.about)
                .setMessage(R.string.app_about_message)
                .setPositiveButton(R.string.str_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialoginterface, int i) {
                            }
                        }).show();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_main) {
            Intent it1 = new Intent(mountain_Information.this, MainActivity.class);
            startActivity(it1);
            this.finish();
        }  else if (id == R.id.nav_santip) {
            Intent it1 = new Intent(mountain_Information.this, ready_tip.class);
            startActivity(it1);
            this.finish();
        } else if (id == R.id.nav_templeseach) {
            Intent it1 = new Intent(mountain_Information.this, temple_search.class);
            startActivity(it1);
            this.finish();
        } else if (id == R.id.nav_templemanners) {
            Intent it1 = new Intent(mountain_Information.this, temple_manners.class);
            startActivity(it1);
            this.finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean onTouch(View v, MotionEvent event) {
        // 터치 이벤트가 일어난 뷰가 ViewFlipper가 아니면 return
        if (v != flipper)
            return false;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // 터치 시작지점 x좌표 저장
            down_x = event.getX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            // 터치 끝난 지점 X좌표 저장
            up_x = event.getX();

            if (up_x < down_x) {
                // 터치 할때 왼쪽방향으로 진행
                flipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_left_in));

                flipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_left_out));

                flipper.showNext();
            } else if (up_x > down_x) {
                // 터치할때 오른쪽 방향으로 진행
                flipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_right_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_right_out));
                flipper.showPrevious();
            }
        }
        return true;
    }
}