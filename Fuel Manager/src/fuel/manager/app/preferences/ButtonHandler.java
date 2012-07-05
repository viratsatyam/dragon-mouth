package fuel.manager.app.preferences;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import fuel.manager.R;


public class ButtonHandler implements View.OnClickListener {

	private Context activityContext = null;
	@Override
	public void onClick(View view) {
		System.out.println("ID: " + view.getId());
		if (view.getId() == R.id.save_btn_id) {

			Builder alert = new AlertDialog.Builder(getActivityContext());
			alert.setTitle("Save Data");
			alert.setMessage("Saved !! ");
			alert.setNeutralButton("Close", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dlg, int sumthin) {
					//Go to report screen
				}
			});

			alert.show();
		}

	}

	public void initOnClick(Button button) {
		button.setOnClickListener(this);

	}

	Context getActivityContext() {
		return activityContext;
	}

	void setActivityContext(Context activityContext) {
		this.activityContext = activityContext;
	}

}
