package cn.misection.study.lifecycle.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.misection.study.R;

/**
 * @author javaman
 * 工具人 Activity;
 */
public class UtilManActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util_man);
    }
}