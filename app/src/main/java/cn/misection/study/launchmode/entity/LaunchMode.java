package cn.misection.study.launchmode.entity;

import androidx.appcompat.app.AppCompatActivity;

import cn.misection.study.launchmode.controller.SingleInstanceActivity;
import cn.misection.study.launchmode.controller.SingleTaskActivity;
import cn.misection.study.launchmode.controller.SingleTopActivity;
import cn.misection.study.launchmode.controller.StandardActivity;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName LaunchMode
 * @Description TODO
 * @CreateTime 2021年10月04日 12:50:00
 */
public enum LaunchMode {

    /**
     * launch mode;
     */
    SINGLE_INSTANCE("single instance 启动", SingleInstanceActivity.class),

    SINGLE_TASK("single task 启动", SingleTaskActivity.class),

    SINGLE_TOP("single top 启动", SingleTopActivity.class),

    STANDARD("standard 启动", StandardActivity.class),
    ;

    private final String title;

    private final Class<? extends AppCompatActivity> activityClass;

    LaunchMode(String title, Class<? extends AppCompatActivity> activityClass) {
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
