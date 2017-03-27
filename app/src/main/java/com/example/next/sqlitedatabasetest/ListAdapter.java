package com.example.next.sqlitedatabasetest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by next on 24/3/17.
 */
public class ListAdapter extends BaseAdapter
{
Context mContext;
    List<EmployeeModel> mEmployeeArrayList;
    LayoutInflater mLayoutInflater;

    public ListAdapter(Context context, List<EmployeeModel> mEmployeeArrayList) {
        this.mContext = context;
        this.mEmployeeArrayList = mEmployeeArrayList;

    }

    @Override
    public int getCount() {
        return mEmployeeArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mEmployeeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = null;

        if (inflater == null) {
            inflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        }




        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listadpter, parent,false);
          holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.empid.setText("Id,"+mEmployeeArrayList.get(position).getEmpId());
        holder.empName.setText(mEmployeeArrayList.get(position).getEmployeeName());
        holder.reportedDateView.setText(mEmployeeArrayList.get(position).getJoiningDate());
        holder.deptid.setText("deptid"+mEmployeeArrayList.get(position).getDeptID());


        return convertView;
    }

    static class ViewHolder {
        TextView empid;
        TextView empName;
        TextView reportedDateView;
        TextView deptid;

        public ViewHolder(View convertView) {


            empName = (TextView) convertView.findViewById(R.id.emp_name);
            empid = (TextView) convertView.findViewById(R.id.emp_Id);
            reportedDateView = (TextView) convertView.findViewById(R.id.date);
            deptid = (TextView) convertView.findViewById(R.id.dept_id);
        }
    }
}
