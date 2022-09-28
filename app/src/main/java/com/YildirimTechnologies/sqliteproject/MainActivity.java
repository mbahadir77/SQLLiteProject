package com.YildirimTechnologies.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Talebeler",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS talebeler(id INTEGER Prımary key , isim VARCHAR , yaş INTEGER)");
            //database.execSQL("DELETE FROM talebeler WHERE name = 'Bahadır'");
            //database.execSQL("UPDATE talebeler SET yaş = 25 WHERE isim = 'Bahadır'");
            //database.execSQL("INSERT INTO talebeler (isim , yaş) VALUES ('Bahadır' , 25)");
            Cursor cursor = database.rawQuery("SELECT * FROM talebeler " , null);
            //Cursor cursor = database.rawQuery("SELECT * FROM talebeler WHERE isim LIKE '%r")
            //Cursor cursor = database.rawQuery("SELECT * FROM talebeler Where isim = 'Bahadır'" , null);
            int isimIx = cursor.getColumnIndex("isim");
            int yaşIx =  cursor.getColumnIndex("yaş");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                System.out.println("İsim;" + cursor.getString(isimIx));
                System.out.println("Yaş" + cursor.getInt(yaşIx));
                System.out.println("id" + cursor.getInt(idIx));
            }
            cursor.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}