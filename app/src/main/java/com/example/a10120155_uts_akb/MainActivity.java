package com.example.a10120155_uts_akb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

//    String[] daftar;
//    ListView listView;
//    Menu menu;
//    protected Cursor cursor;
//    Database database;
//    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent pindah = new Intent(MainActivity.this, CreateActivity.this);
//                startActivity(pindah);
//            }
//        });

//        ma = this;
//        database = new Database(this);
//        RefreshList();

        viewPager = findViewById(R.id.viewpager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.add(new Profile(), "Profil");
        viewPagerAdapter.add(new Data(), "Data");
        viewPagerAdapter.add(new AppVersion(), "Tentang Aplikasi");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

//    private void RefreshList(){
//        SQLiteDatabase db = database.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM notes",null);
//        daftar = new String[cursor.getCount()];
//        cursor.moveToFirst();
//        for (int i = 0; i < cursor.getCount(); i++){
//            cursor.moveToPosition();
//            daftar[i] = cursor.getString(1).toString();
//        }
//
//        listView = (ListView) findViewById(R.id.listView);
//        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,daftar));
//        listView.setSelected(true);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//
//            public void onItemClick(AdapterView argo, View arg1, int arg2, long arg3) {
//                final String selection = daftar [arg2];
//                final CharSequence [] dialogitem = {"Lihat Notes", "Ubah Notes", "Hapus Notes"};
//                AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this);
//                builder.setTitle("Pilihan");
//                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int item) {
//                        switch (item) {
//                            case 0:
//                                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
//                                i.putExtra( "title", selection);
//                                startActivity(i);
//                                break;
//                            case 1:
//                                Intent in = new Intent(getApplicationContext(), UpdateActivity.class);
//                                in.putExtra( "title", selection);
//                                startActivity(in);
//                                break;
//                            case 2:
//                                SQLiteDatabase db = database.getWritableDatabase();
//                                db.execSQL("delete from notes where title = '" + selection + "'");
//                                RefreshList();
//                                break;
//                        }
//                }
//
//                    ));

//    }
}