package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    private String getStrFromRb(int id) {
        RadioGroup rg; // current Radio Group
        int rbId; // id of checked Radio Button in Radio Group
        RadioButton rb; // Checked Radio Button

        rg = findViewById(id);
        rbId = rg.getCheckedRadioButtonId();
        if (rbId != -1) {
            rb = (RadioButton)rg.findViewById(rbId);
            return rb.getText().toString();
        }
        Toast.makeText(this, "Не выбрано одно из комплектующих!", Toast.LENGTH_SHORT).show();
        return null;
    }

    public void makeOrder(View view) {
        Order order = new Order();
        try {
            String processor, videocard, motherboard;
            boolean windows;

            processor = getStrFromRb(R.id.rgProcessor);
            videocard = getStrFromRb(R.id.rgVideocard);
            motherboard = getStrFromRb(R.id.rgMotherboard);

            if (processor == null || videocard == null || motherboard == null) return;

            order.setProcessor(processor);
            order.setVideocard(videocard);
            order.setMotherboard(motherboard);

            CheckBox cbWindows = findViewById(R.id.cbWindows);
            if (cbWindows.isChecked()) order.setWindows(true);
            else order.setWindows(false);

            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra(Order.class.getSimpleName(), order);
            startActivity(intent);
        }
        catch (Exception e) {
            Toast.makeText(this, "Произошла ошибка при оформлении заказа.", Toast.LENGTH_SHORT).show();
        }
    }
}