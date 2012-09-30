package com.glasscube.streamer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

//Used for search Music activity
public class SearchMusic extends Activity{
	
	SearchAdapter searchAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_search);
		
		ListView listView = (ListView)findViewById(R.id.listViewSearchResults);  //Get a reference to the ListView.
		searchAdapter = new SearchAdapter();
		listView.setAdapter(searchAdapter); //Configure the ListView to use the adapter.
		
	} // end of onCreate

}
