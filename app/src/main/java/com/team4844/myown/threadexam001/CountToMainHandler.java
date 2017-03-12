package com.team4844.myown.threadexam001;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by Myown on 2017-03-12.
 */

public class CountToMainHandler extends Handler {

    private final String TAG = "MSG HANDLER";
    private String msg;

    public CountToMainHandler(){
        this.msg = new String();
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        this.msg = (String)msg.obj;
        Log.i(TAG, this.msg);
    }

    public String getMsg(){
        return this.msg;
    }
}
