package cn.misection.study.handler.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.misection.study.R;
import cn.misection.util.oututil.system.AppSystem;

/**
 * @author javaman
 */
public class HandlerActivity extends AppCompatActivity {

    private static final String TAG = HandlerActivity.class.getName();

    private MyHandler mHandler;

    private ScheduledExecutorService mPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        init();
    }

    @Override
    protected void onDestroy() {
        mPool.shutdown();
        super.onDestroy();
    }

    private void init() {
        initComponent();
        initTask();
    }

    private void initComponent() {
        mHandler = new MyHandler(this);
        mPool = Executors.newSingleThreadScheduledExecutor();
    }

    private void initTask() {
        mPool.scheduleAtFixedRate(
                this::sendMessage,
                2,
                2,
                TimeUnit.SECONDS
        );
    }

    private void sendMessage() {
        mHandler.sendEmptyMessage((int) (Math.random() * 10));
    }

    private static class MyHandler extends Handler {

        private final WeakReference<HandlerActivity> mActivityRef;

        public MyHandler(HandlerActivity activity) {
            mActivityRef = new WeakReference<>(activity);
        }


        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.e(TAG, String.valueOf(msg.what));
            if (mActivityRef.get() != null) {
                AppSystem.out.printt(mActivityRef.get(), String.format("hello, msg.getWhat() == %d", msg.what));
            }
        }
    }
}