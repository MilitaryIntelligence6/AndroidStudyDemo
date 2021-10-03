package cn.misection.study.subthreadupdateui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import cn.misection.study.R;
import cn.misection.study.databinding.ActivitySubThreadUpdateUiBinding;

/**
 * @author javaman
 */
public class SubThreadUpdateUiActivity extends AppCompatActivity {

    private ActivitySubThreadUpdateUiBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_thread_update_ui);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_sub_thread_update_ui);
        startSubThread();
    }

    private void startSubThread() {
        new Thread(() -> {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            updateUI();
        }).start();
    }

    private void updateUI() {
        mBinding.subThreadUpdateUiTv.setText("子线程可以更新 ui");
    }

    public void onSubUpdateUiButtonClicked(View view) {
        new Thread(() -> {
            mBinding.subThreadUpdateUiTv.setText("子线程可以更新 ui 吗?");
        }).start();
    }
}