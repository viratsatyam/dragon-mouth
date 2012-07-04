package fuel.manager.app.preferences;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.Spinner;
import fuel.manager.R;

public class PrefActivity extends Activity {

	private static Context context;

	SpinnerHandler spinnerHandler = null;
	ButtonHandler buttonHandler = null;

	Spinner spinner = null;
	Button button = null;

	public static Context getAppContext() {
		return PrefActivity.context;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PrefActivity.context = getApplicationContext();
		initActivity();

	}

	private void initActivity() {		
		spinnerHandler = new SpinnerHandler();		
		buttonHandler = new ButtonHandler();
		spinnerHandler.setActivityContext(this);
		buttonHandler.setActivityContext(this);
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
