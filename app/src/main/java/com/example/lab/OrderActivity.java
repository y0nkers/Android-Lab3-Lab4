package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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

            TextView tvProcessor = (TextView)findViewById(R.id.processor);
            TextView tvVideocard = (TextView)findViewById(R.id.videocard);
            TextView tvMotherboard = (TextView)findViewById(R.id.motherboard);
            TextView tvWindows = (TextView)findViewById(R.id.windows);

            int processorPrice = 0, videocardPrice = 0, motherboardPrice = 0, windowsPrice = 0;
            switch (processor) {
                case "Intel i7-9700k":
                    processorPrice = 15000;
                    break;
                case "AMD Ryzen 7 5800x":
                    processorPrice = 12000;
                    break;
            }

            switch(videocard) {
                case "GTX 1050ti":
                    videocardPrice = 10000;
                    break;
                case "RTX 3050":
                    videocardPrice = 25000;
                    break;
                case "RTX 3080ti":
                    videocardPrice = 30000;
                    break;
            }

            switch(motherboard) {
                case "MSI B450M":
                    motherboardPrice = 7000;
                    break;
                case "ASRock H310CM":
                    motherboardPrice = 5000;
                    break;
                case "GIGABYTE B450M":
                    motherboardPrice = 6000;
                    break;
            }

            tvProcessor.setText(processor + " (" + processorPrice + " руб.)");
            tvVideocard.setText(videocard + " (" + videocardPrice + " руб.)");
            tvMotherboard.setText(motherboard + " (" + motherboardPrice + " руб.)");

            if (windows) {
                windowsPrice = 10000;
                tvWindows.setText("Установлена (" + windowsPrice + " руб.)" );
            }
            else tvWindows.setText("Не установлена (0 руб.)");

            TextView totalPrice = (TextView)findViewById(R.id.totalPrice);
            totalPrice.setText("Общая стоимость заказа: " + (processorPrice + videocardPrice + motherboardPrice + windowsPrice));
        }
    }
}