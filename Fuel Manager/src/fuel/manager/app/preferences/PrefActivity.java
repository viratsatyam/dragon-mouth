package fuel.manager.app.preferences;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.lib.sqlite.DBHelper;

import fuel.manager.R;

public class PrefActivity extends Activity {

	private static Context context;
	public DBHelper dbHelper = null;
	private SpinnerHandler spinnerHandler = null;
	private ButtonHandler buttonHandler = null;

	Spinner spinner = null;
	Button button = null;
	EditText editText = null;
	public static Context getActivityContext() {
		return PrefActivity.context;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PrefActivity.context = getApplicationContext();
		initActivity();
		initDB();
		loadActivity();
	}

	private void loadActivity() {
		String[] selectionArgs = { "1" };		
		Cursor cursor = dbHelper.selectRows("Vehicle", null, "rec_id=?",
				selectionArgs, null, null, null);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			spinner = (Spinner) findViewById(R.id.vehicle_type_spin_id);
			spinner.setSelection(cursor.getInt(1));
			spinner = (Spinner) findViewById(R.id.model_spin_id);
			spinner.setSelection(cursor.getInt(2));
			spinner = (Spinner) findViewById(R.id.make_spin_id);
			spinner.setSelection(cursor.getInt(3));
			spinner = (Spinner) findViewById(R.id.fuel_type_spin_id);
			spinner.setSelection(cursor.getInt(4));
			editText = (EditText) findViewById(R.id.fuel_rate_id);
			editText.setText(String.valueOf(cursor.getFloat(5)));
		}
	}

	private void initDB() {
		ArrayList<String> queryList = new ArrayList<String>();
		queryList.add("CREATE TABLE Vehicle ( "
				+ "rec_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "v_type INTEGER NOT NULL, " + "v_model INTEGER NOT NULL, "
				+ "v_make INTEGER NOT NULL, " + "f_type INTEGER NOT NULL, "
				+ "f_rate FLOAT NOT NULL);");
		dbHelper = new DBHelper(getApplicationContext(), "fuelDB.sqlite", null,
				1, queryList);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		db.close();
	}

	private void initActivity() {
		spinnerHandler = new SpinnerHandler(this);
		buttonHandler = new ButtonHandler(this);
		spinner = (Spinner) findViewById(R.id.vehicle_type_spin_id);
		spinnerHandler.populateSpinner(spinner);
		spinner = (Spinner) findViewById(R.id.fuel_type_spin_id);
		spinnerHandler.populateSpinner(spinner);
		spinner = (Spinner) findViewById(R.id.make_spin_id);
		spinnerHandler.populateSpinner(spinner);
		spinner = (Spinner) findViewById(R.id.model_spin_id);
		spinnerHandler.populateSpinner(spinner);
		// initOnClickListner
		button = (Button) findViewById(R.id.save_btn_id);
		buttonHandler.initOnClick(button);
		button = (Button) findViewById(R.id.cancel_btn_id);
		buttonHandler.initOnClick(button);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
