package com.android.lib.sqlite;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private String dbName = null;
	private int dbVersion = 0;
	private Context context = null;
	private CursorFactory factory = null;
	private ArrayList<String> queryList = null;

	public DBHelper(Context context, String dbName, CursorFactory factory,
			int dbVersion, ArrayList<String> queryList) {
		super(context, dbName, factory, dbVersion);
		this.dbName = dbName;
		this.dbVersion = dbVersion;
		this.context = context;
		this.factory = factory;
		this.queryList = queryList;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("Creating: " + dbName);
		for (String query : queryList) {
			db.execSQL(query);
		}

	}

	public long insertRow(String tableName, ContentValues contentValues) {
		SQLiteDatabase db = this.getWritableDatabase();
		long affectedRow = -1;
		try {
			affectedRow = db.insert(tableName, null, contentValues);
		} catch (SQLiteException e) {
			db.close();
		}
		db.close();
		return affectedRow;
	}

	public long deleteRows(String tableName, ContentValues contentValues,
			String whereClause, String[] whereArgs) {
		SQLiteDatabase db = this.getWritableDatabase();
		long affectedRow = -1;
		try {
			affectedRow = db.delete(tableName, whereClause, whereArgs);
		} catch (SQLiteException e) {
			db.close();
		}
		db.close();
		return affectedRow;
	}

	public Cursor selectRows(String tableName, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = null;
		try {
			cursor = db.query(tableName, columns, selection,
					selectionArgs, groupBy, having, orderBy);
		} catch (SQLiteException e) {
			db.close();
		}
		return cursor;
	}
	
	public Cursor fireRawQuery(String query, String[] selectionArgs){
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = null;
		try {
			cursor = db.rawQuery(query, selectionArgs);
		} catch (SQLiteException e) {
			db.close();
		}
//		db.close();
		return cursor;
	}

	public long updateRow(String tableName, ContentValues contentValues,
			String whereClause, String[] whereArgs) {
		SQLiteDatabase db = this.getWritableDatabase();
		long affectedRow = -1;
		try {
			affectedRow = db.update(tableName, contentValues, whereClause,
					whereArgs);
		} catch (SQLiteException e) {
			db.close();
		}
		db.close();
		return affectedRow;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
}
