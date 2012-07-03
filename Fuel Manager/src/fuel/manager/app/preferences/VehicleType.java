package fuel.manager.app.preferences;

import fuel.manager.R;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class VehicleType implements
		AdapterView.OnItemSelectedListener {

	String[] vehicle_type_list = { "Car - 4 Wheeler", "Motor Bike - 2 Wheeler" };

	public void initVehicleTypeSpinner(Spinner spin, PrefActivity prefActivity) {		
		spin.setOnItemSelectedListener(this);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(prefActivity,
				android.R.layout.simple_list_item_1, vehicle_type_list);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(aa);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
}
