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

public class UpdateActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_update);
        database = new Database( this);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        buttonInsert = findViewById(R.id.buttonInsert);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM notes WHERE title = '" + title + "'", null);

        cursor.moveToFirst();
        if (cursor.getCount() >0){
            cursor.moveToPosition(0);
            title.setText(cursor.getString(1).toString());
            description.setText(cursor.getString(2).toString());
        }
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonInsert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase db = database.getWritableDatabase();
                        db.execSQL("UPDATE notes SET title='" +
                                title.getText().toString()
                                + "', description='" + description.getText().toString()
                                + "' WHERE title='" + getIntent().getStringExtra("title") + "'");
                        Toast.makeText(UpdateActivity.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                        MainActivity.ma.RefreshList();
                        finish();
                    }
                });

            }
        });

    }
}