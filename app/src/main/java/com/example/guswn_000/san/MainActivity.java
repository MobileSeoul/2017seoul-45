package com.example.guswn_000.san;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends ParentActivity
        implements View.OnTouchListener,NavigationView.OnNavigationItemSelectedListener {
    private ActivityManager am = ActivityManager.getInstance();
    Boolean mFlag = false;
    float down_x;
    float up_x;
    int[] imageItems;
    ViewFlipper flipper2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        flipper2 = (ViewFlipper) findViewById(R.id.flipper2);
                    imageItems = new int[] { R.drawable.aaa,R.drawable.bbb,R.drawable.ccc };
                    for (int i : imageItems) {
                        ImageView image = new ImageView(this);
                        image.setImageResource(i);
                        flipper2.addView(image, new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));
                    }
                    flipper2.setOnTouchListener(this);


        Button bt,bt1,bt2,bt3,call;
        bt = (Button) findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, mountain_search.class);
                startActivity(it);

            }
        });

        bt1 = (Button) findViewById(R.id.button); // 사찰 정보
        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(MainActivity.this, temple_search.class);
                startActivity(it1);

            }
        });

        bt2 = (Button) findViewById(R.id.button1);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ready_tip.class);
                startActivity(it);

            }
        });

        bt3 = (Button)findViewById(R.id.button5);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, temple_manners.class);
                startActivity(it);
            }
        });

        call = (Button) findViewById(R.id.call_btn);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Intent.ACTION_DIAL );
                intent.setData( Uri.parse( "tel:119" ) );
                startActivity( intent );
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
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

    @Override
    public boolean onKeyDown (int KeyCode, KeyEvent event) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            if (KeyCode == KeyEvent.KEYCODE_BACK){

                    if (!mFlag && !(drawer.isDrawerOpen(GravityCompat.START))){
                        Toast.makeText(this, "뒤로 버튼을 한 번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
                        mFlag = true;
                        mKillHandler.sendEmptyMessageDelayed(0,2000);
                       return false;
                    } else if((drawer.isDrawerOpen(GravityCompat.START)) && !mFlag){
                        drawer.closeDrawer(GravityCompat.START);
                        return false;
                    } else {
                        am.finishAllActivity();
                    }

            }
        }
        return super.onKeyDown(KeyCode, event);
    }

    Handler mKillHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                mFlag = false;
            }
        }
    };

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


         if (id == R.id.nav_sansearch) {
            // Handle the camera action
            Intent it1 = new Intent(MainActivity.this, mountain_search.class);
            startActivity(it1);
        }  else if (id == R.id.nav_santip) {
            Intent it1 = new Intent(MainActivity.this, ready_tip.class);
            startActivity(it1);
        } else if (id == R.id.nav_templeseach) {
            Intent it1 = new Intent(MainActivity.this, temple_search.class);
            startActivity(it1);
        } else if (id == R.id.nav_templemanners) {
            Intent it1 = new Intent(MainActivity.this, temple_manners.class);
            startActivity(it1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean onTouch(View v, MotionEvent event) {
        // 터치 이벤트가 일어난 뷰가 ViewFlipper가 아니면 return
        if (v != flipper2)
            return false;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // 터치 시작지점 x좌표 저장
            down_x = event.getX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            // 터치 끝난 지점 X좌표 저장
            up_x = event.getX();

            if (up_x < down_x) {
                // 터치 할때 왼쪽방향으로 진행
                flipper2.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_left_in));

                flipper2.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_left_out));

                flipper2.showNext();
            } else if (up_x > down_x) {
                // 터치할때 오른쪽 방향으로 진행
                flipper2.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_right_in));
                flipper2.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.push_right_out));
                flipper2.showPrevious();
            }
        }
        return true;
    }

}
