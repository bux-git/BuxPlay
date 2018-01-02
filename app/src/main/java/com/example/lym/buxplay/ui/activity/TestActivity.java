package com.example.lym.buxplay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lym.buxplay.R;

/**
 * @Description：
 * @author：Bux on 2017/12/26 21:39
 * @email: 471025316@qq.com
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_top_list_layout);
        View top=findViewById(R.id.tv_top);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
