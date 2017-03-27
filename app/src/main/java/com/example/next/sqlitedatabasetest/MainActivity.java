package com.example.next.sqlitedatabasetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
     Button click;
    private ExpandableListView mExpandableListView;
    DatapassInterface datapassInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandable_listview);
        click= (Button) findViewById(R.id.button);

        DataBaseHandler db = new DataBaseHandler(this);
        db.insertDepartmentData(new DeptModel(1,"INstrument"));
        db.insertDepartmentData(new DeptModel(2,"agriculture"));
        db.insertDepartmentData(new DeptModel(3,"science"));
        db.insertDepartmentData(new DeptModel(4,"it"));
        db.insertDepartmentData(new DeptModel(5,"arts"));
        db.insertDepartmentData(new DeptModel(6,"cs"));
        List<DeptModel> deptArrayList = db.fetchDepartmentData();

        db.insetEmployeeData(new EmployeeModel(1,"sarika","1-06-2018",564));
        db.insetEmployeeData(new EmployeeModel(1,"bhvya","19-04-2016",54));
        db.insetEmployeeData(new EmployeeModel(2,"priyanka","19-01-2012",566));
        db.insetEmployeeData(new EmployeeModel(2,"soumya","10-09-12",72));
        db.insetEmployeeData(new EmployeeModel(2,"sony","10-09-12",534));
        db.insetEmployeeData(new EmployeeModel(2,"soumya","10-09-12",73));
        db.insetEmployeeData(new EmployeeModel(2,"soumya","10-09-12",74));
        db.insetEmployeeData(new EmployeeModel(3,"dfgg","14-05-12",75));
        db.insetEmployeeData(new EmployeeModel(3,"grgrg","12-07-12",76));
        db.insetEmployeeData(new EmployeeModel(3,"gfdgfg","10-09-12",78));
        db.insetEmployeeData(new EmployeeModel(3,"gfdg","10-09-12",77));
        db.insetEmployeeData(new EmployeeModel(3,"gfdgdg","10-09-12",79));

        List<EmployeeModel> employeeList = db.fetchEmployeesDetails();


        ExpandableList adapter = new ExpandableList(employeeList, deptArrayList,this);
        mExpandableListView.setAdapter(adapter);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this ,ListViewActivity.class);
                startActivity(i);
            }
        });

    }







}