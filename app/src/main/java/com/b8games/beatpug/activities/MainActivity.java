package com.b8games.beatpug.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.b8games.beatpug.R;
import com.b8games.beatpug.adapter.SimpleRecyclerAdapter;
import com.b8games.beatpug.utils.Utils;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    SimpleRecyclerAdapter adapter;
    Intent intent;

    String[] colors = {"#96CC7A", "#EA705D", "#66BBCC"};

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent introIntent = new Intent(MainActivity.this, PagerActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime)
            startActivity(introIntent);


        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar_elevated);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setTitle("Material Design Samples");


        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        if (adapter == null) {
            adapter = new SimpleRecyclerAdapter(this);
            recyclerView.setAdapter(adapter);
        }

        final Context context = this;

        adapter.SetOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, NavDrawerActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, AnimateToolbar.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, TabAnimationActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, RevealAnimation.class);
                        break;

                    default:
                        Toast.makeText(getBaseContext(), "Undefined Click!", Toast.LENGTH_SHORT).show();
                }

                if (intent != null)
                    startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_navigator, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
