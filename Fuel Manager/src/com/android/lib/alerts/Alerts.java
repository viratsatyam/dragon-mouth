package com.android.lib.alerts;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

public class Alerts {
	public static final int TYPE_CLOSE = 0;
	public static final int TYPE_OK = 1;
	public static final int TYPE_YESNO = 2;

	private static Builder alert = null;

	public static void showMessageWithClose(Activity activity, String title,
			String message, int type) {
		alert = new AlertDialog.Builder(activity);
		alert.setTitle(title);
		alert.setMessage(message);
		alert.setNeutralButton("Close", null);
		alert.show();
	}

	public static void showMessageWithOK(Activity activity, String title,
			String message, int type) {
		alert = new AlertDialog.Builder(activity);
		alert.setTitle(title);
		alert.setMessage(message);
		alert.setNeutralButton("OK", null);
		alert.show();
	}

	public static void showMessageWithExitYesNo(Activity activity,
			String title, String message, int type) {
		alert = new AlertDialog.Builder(activity);
		alert.setTitle(title);
		alert.setMessage(message);
		alert.setPositiveButton("Yes !", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				System.exit(0);
			}

		});
		alert.setNegativeButton("Wait..", null);
		alert.show();
	}

}
