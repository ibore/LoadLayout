package com.monians.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.monians.xload.XLoadLayout;

public class MainActivity extends AppCompatActivity implements XLoadLayout.OnLoadClickListener{

    private LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = LayoutInflater.from(this);

        final XLoadLayout xLoadLayout = (XLoadLayout) findViewById(R.id.xloadlayout);
        // 通过代码添加
//        xLoadLayout.setLoadingView(R.layout.layout_loading);
//        xLoadLayout.setEmptyView(R.layout.layout_empty);
//        xLoadLayout.setErrorView(R.layout.layout_error);

//        View loadingView = inflater.inflate(R.layout.layout_loading, null);
//        xLoadLayout.setLoadingView(loadingView);
//        View emptyView = inflater.inflate(R.layout.layout_empty, null);
//        xLoadLayout.setEmptyView(emptyView);
//        View errorView = inflater.inflate(R.layout.layout_empty, null);
//        xLoadLayout.setErrorView(errorView);


        findViewById(R.id.loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xLoadLayout.showLoadingView();
            }
        });
        findViewById(R.id.empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xLoadLayout.showEmptyView();
            }
        });
        findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xLoadLayout.showErrorView();
            }
        });
        findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xLoadLayout.showContentView();
            }
        });

        xLoadLayout.setOnLoadingClickListener(new XLoadLayout.OnLoadClickListener() {
            @Override
            public void onEmptyClick() {
                Toast.makeText(getApplicationContext(), "点击重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onErrorClick() {
                Toast.makeText(getApplicationContext(), "点击重试", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public void onEmptyClick() {

    }

    @Override
    public void onErrorClick() {

    }
}
