package com.team4844.myown.threadexam001;

import android.os.Message;

/**
 * Created by Myown on 2017-03-12.
 */

public class CountThread extends Thread {

    private String input_data;
    private int count;
    private String output_data;

    public CountToMainHandler handler;

    public CountThread(){
        // default
        this.count = 0;
        this.input_data = new String();
        this.output_data = new String();
        this.handler = new CountToMainHandler();
    }

    public CountThread(String input_data){
        this.input_data = input_data;
        this.count = 0;
    }

    public void setInputData(String input){
        this.input_data = input;
    }

    public String getOutputData(){
        return this.output_data;
    }

    @Override
    public void run() {

        for(int i = 0; i < 10000; i++){
            this.count += 1;
        }

        this.input_data += Integer.toString(this.count);

        this.output_data = this.input_data;

        Message msg = this.handler.obtainMessage();
        msg.obj = (Object)getOutputData();
        this.handler.handleMessage(msg);

        super.run();

    }
}
