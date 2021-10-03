package cn.misection.study.menu.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import cn.misection.study.BuildConfig;
import cn.misection.study.R;
import cn.misection.study.databinding.ActivityMainBinding;
import cn.misection.study.lifecycle.controller.LifeCycleActivity;
import cn.misection.study.launchmode.controller.LaunchControllerActivity;
import cn.misection.study.menu.adapter.StudyItemAdapter;
import cn.misection.study.menu.entity.StudyItem;
import cn.misection.study.subthreadupdateui.SubThreadUpdateUiActivity;

/**
 * @author javaman
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initBinding();
        initRecycleView();
    }

    private void initBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void initRecycleView() {
        List<StudyItem> studyItemList = new ArrayList<StudyItem>(StudyItem.count()) {{
            addAll(EnumSet.allOf(StudyItem.class));
        }};
        StudyItemAdapter studyItemAdapter = new StudyItemAdapter(this, studyItemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mBinding.menuRecycleView.setLayoutManager(linearLayoutManager);
        mBinding.menuRecycleView.setAdapter(studyItemAdapter);
    }
}