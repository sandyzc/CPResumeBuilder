package freaklab.sandyz.com.cpresumebuilder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import freaklab.sandyz.com.cpresumebuilder.beans.Experince_Beans;

public class Expereince_Database extends SQLiteOpenHelper {

    Context ctxt;
    SQLiteDatabase database;

    private static String DB_NAME = "expereince_details.db";
    private static int VERSION = 1;
    final String TABLE_NAME = "expereince_details";

    private static String ID = "id";
    private static String company_name = "company_name";
    private static String designation = "designation";
    private static String work_from = "work_from";
    private static String work_to = "work_to";

    public Expereince_Database(Context context) {
        super(context, DB_NAME, null, VERSION);

        this.ctxt = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String exec = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + company_name + " TEXT,"
                + designation + " TEXT,"
                + work_from + " TEXT,"
                + work_to + " TEXT)";
        db.execSQL(exec);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }

    //insert data into database

    public long insert_expereince_data(String comapany_namee, String designationn, String worked_from, String worked_up_to) {

        database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(company_name, comapany_namee);
        values.put(designation, designationn);
        values.put(work_from, worked_from);
        values.put(work_to, worked_up_to);

        return this.database.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Experince_Beans> get_all_experiece() {

        ArrayList<Experince_Beans> data = new ArrayList<>();

        String arguments = " SELECT * FROM " + TABLE_NAME;

        database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery(arguments, null);


        if (cursor.moveToFirst()) {
            do {
                Experince_Beans beans = new Experince_Beans();
                beans.setCompany_name(cursor.getString(1));
                beans.setDesignation(cursor.getString(2));
                beans.setStart_year(cursor.getString(3));
                beans.setLeft_year(cursor.getString(4));
                data.add(beans);
            }
            while (cursor.moveToNext());
        }

        cursor.close();

        return data;
    }

    public void open_exp_db(){

        if (this.database == null) {
            try {
                this.database = this.getWritableDatabase();
            } catch (SQLException ignored) {

            }
        }
    }

}
