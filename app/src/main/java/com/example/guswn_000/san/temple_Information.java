package com.example.guswn_000.san;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class temple_Information extends ParentActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        Handler handler = new Handler();  // 외부쓰레드 에서 메인 UI화면을 그릴때 사용
        temple_Information.phpdo task;
        TextView introducetv;
         float down_x;
         float up_x;
         ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temple_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final int mI = 456;

        Intent intent = getIntent();
        final String templename = intent.getStringExtra("templename");
        final double position1 = intent.getDoubleExtra("position1",1);
        final double position2 = intent.getDoubleExtra("position2",1);

        ImageView map_go = (ImageView) findViewById(R.id.map_go);
        map_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(temple_Information.this, map.class);
                intent.putExtra("templename",templename);
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

        ////////////////////////////산소개///////////////////////
        task = new temple_Information.phpdo();

        task.execute(templename);
        setTitle(templename);
        introducetv = (TextView) findViewById(R.id.introducetv);

        /////////////////////이미지 테스트//////////////////
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                String str = getIntent().getStringExtra("key");
                // TODO Auto-generated method stub
                try {
                    // 걍 외우는게 좋다 -_-;
                    final ImageView iv = (ImageView) findViewById(R.id.imageView02);
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

    }

    //////////////////////////////////산소개//////////////////////////////////
    private class phpdo extends AsyncTask<String,Void,String> {
        protected void onPreExecute(){
        }

        @Override
        protected String doInBackground(String... arg0) {
            try {
                String templename =  arg0[0];

                String link = "http://over7000.dothome.co.kr/templesoge/temple_soge.php?templename=" + templename ;
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
        getMenuInflater().inflate(R.menu.temple_information, menu);
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
            Intent it1 = new Intent(temple_Information.this, MainActivity.class);
            startActivity(it1);
            this.finish();
        } else if (id == R.id.nav_sansearch) {
            // Handle the camera action
            Intent it1 = new Intent(temple_Information.this, mountain_search.class);
            startActivity(it1);
            this.finish();
        }  else if (id == R.id.nav_santip) {
            Intent it1 = new Intent(temple_Information.this, ready_tip.class);
            startActivity(it1);
            this.finish();
        }  else if (id == R.id.nav_templemanners) {
            Intent it1 = new Intent(temple_Information.this, temple_manners.class);
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
