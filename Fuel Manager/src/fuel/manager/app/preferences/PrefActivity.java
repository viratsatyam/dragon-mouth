package fuel.manager.app.preferences;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.Spinner;
import fuel.manager.R;
import fuel.manager.app.sqlite.DBHelper;

public class PrefActivity extends Activity {

	private static Context context;

	SpinnerHandler spinnerHandler = null;
	ButtonHandler buttonHandler = null;

	Spinner spinner = null;
	Button button = null;

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

	}

	private void initDB() {
		System.out.println("Creating database");
		ArrayList<String> queryList = new ArrayList<String>();
		queryList.add("CREATE TABLE Vehicle ( "
				+ "rec_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "v_type INTEGER NOT NULL, " 
				+ "v_model INTEGER NOT NULL, "				 
				+ "v_make INTEGER NOT NULL, "
				+ "f_type INTEGER NOT NULL, "
				+ "f_rate FLOAT NOT NULL);");
		DBHelper dbHelper = new DBHelper(this, "fuelDB", null, 1, queryList);
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
