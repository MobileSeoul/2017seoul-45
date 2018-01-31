package com.example.guswn_000.san;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityManager {
    private static ActivityManager activityMananger = null;
    private ArrayList<Activity> activityList = null;

    private ActivityManager() {
        activityList = new ArrayList<Activity>();
    }

    public static ActivityManager getInstance() {

        if( ActivityManager.activityMananger == null ) {
            activityMananger = new ActivityManager();
        }
        return activityMananger;
    }

    /**
     * 액티비티 리스트 getter.
     * @return activityList
     */
    public ArrayList<Activity> getActivityList() {
        return activityList;
    }

    /**
     * 액티비티 리스트에 추가.
     * @param activity
     */
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * 액티비티 리스트에서 삭제.
     * @param activity
     * @return boolean
     */
    public boolean removeActivity(Activity activity) {
        return activityList.remove(activity);
    }

    /**
     * 모든 액티비티 종료.
     */
    public void finishAllActivity() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

}
