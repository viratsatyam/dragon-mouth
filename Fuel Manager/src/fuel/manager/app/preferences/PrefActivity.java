package fuel.manager.app.preferences;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import fuel.manager.R;

public class PrefActivity extends Activity {
	SpinnerHandler spinnerHandler = null;
	Spinner spinner = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinnerHandler = new SpinnerHandler();
		spinner = (Spinner) findViewById(R.id.vehicle_type_spin_id);		
		spinnerHandler.populateSpinner(spinner, this);
		spinner = (Spinner) findViewById(R.id.fuel_type_spin_id);		
		spinnerHandler.populateSpinner(spinner, this);
		spinner = (Spinner) findViewById(R.id.make_spin_id);		
		spinnerHandler.populateSpinner(spinner, this);
		spinner = (Spinner) findViewById(R.id.model_spin_id);		
		spinnerHandler.populateSpinner(spinner, this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
