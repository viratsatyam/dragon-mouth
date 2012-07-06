package fuel.manager.app.preferences;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import fuel.manager.R;

public class ButtonHandler implements View.OnClickListener {

	private PrefActivity prefActivity = null;
	public ButtonHandler(PrefActivity prefActivity) {
		this.prefActivity = prefActivity;
	}
	@Override
	public void onClick(View view) {

		Spinner spin = null;
		String item = null;
		if (view.getId() == R.id.save_btn_id) {
			spin = (Spinner) prefActivity
					.findViewById(R.id.vehicle_type_spin_id);
			item = spin.getSelectedItem().toString();
			Builder alert = new AlertDialog.Builder(prefActivity);
			alert.setTitle("Selected item");
			alert.setMessage(item);
			alert.setNeutralButton("Close", null);
			alert.show();

//			ContentValues values = new ContentValues();
//		    values.put("v_type", R.id.vehicle_type_spin_idcontact.getName()); // Contact Name
//		    values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone Number
//		    
			
		   
		}

	}

	public void initOnClick(Button button) {
		button.setOnClickListener(this);

	}
	}
