package com.example.a10120155_uts_akb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    // nim : 10120155
// nama : kautsar teguh dwi putra
// kelas : IF-4
    protected Cursor cursor;
    Database database;
    Button buttonInsert;
    TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = new Database( this);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into notes (title, description) values ('" +
                        title.getText().toString() + "', '" +
                        description.getText().toString() + "')");
                Toast.makeText( CreateActivity.this, "Data tersimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}