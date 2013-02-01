package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends android.app.Fragment{

	 public static DetailFragment newInstance(int index) {
	        DetailFragment f = new DetailFragment();
	        Bundle args = new Bundle();
	        args.putInt("index", index);
	        f.setArguments(args);

	        return f;
	    }
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	}
	
	@Override
public View onCreateView(LayoutInflater inflater, ViewGroup  container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.detailfragment, container, false);
		return view;
	}
	
	public void setText(String item) {
		TextView view = (TextView) getView().findViewById(R.id.captain);
		view.setText(item);
	}	
}
