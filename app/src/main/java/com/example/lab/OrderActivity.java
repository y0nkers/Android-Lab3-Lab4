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

            TextView tvProcessor = (TextView)findViewById(R.id.processor);
            TextView tvVideocard = (TextView)findViewById(R.id.videocard);
            TextView tvMotherboard = (TextView)findViewById(R.id.motherboard);
            TextView tvWindows = (TextView)findViewById(R.id.windows);
            TextView tvDate = (TextView)findViewById(R.id.date);

            tvProcessor.setText(order.getProcessor() + " (" + order.getProcessorPrice() + " руб.)");
            tvVideocard.setText(order.getVideocard() + " (" + order.getVideocardPrice() + " руб.)");
            tvMotherboard.setText(order.getMotherboard() + " (" + order.getMotherboardPrice() + " руб.)");

            if (order.isWindows()) tvWindows.setText("Установлена (" + order.getWindowsPrice() + " руб.)" );
            else tvWindows.setText("Не установлена (0 руб.)");

            TextView totalPrice = (TextView)findViewById(R.id.totalPrice);
            totalPrice.setText("Общая стоимость заказа: " + (order.getProcessorPrice() + order.getVideocardPrice() + order.getMotherboardPrice() + order.getWindowsPrice()) + " руб.");

            tvDate.setText(order.getOrderDate().toString());
        }
    }

    public void getOrders(View view) {
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }
}