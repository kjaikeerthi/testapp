package com.example.fragments;


	
	import android.R.integer;
	import android.app.FragmentTransaction;
	import android.app.ListFragment;
	import android.content.Intent;
	import android.os.Bundle;
	import android.view.View;
	import android.widget.ArrayAdapter;
	import android.widget.ListView;

	public class List extends ListFragment{
		boolean isLandscape;
		int mCurCheckPosition = 0;
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			String[] values = new String[] { "Enterprise", "Star Trek", "Next Generation", "Deep Space 9", "Voyager"};
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
			setListAdapter(adapter);
			
			View detailsFrame = getActivity().findViewById(R.id.fragment1);
			
			isLandscape = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
			
			if (savedInstanceState != null) {
	            // Restore last state for checked position.
	            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
	        }
			
			if(isLandscape){
				getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				
			}
		}

		@Override
		public void onSaveInstanceState(Bundle outState){
			super.onSaveInstanceState(outState);
	        outState.putInt("curChoice", mCurCheckPosition);
		}
		
		@Override
		public void onListItemClick(ListView l, View v, int position, long id) {
			//DetailFragment frag = (DetailFragment) getFragmentManager().findFragmentById(R.id.fragment2);
			//String item = (String) getListAdapter().getItem(position);
			//if (frag != null && frag.isInLayout()) {
			//	frag.setText(getCapt(item));
			//}
			showDetails(position);
		}
		
		public void showDetails(int index){
			mCurCheckPosition = index;
			
			

	        
	            // Otherwise we need to launch a new activity to display
	            // the dialog fragment with selected text.
	            Intent intent = new Intent();
	            intent.setClass(getActivity(),DetailActvity.class);
	            intent.putExtra("index", index);
	            startActivity(intent);
	        
			
		}
		
		
		private String getCapt(String ship) {
			if (ship.toLowerCase().contains("enterprise")) {
				return "Johnathan Archer";
			}
			if (ship.toLowerCase().contains("star trek")) {
				return "James T. Kirk";
			}
			if (ship.toLowerCase().contains("next generation")) {
				return "Jean-Luc Picard";
			}
			if (ship.toLowerCase().contains("deep space 9")) {
				return "Benjamin Sisko";
			}
			if (ship.toLowerCase().contains("voyager")) {
				return "Kathryn Janeway";
			}
			return "???";
		}
		


}
