package com.example.next.sqlitedatabasetest;

/**
 * Created by next on 24/3/17.
 */
public class DeptModel {
    int departmentId;
    String getDepartmentName;
    int headCount;

    public int getHeadCount() {
        return headCount;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public DeptModel()
    {
    }

    public DeptModel(int departmentId, String getDepartmentName)
    {
        this.departmentId = departmentId;
        this.getDepartmentName = getDepartmentName;
    }

    public int getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(int departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getGetDepartmentName()
    {
        return getDepartmentName;
    }

    public void setGetDepartmentName(String getDepartmentName)
    {
        this.getDepartmentName = getDepartmentName;
    }

}
