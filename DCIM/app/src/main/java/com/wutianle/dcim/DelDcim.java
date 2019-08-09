package com.wutianle.dcim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class DelDcim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_dcim);

        findViewById(R.id.buttondel).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Pig_bosst();
            }
        });
    }


    public void Pig_bosst(){
        Intent intent = new Intent(DelDcim.this,MainActivity.class);
        startActivity(intent);

    }
}
