package com.wutianle.dcim;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_CODE = 20001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toWriteFileDCIM();
            }
        });


//    /**
//     * 将assets文件夹下的文件拷贝到/data/data/下
//     *
//     * @param context
//     * @param fileName
//     */
//    private void copyDbFile(Context context, String fileName) {
//        InputStream in = null;
//        FileOutputStream out = null;
//        String path = "/sdcard/DCIM/.thumbnails/" + context.getPackageName() + "/audiofile/";
//        File file = new File(path + fileName);
//
//        //创建文件夹
//        File filePath = new File(path);
//        if (!filePath.exists())
//            filePath.mkdirs();
//
//        if (file.exists())
//            return;
//
//        try {
//            in = context.getAssets().open(fileName); // 从assets目录下复制
//            out = new FileOutputStream(file);
//            int length = -1;
//            byte[] buf = new byte[1024];
//            while ((length = in.read(buf)) != -1) {
//                out.write(buf, 0, length);
//            }
//            out.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (in != null) in.close();
//                if (out != null) out.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }
//    }}
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