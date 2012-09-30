package com.glasscube.streamer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

//Used for search Music activity
public class SearchMusic extends Activity{
	
	SearchAdapter searchAdapter;
	Button searchButton;
	ListView listViewResults;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_search);
		
		initialize();
		
	} // end of onCreate
	
	private void updateSongList(){
		
		
	}
	
	private void initialize(){
		listViewResults = (ListView)findViewById(R.id.listViewSearchResults);  //Get a reference to the ListView.
		searchAdapter = new SearchAdapter();
		listViewResults.setAdapter(searchAdapter); //Configure the ListView to use the adapter.
	
	}

}
