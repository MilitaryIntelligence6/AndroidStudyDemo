package cn.misection.study.launchmode.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.misection.study.R;

/**
 * @author javaman
 */
public class StandardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_launch);
    }
}