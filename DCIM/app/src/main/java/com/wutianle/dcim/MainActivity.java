package com.wutianle.dcim;

import android.content.Context;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}