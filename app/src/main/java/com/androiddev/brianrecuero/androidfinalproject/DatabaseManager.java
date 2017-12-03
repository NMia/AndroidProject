package com.androiddev.brianrecuero.androidfinalproject;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Nazim Mia on 12/2/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usersDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ACCOUNTS ="User_Accounts";
    private static final String USER_ID = "User_ID";
    private static final String USER_NAME = "User_Name";
    private static final String USER_EMAIL = "User_Email";
    private static final String USER_PASSWORD = "User_Password";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreateTable= "create table " + TABLE_ACCOUNTS + " ( " + USER_ID + " integer primary key autoincrement, ";
        sqlCreateTable+= USER_NAME + " text, " + USER_EMAIL + " text, " + USER_PASSWORD + " text )";
        sqLiteDatabase.execSQL(sqlCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old, int current)
    {
        sqLiteDatabase.execSQL("drop table if exists "+ TABLE_ACCOUNTS);
        onCreate(sqLiteDatabase);
    }
    public void addAccount( Account account ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_ACCOUNTS;
        sqlInsert += " values( null, '" + account.getUserName( ) + "', '";
        sqlInsert += account.getEmail( ) + "', '" +  account.getPassword( ) + "' )";

        db.execSQL( sqlInsert ); // inserts username, email, password
        db.close( );
    }

    public boolean searchForEmail(String mail )
    {
        SQLiteDatabase db = this.getWritableDatabase( );

        try // should return true if the email address is already used
        {
            String sqlSearch = "select * from " + TABLE_ACCOUNTS;
            sqlSearch += " where User_Email = '" + mail + " '";
            db.execSQL(sqlSearch); // gets data for entry that has email equal to the parameter, mail
            return true;
        }

        catch(SQLException sqlx) // search was unsuccessful
        {
            sqlx.printStackTrace();
            return false;
        }

        finally
        {
            db.close( );
        }

    }

    public ArrayList<Account> selectAll( ) // returns all accounts in database
    {
        String sqlQuery = "select * from " + TABLE_ACCOUNTS;

        SQLiteDatabase db = this.getWritableDatabase( );
        Cursor cursor = db.rawQuery( sqlQuery, null );

        ArrayList<Account> accountList = new ArrayList<Account>( );
        while( cursor.moveToNext( ) )
        {
            Account currentAccount = new Account(cursor.getString( 0 ), cursor.getString( 1 ), cursor.getString( 2 ));
            accountList.add( currentAccount );
        }
        db.close( );
        return accountList;
    }
}