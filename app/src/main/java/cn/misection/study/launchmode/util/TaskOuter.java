package cn.misection.study.launchmode.util;

import android.app.Activity;

import cn.misection.util.oututil.system.AppSystem;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName OutInfo
 * @Description TODO
 * @CreateTime 2021年09月16日 16:47:00
 */
public class TaskOuter {

    private TaskOuter() {
        throw new RuntimeException(String.format("here are no %s info for you", getClass().getName()));
    }

    public static void printTaskIdAndInstancePointer(Activity context) {
        AppSystem.out.printfToast(context, String.format("context.getTaskId() = %d%npointer of context) = %s", context.getTaskId(), String.valueOf(context)));
        System.out.println("context.getTaskId() = " + context.getTaskId());
        System.out.println("String.valueOf(context) = " + String.valueOf(context));
    }
}
