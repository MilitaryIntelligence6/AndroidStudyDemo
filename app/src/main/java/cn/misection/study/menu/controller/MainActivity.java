package cn.misection.study.menu.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.misection.study.R;
import cn.misection.study.lifecycle.controller.LifeCycleActivity;
import cn.misection.study.launchmode.controller.LaunchControllerActivity;
import cn.misection.study.subthreadupdateui.SubThreadUpdateUiActivity;

/**
 * @author javaman
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLifeCycleButtonClicked(View view) {
//        AppSystem.out.printt(this, "跳转至生命周期页面");
        startActivity(new Intent(this, LifeCycleActivity.class));
    }

    public void onActivityStartupModeButtonClicked(View view) {
        startActivity(new Intent(this, LaunchControllerActivity.class));
    }

    public void onSubThreadUpdateUiButtonClicked(View view) {
        startActivity(new Intent(this, SubThreadUpdateUiActivity.class));
    }
}