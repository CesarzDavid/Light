package com.cesarz.tsm.light;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ImageFoco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageFoco = findViewById(R.id.ImageFocoID);
    }

    public void ButtonStatus(View view)
    {
        Toast.makeText(MainActivity.this, "Status Done", Toast.LENGTH_SHORT).show();
    }
    public void ButtonOn(View view)
    {
        ImageFoco.setBackgroundResource(R.drawable.buttonon);
        Toast.makeText(MainActivity.this, "on", Toast.LENGTH_SHORT).show();
    }
    public void ButtonOff(View view)
    {
        ImageFoco.setBackgroundResource(R.drawable.buttonoff);
        Toast.makeText(MainActivity.this, "off", Toast.LENGTH_SHORT).show();
    }
}