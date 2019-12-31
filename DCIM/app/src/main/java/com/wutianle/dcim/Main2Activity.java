package com.wutianle.dcim;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private String name = "android.permission.READ_EXTERNAL_STORAGE";
    private String cmPackName = "com.cleanmaster.mguard";
    private static int pid = 2222;
    private Button btn;
    private EditText pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        pp = (EditText) findViewById(R.id.pp);
        pp.setOnClickListener(this);
    }

    private void clickbtn() {
        submit();
        int grantState = checkPermission(name, pid, getUID(cmPackName));
        if (grantState == PackageManager.PERMISSION_GRANTED) {
            Log.i("----", "已授权：");
        } else {
            Log.i("----", "未授权：");
        }
    }

    private int getUID(String packageName) {
        int uid = -1;
        try {
            PackageManager pm = getPackageManager();
            ApplicationInfo applicationInfo = pm.getApplicationInfo(packageName, 0);
            uid = applicationInfo.uid;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return uid;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                clickbtn();

                break;
        }
    }

    private void submit() {
        // validate
        String ppString = pp.getText().toString().trim();
        if (TextUtils.isEmpty(ppString)) {
            Toast.makeText(this, "ppString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        pid = Integer.parseInt(ppString);

        // TODO validate success, do something


    }
}
