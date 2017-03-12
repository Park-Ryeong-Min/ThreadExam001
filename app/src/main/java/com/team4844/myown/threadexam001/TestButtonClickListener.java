package com.team4844.myown.threadexam001;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Myown on 2017-03-12.
 */

public class TestButtonClickListener implements View.OnClickListener {

    private final String TAG = "CLICK LISTENER";
    private CountToMainHandler handler;
    private CountThread thread;
    private Context context;

    public TestButtonClickListener(Context context){
        this.handler = new CountToMainHandler();
        this.thread = new CountThread();
        this.context = context;
    }


    @Override
    public void onClick(View v) {
        this.thread.setInputData("테스트용");
        this.thread.run();

        Log.i(TAG, "클릭 이벤트 발생");

        try {
            this.thread.join();
        }catch (InterruptedException interex){
            interex.printStackTrace();
        }

        Toast.makeText(context, this.thread.getOutputData(), Toast.LENGTH_LONG).show();

    }

    public CountToMainHandler getHandler(){
        return this.handler;
    }
}
