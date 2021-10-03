package cn.misection.study.startupmode.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.misection.study.R;

public class StartupControllerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_controller);
    }

    public void onStandardStartupButtonClicked(View view) {
        startActivity(new Intent(this, StandardStartupActivity.class));
    }

    public void onSingleTopStartupButtonClicked(View view) {
        startActivity(new Intent(this, SingleTopActivity.class));
    }

    public void onSingleTaskStartupButtonClicked(View view) {
        startActivity(new Intent(this, SingleTaskActivity.class));
    }

    public void onSingleInstanceStartupButtonClicked(View view) {
        startActivity(new Intent(this, SingleInstanceActivity.class));
    }
}