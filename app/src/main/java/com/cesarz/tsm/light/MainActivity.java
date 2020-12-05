package com.cesarz.tsm.light;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
        //Toast.makeText(MainActivity.this, "Status Done", Toast.LENGTH_SHORT).show();
        getJSON("https://tsmpjgv9.000webhostapp.com/luz.php");
    }
    public void ButtonOn(View view)
    {
        ImageFoco.setBackgroundResource(R.drawable.buttonon);
        //Toast.makeText(MainActivity.this, "on", Toast.LENGTH_SHORT).show();
        getJSON("https://tsmpjgv9.000webhostapp.com/lon.php");
    }
    public void ButtonOff(View view)
    {
        ImageFoco.setBackgroundResource(R.drawable.buttonoff);
        //Toast.makeText(MainActivity.this, "off", Toast.LENGTH_SHORT).show();
        getJSON("https://tsmpjgv9.000webhostapp.com/loff.php");
    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }

            }
        }

    }
}