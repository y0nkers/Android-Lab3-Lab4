package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class OrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        TextView orders = findViewById(R.id.orders);
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("orders.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM orders;", null);
        while(query.moveToNext()) {
            int id = query.getInt(0);
            String processor = query.getString(1);
            String videocard = query.getString(2);
            String motherboard = query.getString(3);
            String windows = query.getInt(4) == 1 ? "Установлена" : "Не установлена";
            String date = query.getString(5);
            String order = "Заказ №" + id + "\nПроцессор: " + processor + "\nВидеокарта: "
                    + videocard + "\nМатеринская плата: " + motherboard + "\nWindows: " + windows
                    + "\nДата заказа: " + date + "\n\n";
            orders.append(order);
        }
    }
}