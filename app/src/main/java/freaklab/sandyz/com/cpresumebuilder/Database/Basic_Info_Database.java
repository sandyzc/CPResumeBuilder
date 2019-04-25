package freaklab.sandyz.com.cpresumebuilder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import freaklab.sandyz.com.cpresumebuilder.beans.Basic_Info_Beans;

public class Basic_Info_Database extends SQLiteOpenHelper {

    private Context mycontext;

    private SQLiteDatabase database;

    private static final int DB_VERSION = 1;
    private static String Db_Name = "basic_info.db";
    private static String Table_name = "basic_info_data";
    private static String ID = "id";
    private static String Name = "name";
    private static String Title = "title";
    private static String Summery = "profile_summery";
    private static String Phone_number = "phone_number";
    private static String Email = "email_id";
    private static String Address_line1 = "address_lin1";
    private static String Address_line2 = "address_line2";
    private static String Street = "address_street";
    private static String Pincode = "address_pincode";
    private static String Objective = "professional_objective";


    public Basic_Info_Database(Context context) {
        super(context, Db_Name, null, DB_VERSION);
        this.mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create_table = "CREATE TABLE IF NOT EXISTS " + Table_name +
                "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Name + " Text,"
                + Title + " Text,"
                + Summery + " Text,"
                + Phone_number + " Text,"
                + Email + " Text,"
                + Address_line1 + " Text,"
                + Address_line2 + " Text,"
                + Street + " Text,"
                + Pincode + " Text,"
                + Objective + " Text)";

        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_name);

    }

    public void openDB() {
        if (this.database == null) {
            this.database = this.getWritableDatabase();
        }
    }

    public void closeDB() {
        if (this.database != null) {
            database.close();
        }


    }

    public long insertData(String name_, String Title_, String Summery_, String ph_number, String e_mail
            , String add_line1, String add_line2, String street_, String pin_code, String ob_jective) {

            this.database = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Name, name_);
            values.put(Title, Title_);
            values.put(Summery, Summery_);
            values.put(Phone_number, ph_number);
            values.put(Email, e_mail);
            values.put(Address_line1, add_line1);
            values.put(Address_line2, add_line2);
            values.put(Street, street_);
            values.put(Pincode, pin_code);
            values.put(Objective, ob_jective);

            Log.d("DataBase", "Data sucessfully saved");

            return this.database.insert(Table_name, null, values);
             }

    public ArrayList<Basic_Info_Beans> basic_info_data() {

        this.database=this.getReadableDatabase();

        ArrayList<Basic_Info_Beans> data = new ArrayList<Basic_Info_Beans>();

        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);
        if (cursor.moveToFirst()) {
            do {
                Basic_Info_Beans beans = new Basic_Info_Beans();
                beans.setName(cursor.getString(1));
                beans.setTitle(cursor.getString(2));
                beans.setProfile_summery(cursor.getString(3));
                beans.setPhone_number(cursor.getString(4));
                beans.setEmail_id(cursor.getString(5));
                beans.setAddress_lin1(cursor.getString(6));
                beans.setAddress_line2(cursor.getString(7));
                beans.setAddress_street(cursor.getString(8));
                beans.setAddress_pincode(cursor.getString(9));
                beans.setProfessional_objective(cursor.getString(10));

                data.add(beans);
            }
            while (cursor.moveToNext());
        }
        return data;
    }

    public String getname(){
        this.database=this.getReadableDatabase();

        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);

        if (cursor.moveToFirst()){
            name=cursor.getString(1);
        }

        return name;

    }
    public String getProfession(){
        this.database=this.getReadableDatabase();

        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);

        if (cursor.moveToFirst()){
            name=cursor.getString(2);
        }

        return name;

    }


    public String getEmail(){
        this.database=this.getReadableDatabase();

        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);

        if (cursor.moveToFirst()){
            name=cursor.getString(5);
        }
        return name;
    }


    public String getphone_number(){
        this.database=this.getReadableDatabase();
        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);
        if (cursor.moveToFirst()){
            name=cursor.getString(4);
        }
        return name;

    }
    public String getAddress_line2(){
        this.database=this.getReadableDatabase();
        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);
        if (cursor.moveToFirst()){
            name=cursor.getString(7);
        }
        return name;

    }

    public String getAddress_line1(){
        this.database=this.getReadableDatabase();
        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);
        if (cursor.moveToFirst()){
            name=cursor.getString(6);
        }
        return name;

    }

//    Street-8

    //    Pincode-9
//    Objective-10
    public String getStreet(){
        this.database=this.getReadableDatabase();
        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);
        if (cursor.moveToFirst()){
            name=cursor.getString(8);
        }
        return name;

    }
    public String getPincode(){
        this.database=this.getReadableDatabase();
        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);
        if (cursor.moveToFirst()){
            name=cursor.getString(9);
        }
        return name;

    }
    public String getObjective(){
        this.database=this.getReadableDatabase();
        String name="";
        String arguments = " SELECT * FROM " + Table_name;
        Cursor cursor = this.database.rawQuery(arguments, null);
        if (cursor.moveToFirst()){
            name=cursor.getString(10);
        }
        return name;

    }


}
