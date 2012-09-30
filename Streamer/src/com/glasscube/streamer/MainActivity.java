package com.glasscube.streamer;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

//This is not using currently
public class MainActivity extends Activity{
	
	Button search;
	String searchKeyword;
	//EditText searchKeyText;
    private ListView listViewSearchResult;
    ArrayAdapter<String> listViewAdapter;
    EditText inputSearch;
    ArrayList<HashMap<String, String>> productList;
    
    //String musics[] ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_search);
        initialize();
        
        //String[] listItems = new String[]{"asds","asfdsa","dfg"};
        //ListAdapter listAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listItems);
        //setListAdapter(listAdapter);
        String musics[] = {"Mage mariyo", "Ranabime", "Sudu Pata Rali Gawuma", "Katu Koliye Bandare", "De Ghumake",
                "Excuse me Mr.HB", "Take Me Home", "lowama nidana", "Smack That"};
        

		listViewAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.search_list_item, R.id.tvMusicName, musics);
		listViewSearchResult.setAdapter(listViewAdapter);
		
		inputSearch.addTextChangedListener(new TextWatcher() {
			 
		    @Override
		    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
		        // When user changed the Text
		    	String musics1[] = {"Surili Akhiyon Wale", "Diurala Pawasanna"};
		    	listViewAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.search_list_item, R.id.tvMusicName, musics1);
				listViewSearchResult.setAdapter(listViewAdapter);
		        //MainActivity.this.listViewAdapter.getFilter().filter(cs);
		    }
		 
		    @Override
		    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
		            int arg3) {
		        // TODO Auto-generated method stub
		 
		    }

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu); 
        return true;
    }*/
    
    private void initialize() {
    	search = (Button) findViewById(R.id.bSearch);
		inputSearch = (EditText) findViewById(R.id.etSearch);
		searchKeyword = inputSearch.getText().toString();
		listViewSearchResult = (ListView)findViewById(R.id.listViewSearchResults);
		
	}
    
    
}
