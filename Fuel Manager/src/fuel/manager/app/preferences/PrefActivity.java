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

	String[] vehicle_type_list = { "Car - 4 Wheeler", "Motor Bike - 2 Wheeler" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner vehicle_type_spin = (Spinner) findViewById(R.id.vehicle_type_spin_id);
		VehicleType vehicleType = new VehicleType();
		vehicleType.initVehicleTypeSpinner(vehicle_type_spin, this);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
