package com.zm.multiplestatus.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zm.common.view.MultipleStatusView;

public class MainActivity extends AppCompatActivity {
    MultipleStatusView multipleStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        multipleStatusView=findViewById(R.id.multiple_status_view);
        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multipleStatusView.showContent();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.getMenuInflater().inflate(R.menu.main_menu, menu);//填充菜单项
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                multipleStatusView.showContent();
                break;
            case R.id.item2:
                multipleStatusView.showEmpty();
                break;
            case R.id.item3:
                multipleStatusView.showError();
                break;
            case R.id.item4:
                multipleStatusView.showNoNetwork();
                break;
            case R.id.item5:
                multipleStatusView.showLoading();
                break;
        }
        return false;
    }
}
