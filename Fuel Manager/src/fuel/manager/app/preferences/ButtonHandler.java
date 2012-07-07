package fuel.manager.app.preferences;

import android.content.ContentValues;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.lib.alerts.Alerts;

import fuel.manager.R;

public class ButtonHandler implements View.OnClickListener {

	private PrefActivity prefActivity = null;

	public ButtonHandler(PrefActivity prefActivity) {
		this.prefActivity = prefActivity;
	}

	@Override
	public void onClick(View view) {
		ContentValues contentValues = new ContentValues();
		int viewId = view.getId();
		switch (viewId) {
		case R.id.save_btn_id:
			contentValues.put("v_type", ((Spinner) prefActivity
					.findViewById(R.id.vehicle_type_spin_id)).getSelectedItemPosition());
			contentValues.put("v_model", ((Spinner) prefActivity
					.findViewById(R.id.model_spin_id)).getSelectedItemPosition());
			contentValues.put("v_make", ((Spinner) prefActivity
					.findViewById(R.id.make_spin_id)).getSelectedItemPosition());
			contentValues.put("f_type", ((Spinner) prefActivity
					.findViewById(R.id.fuel_type_spin_id)).getSelectedItemPosition());
			if (((EditText) prefActivity.findViewById(R.id.fuel_rate_id))
					.getText().toString() != null) {
				contentValues.put("f_rate", Float.valueOf(((EditText) prefActivity
						.findViewById(R.id.fuel_rate_id)).getText().toString()));

			} else {
				Alerts.showMessageWithOK(prefActivity, "Message",
						"Input data missing", Alerts.TYPE_OK);
			}
			
			//insert data
			long affectedRow = prefActivity.dbHelper.insertRow("Vehicle",
					contentValues);
			//update data in first row			
			String[] whereArgs = { "1" };
			affectedRow = prefActivity.dbHelper.updateRow("Vehicle",
					contentValues, "rec_id=?", whereArgs);
			//delete data in rows > 1
			affectedRow = prefActivity.dbHelper.deleteRows("Vehicle",
					contentValues, "rec_id>?", whereArgs);		

			if (affectedRow < 0) {
				Alerts.showMessageWithClose(prefActivity, "Error",
						"Insert failed", Alerts.TYPE_CLOSE);
			} else {
				Alerts.showMessageWithOK(prefActivity, "Message", "Saved",
						Alerts.TYPE_OK);
			}
			break;
		case R.id.cancel_btn_id:
			Alerts.showMessageWithExitYesNo(prefActivity, "Quit Box",
					"Are you sure ?", Alerts.TYPE_YESNO);
			break;
		default:
			Alerts.showMessageWithClose(prefActivity, "Error",
					"Application Error", Alerts.TYPE_CLOSE);
		}
	}

	public void initOnClick(Button button) {
		button.setOnClickListener(this);

	}
}
