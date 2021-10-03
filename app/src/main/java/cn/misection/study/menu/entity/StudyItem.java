package cn.misection.study.menu.entity;

import androidx.appcompat.app.AppCompatActivity;

import cn.misection.study.handler.HandlerActivity;
import cn.misection.study.launchmode.controller.LaunchControllerActivity;
import cn.misection.study.lifecycle.controller.LifeCycleActivity;
import cn.misection.study.subthreadupdateui.SubThreadUpdateUiActivity;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName StudyItem
 * @Description TODO
 * @CreateTime 2021年10月03日 22:05:00
 */
public enum StudyItem {

    /**
     * data;
     */
    ACTIVITY_LIFE_CYCLE("Activity 生命周期", LifeCycleActivity.class),

    ACTIVITY_LAUNCH_MODE("Activity 启动模式", LaunchControllerActivity.class),

    SUB_THREAD_UPDATE_UI("子线程更新 UI", SubThreadUpdateUiActivity.class),

    HANDLER("handler", HandlerActivity.class),
    ;
    private final String title;

    private final Class<? extends AppCompatActivity> activityClass;

    StudyItem(String title, Class<? extends AppCompatActivity> activityClass) {
        this.title = title;
        this.activityClass = activityClass;
    }

    public String getTitle() {
        return title;
    }

    public Class<? extends AppCompatActivity> getActivityClass() {
        return activityClass;
    }
}
