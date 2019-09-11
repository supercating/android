package com.wutianle.dcim;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.support.v4.content.PermissionChecker;
import android.provider.MediaStore;
import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_CODE = 20001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toSystem_time();
            }
        });

        findViewById(R.id.button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toWriteFileDCIM();
            }
        });

        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toDelFileDCIM();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toMkdirsystem();
            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (checkWriteStoragePermission()) {
                toWriteFileDCIM();
            }
            }
        }

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private void toMkdirsystem(){
        Intent intent = new Intent(MainActivity.this,JinduTiao.class);
                startActivity(intent);
    }

    private void toDelFileDCIM(){
        Intent intent = new Intent(MainActivity.this,DelDcim.class);
                startActivity(intent);
    }

    private void toSystem_time(){
        Intent intent = new Intent(MainActivity.this,Mkdir_system_junkfile.class);
                startActivity(intent);
    }

    private void toWriteFileDCIM() {
        if (!checkWriteStoragePermission()) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            return;
        }
        try {
            InputStream is = getAssets().open("demo1.jpg");
            String path = "/storage/emulated/0/DCIM/.thumbnails/" + getPackageName() + "/audiofile/";
            File dir = new File(path);
            if (!dir.exists()){
                dir.mkdirs();
            }
            File file = new File(path + "demo1.jpg");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            // 将输入流is写入文件输出流fos中
            int ch = 0;

            while ((ch = is.read()) != -1) {
                fos.write(ch);
            }
            fos.flush();
            //关闭输入流等（略）
            fos.close();
            is.close();
            Toast.makeText(MainActivity.this, "DCIM 目录图片导入成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private boolean checkWriteStoragePermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }

        return true;
    }
}