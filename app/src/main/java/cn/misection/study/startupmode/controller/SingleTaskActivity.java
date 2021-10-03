package cn.misection.study.startupmode.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.misection.study.R;

public class SingleTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
    }
}