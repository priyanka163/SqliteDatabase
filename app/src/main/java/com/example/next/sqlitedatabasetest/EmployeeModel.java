package com.example.next.sqlitedatabasetest;

/**
 * Created by next on 24/3/17.
 */
public class EmployeeModel {
    int deptID;
    String employeeName;
    String joiningDate;
    String mobileNumber;
    int empId;
    String deptName;

    public EmployeeModel()
    {
    }

    public EmployeeModel(int deptID, String employeeName, String joiningDate, int empId)
    {
        this.deptID = deptID;
        this.employeeName = employeeName;
        this.joiningDate = joiningDate;
        this.empId = empId;

    }

    public int getEmpId()
    {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }



    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public String getJoiningDate()
    {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate)
    {
        this.joiningDate = joiningDate;
    }
    public int getDeptID()
    {
        return deptID;
    }

    public void setDeptID(int deptID)
    {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
