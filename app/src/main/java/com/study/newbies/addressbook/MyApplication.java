package com.study.newbies.addressbook;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.study.newbies.addressbook.util.LogUtil;

/**
 *
 * @author NewBies
 * @date 2018/8/19
 */

public class MyApplication extends Application{

    private static Context context = null;

    @Override
    public void onCreate(){
        super.onCreate();
        context = getContext();
        //定义活动的生命周期监听回调函数
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            private final String lifecycle = "lifecycle";
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LogUtil.v(lifecycle, activity.getLocalClassName() + " is created");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                LogUtil.v(lifecycle, activity.getLocalClassName() + " is started");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtil.v(lifecycle, activity.getLocalClassName() + " is resumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                LogUtil.v(lifecycle, activity.getLocalClassName() + " is paused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                LogUtil.v(lifecycle, activity.getLocalClassName() + " is stopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                LogUtil.v(lifecycle, activity.getLocalClassName() + " is save instance state");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                LogUtil.v(lifecycle, activity.getLocalClassName() + " is destroyed");
            }
        });
    }

    public static Context getContext(){
        return context;
    }
}
