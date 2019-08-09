package com.wutianle.dcim;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Mkdir_system_junkfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkdir_system_junkfile);

        findViewById(R.id.tost_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Mkdir_system_junkfile.this, "我是通过makeText方法创建的消息提示框", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
