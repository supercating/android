package com.wutianle.dcim;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class activity_daylog extends AppCompatActivity {
    private int yourChoice;
    private ArrayList<Integer> yourChoices = new ArrayList<>();
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daylog);
    }
    /* @setIcon 设置对话框图标
     * @setTitle 设置对话框标题
     * @setMessage 设置对话框消息提示
     * setXXX方法返回Dialog对象，因此可以链式设置属性
     * */
    public void Dialog1(){
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(activity_daylog.this);
        normalDialog.setIcon(R.mipmap.ic_launcher);
        normalDialog.setTitle("我是一个普通Dialog");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        // 显示
        normalDialog.show();
    }

}
