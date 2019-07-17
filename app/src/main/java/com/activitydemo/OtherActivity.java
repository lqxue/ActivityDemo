package com.activitydemo;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by 12533 on 2019-7-16.
 */

public class OtherActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.standard_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StandardActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.singleTop_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SingleTopActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.singleTask_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SingleTaskActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.singleInstance_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SingleInstanceActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.other_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OtherActivity.class);
//                intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "===========================================onDestroy=========================================================");
        Log.e("TAG", "onDestroy " + getClass().getSimpleName() + " TaskId: " + getTaskId() + " hasCode:" + this.hashCode());
        dumpTaskAffinity();
    }
}



