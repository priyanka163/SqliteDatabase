package com.example.next.sqlitedatabasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListViewActivity extends AppCompatActivity {
ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListView= (ListView) findViewById(R.id.listview);

        DataBaseHandler dbhandler= new DataBaseHandler(this);
        List<EmployeeModel> emplist = dbhandler.fetchEmployeesDetails();


        ListAdapter adapter= new ListAdapter(this,emplist);
        mListView.setAdapter(adapter);


    }
}
