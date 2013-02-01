package com.example.fragments;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.Menu;

public class DetailActvity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_actvity);
		
		
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            DetailFragment details = new DetailFragment();
            details.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
	}



}
