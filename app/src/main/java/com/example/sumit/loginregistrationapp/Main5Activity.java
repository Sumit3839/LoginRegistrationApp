package com.example.sumit.loginregistrationapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
    Drawer left;
    AccountHeader header;
    Crossfader crossfader;
    Toolbar toolbar;
    MiniDrawer miniDrawer;
    IProfile profile;
    RecyclerView recyclerView;
    Database db;
    List<Login> loginList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        toolbar = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        db = new Database(this);
        loginList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycle1);
        loginList = db.getAllData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DBAdapter adapter = new DBAdapter(this, loginList);
        recyclerView.setAdapter(adapter);
        SharedPreferences preferences = getSharedPreferences("sumit", MODE_PRIVATE);
        String name = preferences.getString("name", "Not Available");
        String email = preferences.getString("email", "Not Available");
        String phone = preferences.getString("phone", "Not Available");
        String username = preferences.getString("username", "Not Available");
        profile = new ProfileDrawerItem().withName(name).withEmail(email).withIcon(getResources().getDrawable(R.drawable.log07));
        header = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.logo1)
                .addProfiles(profile)
                .withTranslucentStatusBar(false)
                .withSavedInstance(savedInstanceState)
                .build();

        left = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(header)
                .withDrawerGravity(Gravity.LEFT)
                .withDisplayBelowStatusBar(true)
                .addDrawerItems(new PrimaryDrawerItem().withName(name).withIcon(getResources().getDrawable(R.drawable.chevron)),
                        new PrimaryDrawerItem().withName(email).withIcon(getResources().getDrawable(R.drawable.circle)),
                        new PrimaryDrawerItem().withName(phone).withIcon(getResources().getDrawable(R.drawable.ic_chevron_right_black_24dp)),
                        new PrimaryDrawerItem().withName(username).withIcon(getResources().getDrawable(R.drawable.ic_close_black_24dp)))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                })
                .withSavedInstance(savedInstanceState)
                //.withGenerateMiniDrawer(true)
                .build();
        // miniDrawer = left.getMiniDrawer();
        //int firstWidth = (int) UIUtils.convertDpToPixel(300, this);
        //int secondWidth = (int) UIUtils.convertDpToPixel(72, this);
        //crossfader = new Crossfader()
        //.withContent(findViewById(R.id.toolbar5))
        //.withFirst(left.getSlider(), firstWidth)
        //.withSecond(miniDrawer.build(this), secondWidth)
        //.withSavedInstance(savedInstanceState)
        //.build();
        //miniDrawer.withCrossFader(new CrossfadeWrapper(crossfader));

    }

    public void putDataInDrawer(MenuItem item) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sharedpref, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu1) {
            Toast.makeText(getApplicationContext(), "ABCD", Toast.LENGTH_SHORT).show();
        }
        return true;

    }
}