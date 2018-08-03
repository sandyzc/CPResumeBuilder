package freaklab.sandyz.com.cpresumebuilder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import freaklab.sandyz.com.cpresumebuilder.beans.Education_Beans;


public class Education_Databse extends SQLiteOpenHelper {

    private Context ctx;
    private SQLiteDatabase database;
    private static String Db_Name="edu_details.db";
    private static final int version=1;
    private static String Table_name="edu_details";
    private static String ID="id";
    private static String college_name= "college_name";
    private static String major="major";
    private static String edu_from ="edu_from";
    private static String edu_to ="edu_to";

    public Education_Databse(Context context) {
        super(context, Db_Name,null, version);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String exec= "CREATE TABLE IF NOT EXISTS "+Table_name+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +college_name +" TEXT,"
                + major + " TEXT,"
                + edu_from + " TEXT,"
                +  edu_to + " TEXT)";

        db.execSQL(exec);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS "+Table_name);

    }

    public long insert_edu_details (String college_name1, String major1, String edu_from1, String edu_to1){

        database= this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(college_name,college_name1);
        contentValues.put(major,major1);
        contentValues.put(edu_from,edu_from1);
        contentValues.put(edu_to,edu_to1);


        return this.database.insert(Table_name, null, contentValues);

    }

    public ArrayList<Education_Beans> edu_data(){

        ArrayList<Education_Beans> data = new ArrayList<Education_Beans>();

        String arguments = " SELECT * FROM "+Table_name;

        database=this.getWritableDatabase();

        Cursor cursor = database.rawQuery(arguments,null);

        if (cursor.moveToFirst()){

            do {
                Education_Beans beans = new Education_Beans();
                beans.setCollege_name(cursor.getString(1));
                beans.setMajor(cursor.getString(2));
                beans.setEdu_from(cursor.getString(3));
                beans.setEdu_to(cursor.getString(4));

                data.add(beans);
            }
            while (cursor.moveToNext());

        }
        cursor.close();

        return data;
    }

    public void open() {
        if (this.database == null) {
            try {
                this.database = this.getWritableDatabase();
            } catch (SQLException ignored) {

            }
        }
    }

}
