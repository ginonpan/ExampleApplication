package com.example.exampleapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment
        implements OnItemClickListener  {

    static List<String> dataList = new ArrayList<String>();
    static ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.fragment_list,
                container,
                false);
        listView = (ListView)
                v.findViewById(R.id.listView);
        return v;
    }

    @Override
    public void onActivityCreated(
            Bundle savedInstanceState) {
        super.onActivityCreated(
                savedInstanceState);

        // データ初期化
        if(dataList.size() == 0){
            dataList.add("Foo");
            dataList.add("Bar");
            dataList.add("Baz");
        }

        // アダプターの作成と設定
        adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(
            AdapterView<?> parent,
            View view,
            int position,
            long id) {

        Activity a = getActivity();
        if(a instanceof OnSampleListChangeListener){
            OnSampleListChangeListener listener =
                    (OnSampleListChangeListener) getActivity();
            listener.onListSelectedChanged(dataList.get(position));
        }

    }
}