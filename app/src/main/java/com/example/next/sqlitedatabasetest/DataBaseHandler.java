package com.example.next.sqlitedatabasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by next on 24/3/17.
 */
public class DataBaseHandler extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "MYDATABASE";
    //tables
    public static String DEPT_TABLE_NAME = "DepartmentTable";
    public static String EMPLOYEE_TABLE_NAME = "EmployeeTable";
    //deprtmnts
    private static final String Dept_ID = "id";
    private static final String Dept_Name = "name";
    public static int DATABASE_NUMBER = 3;

//employees
    public static final String EMP_ID = "empId";
    public static final String EMP_NAME = "employeeName";
    public static final String Emp_DATE = "joiningDate";
    public static final String DEPART_MENT_ID = "DepartmentId";
    //public static final String Dept_NAME="employeeName";


    //  public static final String Dept_Date="employeeName";
    //public static final String EMP_NAME="employeeName";


    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_NUMBER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String DepartMent_table = "CREATE TABLE " + DEPT_TABLE_NAME + "("
                + Dept_ID + " INTEGER PRIMARY KEY," + Dept_Name + " TEXT not null" + ")";
        db.execSQL(DepartMent_table);

        String Employee_table = "CREATE TABLE " + EMPLOYEE_TABLE_NAME + "("
                + DEPART_MENT_ID + " INTEGER," + EMP_ID + " INTEGER PRIMARY KEY," + EMP_NAME +
                " TEXT not null," + Emp_DATE +
                " TEXT not null" + ")";
        db.execSQL(Employee_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DEPT_TABLE_NAME);
        onCreate(db);

    }


    //inserting dept data into db

    public void insertDepartmentData(DeptModel dept) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Dept_Name, dept.getGetDepartmentName()); // Contact Name
        values.put(Dept_ID, dept.getDepartmentId()); // Contact Phone Number

        // Inserting Row
        db.insert(DEPT_TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }


    //inserting data into db
    public void insetEmployeeData(EmployeeModel employee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DEPART_MENT_ID, employee.getDeptID());
        values.put(EMP_ID, employee.getEmpId());
        values.put(EMP_NAME, employee.getEmployeeName());
        values.put(Emp_DATE, employee.getJoiningDate());

        // Inserting Row
        db.insert(EMPLOYEE_TABLE_NAME, null, values);
        db.close();
    }


    public List<DeptModel> fetchDepartmentData() {

        List<DeptModel> deptArrayList = new ArrayList<DeptModel>();

        // Select All Query
        String selectQuery = "SELECT  " + DEPART_MENT_ID + ", " + Dept_Name + ", count(" + Dept_Name
                + ") FROM " + EMPLOYEE_TABLE_NAME + " inner join " + DEPT_TABLE_NAME + " on "
                + EMPLOYEE_TABLE_NAME + "." + DEPART_MENT_ID + " = " + DEPT_TABLE_NAME +
                "." + Dept_ID + " group by " + Dept_Name;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DeptModel dept = new DeptModel();
                dept.setDepartmentId(Integer.parseInt(cursor.getString(0)));
                dept.setGetDepartmentName(cursor.getString(1));
                dept.setHeadCount(cursor.getInt(2));
                // Adding contact to list
                deptArrayList.add(dept);
            } while (cursor.moveToNext());
        }

        // return contact list
        return deptArrayList;
    }

    public List<EmployeeModel> fetchEmployeesDetails() {
        List<EmployeeModel> deptArrayList = new ArrayList<EmployeeModel>();
        String selectQuery = "SELECT  * FROM " + EMPLOYEE_TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                EmployeeModel employee = new EmployeeModel();
                employee.setDeptID(Integer.parseInt(cursor.getString(0)));
                employee.setEmpId(Integer.valueOf(cursor.getString(1)));
                employee.setEmployeeName(cursor.getString(2));
                employee.setJoiningDate(cursor.getString(3));


                deptArrayList.add(employee);
            } while (cursor.moveToNext());
        }

        // return contact list
        return deptArrayList;
    }


}











/* public void dropTable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+ DEPT_TABLE_NAME;
        String clearDBQuery2 = "DELETE FROM "+EMPLOYEE_TABLE_NAME;

        db.execSQL(clearDBQuery);
        db.execSQL(clearDBQuery2);
    }*/
