package com.example.geekandroidaction.activity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geekandroidaction.R;
import com.example.geekandroidaction.util.ProcessUtils;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class AnimatorActivity extends Activity implements View.OnClickListener {

    private Button btn_anim_alpha;
    private Button btn_anim_scale;
    private Button btn_anim_rotate;
    private Button btn_anim_translate;
    private LinearLayout btn_layout;
    private TextView tv_show;
    private Button btn_anim_com_animator;
    private Button btn_check_permission;

    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private static final String processname = "com.cleanmaster.mguard";
    private static final int pid = 2222;
    private static int uid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        initView();

    }

    private void initView() {
        btn_anim_alpha = (Button) findViewById(R.id.btn_anim_alpha);
        btn_anim_scale = (Button) findViewById(R.id.btn_anim_scale);
        btn_anim_rotate = (Button) findViewById(R.id.btn_anim_rotate);
        btn_anim_translate = (Button) findViewById(R.id.btn_anim_translate);
        btn_layout = (LinearLayout) findViewById(R.id.btn_layout);
        tv_show = (TextView) findViewById(R.id.tv_show);
        btn_check_permission = (Button) findViewById(R.id.btn_check_permission);
        btn_check_permission.setOnClickListener(this);

        btn_anim_alpha.setOnClickListener(this);
        btn_anim_scale.setOnClickListener(this);
        btn_anim_rotate.setOnClickListener(this);
        btn_anim_translate.setOnClickListener(this);
        btn_anim_com_animator = (Button) findViewById(R.id.btn_anim_com_animator);
        btn_anim_com_animator.setOnClickListener(this);
    }

    private void testCheck() {
        //uid = ProcessUtils.getProcessUid(processname);
        uid = ProcessUtils.getUID(AnimatorActivity.this, processname);
        int result = checkPermission(EXTERNAL_STORAGE_PERMISSION, pid, uid);
        if (result == PERMISSION_GRANTED) {
            Toast.makeText(AnimatorActivity.this, "granted", Toast.LENGTH_SHORT).show();
            Log.d("-----", "granted");
        } else {
            Log.d("-----", "granted failed");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_anim_alpha:
                Animation alphaAnimation = AnimationUtils.loadAnimation(AnimatorActivity.this, R.anim.alpha_anim);
                tv_show.startAnimation(alphaAnimation);
                break;
            case R.id.btn_anim_scale:
                Animation scaleAnimation = AnimationUtils.loadAnimation(AnimatorActivity.this, R.anim.scale_anim);
                tv_show.startAnimation(scaleAnimation);
                break;
            case R.id.btn_anim_rotate:
                Animation rotateAnimation = AnimationUtils.loadAnimation(AnimatorActivity.this, R.anim.rotate_anim);
                tv_show.startAnimation(rotateAnimation);
                break;
            case R.id.btn_anim_translate:
                Animation translateAnimation = AnimationUtils.loadAnimation(AnimatorActivity.this, R.anim.translate_anim);
                tv_show.startAnimation(translateAnimation);
                break;
            case R.id.btn_anim_com_animator:
                Animation combAnimation = AnimationUtils.loadAnimation(AnimatorActivity.this, R.anim.comb_anim);
                tv_show.startAnimation(combAnimation);
                break;
            case R.id.btn_check_permission:
                testCheck();
                break;
        }
    }
    public static int getUID(Context context, String packName) {
        int uid = -1;
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo applicationInfo = pm.getApplicationInfo(packName, 0);
            uid = applicationInfo.uid;
            Log.i("ProcessUtils", "uid:" + uid);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return uid;
    }
}
