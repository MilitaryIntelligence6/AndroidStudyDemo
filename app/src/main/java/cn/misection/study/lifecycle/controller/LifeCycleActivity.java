package cn.misection.study.lifecycle.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.misection.study.R;
import cn.misection.util.oututil.system.AppSystem;

/**
 * @author javaman
 */
public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        printt("LifeCycleActivity::onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        printt("LifeCycleActivity::onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        printt("LifeCycleActivity::onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        printt("LifeCycleActivity::onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        printt("LifeCycleActivity::onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        printt("LifeCycleActivity::onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        printt("LifeCycleActivity::onDestroy");
    }

    private void printt(String msg) {
        AppSystem.out.printt(this, String.format("%s has been invoked", msg));
    }

    public void onEasyGoToActivityButtonClicked(View view) {
        AppSystem.out.printt(this, "跳转到 util Activity");
        startActivity(new Intent(this, UtilActivity.class));
    }
}