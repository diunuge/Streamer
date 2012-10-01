package com.glasscube.streamer;

import java.util.ArrayList;

import com.glasscube.connector.DataHandler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

//Used for search Music activity
public class SearchMusic extends Activity{
	
	SearchAdapter searchAdapter;
	Button searchButton;
	EditText serchText;
	ListView listViewResults;
	DataHandler dataHandler;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_search);
		dataHandler = new DataHandler();
		initialize();
		
		searchButton.setOnClickListener(new View.OnClickListener() {
			 
	        @Override
	        public void onClick(View view) {
	            // creating new product in background thread
	        	updateSongList();
	        }
	    });
		
	} // end of onCreate
	
	
	
	private void updateSongList(){
		ArrayList<MusicData> theMusicDataArray = dataHandler.getMusicbyTitle(serchText.getText().toString().trim());
		searchAdapter.clearMusicList();
		searchAdapter.addMusicToList(theMusicDataArray);
		listViewResults.setAdapter(searchAdapter); //Configure the ListView to show new Set of Songs.
	}
	
	private void initialize(){
		listViewResults = (ListView)findViewById(R.id.listViewSearchResults);  //Get a reference to the ListView.
		searchButton = (Button)findViewById(R.id.bSearch);
		serchText = (EditText)findViewById(R.id.etSearch);
		searchAdapter = new SearchAdapter();
		listViewResults.setAdapter(searchAdapter); //Configure the ListView to use the adapter.
	
	}

}
