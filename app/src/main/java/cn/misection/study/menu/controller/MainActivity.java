package cn.misection.study.menu.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import cn.misection.study.R;
import cn.misection.study.databinding.ActivityMainBinding;
import cn.misection.study.menu.adapter.StudyItemAdapter;
import cn.misection.study.menu.entity.StudyItem;
import cn.misection.util.oututil.system.AppSystem;

/**
 * @author javaman
 */
public class MainActivity extends AppCompatActivity {

    private long mLastExitTime;

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

    @Override
    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mLastExitTime > 2000) {
            AppSystem.out.printt(this, "再按一次退出程序");
            mLastExitTime = currentTimeMillis;
        } else {
            super.onBackPressed();
        }
    }
}