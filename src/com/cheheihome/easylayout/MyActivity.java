package com.cheheihome.easylayout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.cheheihome.easylayout.widget.EasyLayout;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    private EasyLayout easyLayout;
    TextView header;
    TextView indicator;
    ListView listView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        header = (TextView) findViewById(R.id.header);

        indicator = (TextView) findViewById(R.id.indicator);
        listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
        listView.setAdapter(adapter);


    }

    private ArrayList<String> getData() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 12; i++) list.add(i + "");

        for(String s:list) Log.i("data",s);


        return (ArrayList<String>) list;
    }
}
