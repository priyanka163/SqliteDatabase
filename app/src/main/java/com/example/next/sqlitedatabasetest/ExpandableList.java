package com.example.next.sqlitedatabasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by next on 24/3/17.
 */
public class ExpandableList extends BaseExpandableListAdapter
{
    List<EmployeeModel> mEmployeeList;
    List<DeptModel> mDeptList;
    Context context;
    HashMap<Integer,List<EmployeeModel>> selectdMap = new HashMap<>();
    int mTotalNumberOfEmp;

    public ExpandableList(List<EmployeeModel> mEmployeeList, List<DeptModel> mDeptList, Context context)
    {
        this.mEmployeeList = mEmployeeList;
        this.mDeptList = mDeptList;
        this.context = context;
    }

    @Override
    public int getGroupCount()
    {
        return mDeptList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        List<EmployeeModel> selectedList = new ArrayList<>();

        int deptId = mDeptList.get(groupPosition).getDepartmentId();
        for (int i = 0; i < mEmployeeList.size(); i++)
        {
            EmployeeModel employee = mEmployeeList.get(i);
            if (deptId == employee.getDeptID())
            {

                selectedList.add(employee);
            }
        }
        selectdMap.put(groupPosition,selectedList);
        mTotalNumberOfEmp = selectedList.size();
        return selectedList.size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return 0;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {

        LayoutInflater layoutInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.group, null);

        TextView name_text = (TextView) convertView.findViewById(R.id.deptname);
        TextView total_number = (TextView) convertView.findViewById(R.id.deptcount);
        name_text.setText(mDeptList.get(groupPosition).getGetDepartmentName());
        total_number.setText(String.valueOf(getChildrenCount(groupPosition)));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.child, null);
        TextView empName = (TextView) convertView.findViewById(R.id.EmpName);
        TextView Empid = (TextView) convertView.findViewById(R.id.Empid);
        List<EmployeeModel> employeeList = selectdMap.get(groupPosition);
        EmployeeModel employee = employeeList.get(childPosition);
        empName.setText(employee.getEmployeeName());
        Empid.setText(String.valueOf(employee.getEmpId()));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
}

