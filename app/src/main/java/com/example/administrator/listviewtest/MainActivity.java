package com.example.administrator.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView listview;
    private List<String> stringList;

    private PowerfulAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringList = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            stringList.add("不写adapter，直接匿名内部类实现" + (i + 50));
        }

        listview = (ListView) findViewById(R.id.listview);


        adapter = new PowerfulAdapter<String>(this, stringList, R.layout.item_single_str) {
            @Override
            public void convert(ViewHolder holder, String item) {
                holder.setText(R.id.id_tv_title, item);
                Button button = holder.getView(R.id.button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "我是按钮，我被点击了----->", Toast.LENGTH_LONG).show();
                    }
                });

            }
        };
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "我被点击了----->" + i, Toast.LENGTH_LONG).show();
            }
        });

    }


}

