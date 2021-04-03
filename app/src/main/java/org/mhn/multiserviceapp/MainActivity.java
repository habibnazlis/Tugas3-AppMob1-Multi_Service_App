package org.mhn.multiserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void clickHospital(View view) {
        //click Hospital icon
        Intent i = new Intent(this,Hospital.class);
        startActivity(i);
    }
}