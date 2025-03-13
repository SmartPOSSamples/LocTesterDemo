package com.cloudpos.api;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.cloudpos.api.receiver.LocationReceiver;
import com.cloudpos.utils.TextViewUtil;


public class MainActivity extends AbstractActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_test1 = (Button) this.findViewById(R.id.btn_test1);
        Button btn_test2 = (Button) this.findViewById(R.id.btn_test2);
        Button btn_test3 = (Button) this.findViewById(R.id.btn_test3);

        ((Button) this.findViewById(R.id.btn_test4)).setOnClickListener(this);
        ((Button) this.findViewById(R.id.btn_test5)).setOnClickListener(this);
        ((Button) this.findViewById(R.id.btn_test6)).setOnClickListener(this);

        log_text = (TextView) this.findViewById(R.id.text_result);
        log_text.setMovementMethod(ScrollingMovementMethod.getInstance());

        findViewById(R.id.settings).setOnClickListener(this);
        btn_test1.setOnClickListener(this);
        btn_test2.setOnClickListener(this);
        btn_test3.setOnClickListener(this);

//        initProcStatsData();

//        SystemProperties
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == R.id.log_default) {
                    log_text.append("\t" + msg.obj + "\n");
                } else if (msg.what == R.id.log_success) {
                    String str = "\t" + msg.obj + "\n";
                    TextViewUtil.infoBlueTextView(log_text, str);
                } else if (msg.what == R.id.log_failed) {
                    String str = "\t" + msg.obj + "\n";
                    TextViewUtil.infoRedTextView(log_text, str);
                } else if (msg.what == R.id.log_clear) {
                    log_text.setText("");
                }
            }
        };
        writerInSuccessLog("ACTION = " + LocationReceiver.ACTION);
        writerInSuccessLog("GPS = " + LocationReceiver.GPS);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View arg0) {
        int index = arg0.getId();
        if (index == R.id.btn_test1) {
            writerInSuccessLog("ACTION = " + LocationReceiver.ACTION);
            writerInSuccessLog("GPS = " + LocationReceiver.GPS);

        } else if (index == R.id.btn_test2) {
//            testProcStatsData(3 );
        } else if (index == R.id.btn_test3) {
//            testProcStatsData(6 );
        } else if (index == R.id.btn_test4) {
//            testProcStatsData(12);
        } else if (index == R.id.btn_test5) {
//            testProcStatsData(24);
        } else if (index == R.id.btn_test6) {

        } else if (index == R.id.settings) {
            log_text.setText("");
        }
    }

}
