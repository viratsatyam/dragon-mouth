package fuel.manager.app.preferences;



import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import fuel.manager.R;

public class SpinnerHandler implements AdapterView.OnItemSelectedListener {
	private PrefActivity  prefActivity = null;
	ArrayAdapter<String> aa = null;
	String[] vehicle_type_list = { "Car - 4 Wheeler", "Motor Bike - 2 Wheeler" };
	String[] model_list = { "Tata Indica eV2", "Maruti WagonR",
			"Hyundai Santro Xing", "Tata Indica eV2 Xeta", "Reva i",
			"Tata Indica V2 Xeta LPG", "Maruti A Star", "Maruti Estilo",
			"Chevrolet Beat", "Maruti Eeco", "Ford Figo" };
	String[] make_list = null;
	String[] fuel_type_list = { "Patrol", "Diesel", "CNG" };
	
	public SpinnerHandler(PrefActivity prefActivity){
		this.prefActivity = prefActivity;
	}
	public void populateSpinner(Spinner spin) {
		spin.setOnItemSelectedListener(this);
		int spinId = spin.getId();
		switch (spinId) {
		case R.id.vehicle_type_spin_id:
			aa = new ArrayAdapter<String>(prefActivity,
					android.R.layout.simple_list_item_1, vehicle_type_list);
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			break;
		case R.id.fuel_type_spin_id:
			aa = new ArrayAdapter<String>(prefActivity,
					android.R.layout.simple_list_item_1, fuel_type_list);
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			break;
		case R.id.make_spin_id:
			make_list = new String[(2012 - 1960) + 1];
			for (int i = 1960, j = 0; i < 2013; i++, j++) {
				make_list[j] = new String(String.valueOf(i));
			}
			aa = new ArrayAdapter<String>(prefActivity,
					android.R.layout.simple_list_item_1, make_list);
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			break;
		case R.id.model_spin_id:
			aa = new ArrayAdapter<String>(prefActivity,
					android.R.layout.simple_list_item_1, model_list);
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			break;
		default:
		}
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
