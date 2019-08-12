package com.wutianle.dcim;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class JinduTiao extends AppCompatActivity {

    //声明按钮
    private Button btnCircle=null;
    private Button btnProgress=null;
    //声明进度条对话框
    private ProgressDialog pdDialog=null;
    //进度计数
    int iCount  = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jindutiao);
        btnCircle = (Button)findViewById(R.id.circle);
        btnProgress = (Button)findViewById(R.id.progress);

        //设置btnCircle的事件监听
        btnCircle.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){

                iCount  = 0;
                //创建ProgressDialog对象
                pdDialog = new ProgressDialog(JinduTiao.this);

                //设置进度条风格，风格为圆形，旋转的
                pdDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                // 设置ProgressDialog 标题
                pdDialog.setTitle("圆形进度条");

                // 设置ProgressDialog 提示信息
                pdDialog.setMessage("正在下载中……");

                // 设置ProgressDialog 标题图标
                pdDialog.setIcon(R.drawable.ic_launcher_background);

                // 设置ProgressDialog 进度条进度
                pdDialog.setProgress(100);

                // 设置ProgressDialog 的进度条是否不明确
                pdDialog.setIndeterminate(false);

                // 设置ProgressDialog 是否可以按退回按键取消
                pdDialog.setCancelable(true);

                // 设置ProgressDialog 的一个Button
                pdDialog.setButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i)
                    {
                        //点击“取消”按钮取消对话框
                        dialog.cancel();
                    }
                });

                // 让ProgressDialog显示
                pdDialog.show();

                //创建线程实例
                new Thread(){
                    public void run(){
                        try{
                            while (iCount  <= 100) {
                                // 由线程来控制进度。
                                pdDialog.setProgress(iCount ++);
                                Thread.sleep(50);
                            }
                            pdDialog.cancel();
                        }
                        catch (InterruptedException e){
                            pdDialog.cancel();
                        }
                    }

                }.start();
            }

        });



        //设置btnProgress的事件监听
        btnProgress.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                iCount  = 0;
                // 创建ProgressDialog对象
                pdDialog = new ProgressDialog(JinduTiao.this);

                // 设置进度条风格，风格为长形
                pdDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                // 设置ProgressDialog 标题
                pdDialog.setTitle("条形进度条");

                // 设置ProgressDialog 提示信息
                pdDialog.setMessage("正在下载中……");

                // 设置ProgressDialog 标题图标
                pdDialog.setIcon(R.drawable.ic_launcher_background);

                // 设置ProgressDialog 进度条进度
                pdDialog.setProgress(100);

                // 设置ProgressDialog 的进度条是否不明确
                pdDialog.setIndeterminate(false);

                // 设置ProgressDialog 是否可以按退回按键取消
                pdDialog.setCancelable(true);

                // 让ProgressDialog显示
                pdDialog.show();

                //创建线程实例
                new Thread(){
                    public void run(){
                        try{
                            while (iCount  <= 100) {
                                // 由线程来控制进度。
                                pdDialog.setProgress(iCount ++);
                                Thread.sleep(50);
                            }
                            pdDialog.cancel();
                        }
                        catch (InterruptedException e){
                            pdDialog.cancel();
                        }
                    }

                }.start();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}