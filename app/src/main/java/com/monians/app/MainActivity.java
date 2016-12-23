package com.monians.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.monians.load.LoadLayout;


public class MainActivity extends AppCompatActivity implements LoadLayout.OnLoadClickListener{

    private LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = LayoutInflater.from(this);

        final LoadLayout xLoadLayout = (LoadLayout) findViewById(R.id.loadlayout);

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

        xLoadLayout.setOnLoadingClickListener(this);
    }

    @Override
    public void onEmptyClick() {
        Toast.makeText(getApplicationContext(), "点击重试", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorClick() {
        Toast.makeText(getApplicationContext(), "点击重试", Toast.LENGTH_SHORT).show();
    }
}
