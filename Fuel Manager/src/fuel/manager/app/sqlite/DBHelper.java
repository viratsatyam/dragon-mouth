package fuel.manager.app.sqlite;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
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
		for (String query : queryList) {
			db.execSQL(query);
		}

	}

	public void insertData(String tableName, ContentValues values) {
		SQLiteDatabase db = this.getWritableDatabase();
		// Inserting Row
		db.insert(tableName, null, values);
		db.close(); // Closing database connection
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
}
