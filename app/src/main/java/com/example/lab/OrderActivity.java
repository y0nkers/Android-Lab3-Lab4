package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Bundle arguments = getIntent().getExtras();
        Order order;
        if (arguments != null) {
            order = (Order)arguments.getSerializable(Order.class.getSimpleName());

            String processor, videocard, motherboard;
            boolean windows;
            processor = order.getProcessor();
            videocard = order.getVideocard();
            motherboard = order.getMotherboard();
            windows = order.isWindows();
            Date date = order.getOrderDate();

            TextView tvProcessor = (TextView)findViewById(R.id.processor);
            TextView tvVideocard = (TextView)findViewById(R.id.videocard);
            TextView tvMotherboard = (TextView)findViewById(R.id.motherboard);
            TextView tvWindows = (TextView)findViewById(R.id.windows);
            TextView tvDate = (TextView)findViewById(R.id.date);

            tvProcessor.setText(processor);
            tvVideocard.setText(videocard);
            tvMotherboard.setText(motherboard);


            if (windows) tvWindows.setText("Windows 10 установлена.");
            else tvWindows.setText("ОС не установлена.");

            tvDate.setText(date.toString());
        }
    }

    public void getOrders(View view) {
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }
}