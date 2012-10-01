package com.glasscube.connector;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.glasscube.streamer.MusicData;

//import android.app.ProgressDialog;
import android.util.Log;
//import android.widget.EditText;

public class DataHandler extends Config{
	
	private JSONParser jsonParser;
	/*private String pid;
	private EditText titleEditText;
	private EditText artistEditText;
	private EditText thumbnail_linkEditText;
	private EditText musicfile_linkEditText;
	private EditText descriptionEditText;*/
	
	//private ArrayList<MusicData> resultMusicList;
	private List<NameValuePair> params;
	//private String paramString;
	private String paramURL;
	
	// JSON Node names
    private final String TAG_SUCCESS;
    private final String TAG_ITEM;
    private final String TAG_PID;
    private final String TAG_TITLE;
    private final String TAG_ARTIST;
    private final String TAG_THUMBNAIL;
    private final String TAG_MUSICFILE;
    private final String TAG_DESCRIPTION;
    
	
	public DataHandler(){
		
		jsonParser = new JSONParser();
		TAG_SUCCESS = "success";
		TAG_ITEM = "item";
		TAG_PID = "pid";
		TAG_TITLE = "title";
		TAG_THUMBNAIL = "thumbnail_link";
		TAG_MUSICFILE = "musicfile_link";
		TAG_ARTIST = "artist";
		
		TAG_DESCRIPTION = "description";
		
		//resultMusicList = new ArrayList<MusicData>();
	}
	
	public ArrayList<MusicData> getMusicbyId(int id){
		//resultMusicList.clear();
		ArrayList<MusicData> resultMusicList = new ArrayList<MusicData>();
		
		return resultMusicList;
	}
	
	public ArrayList<MusicData> getMusicbyTitle(String title){
		ArrayList<MusicData> resultMusicList = new ArrayList<MusicData>();
		
		// Building Parameters
        params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("title", "'"+title+"'"));
            
        // getting JSON Object
        paramURL = root_link + get_music_detail_by_title;
        JSONObject json = jsonParser.makeHttpRequest(paramURL, "GET", params);
            
        // check log cat for response
        Log.d("Create Response", json.toString());
        try{
        	int success = json.getInt(TAG_SUCCESS);
        	 
            if (success == 1) {
            	// successfully received product details
                JSONArray productObj = json.getJSONArray(TAG_ITEM); // JSON Array

                // get first product object from JSON Array
                JSONObject item = productObj.getJSONObject(0);

                // item with this title found
                resultMusicList.add(jsonToMusicData(item));
            } else {
                // failed to create product
            }
		
		}catch(JSONException e){
			e.printStackTrace();
		}
		finally{
			
		}
		
		return resultMusicList;
	}
	
	public ArrayList<MusicData> getMusicbyArtist(String artist){
		ArrayList<MusicData> resultMusicList = new ArrayList<MusicData>();
		
		// Building Parameters
        params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("artist", "'"+artist+"'"));
            
        // getting JSON Object
        paramURL = root_link + get_music_detail_by_title;
        JSONObject json = jsonParser.makeHttpRequest(paramURL, "GET", params);
            
        // check log cat for response
        Log.d("Create Response", json.toString());
        try{
        	int success = json.getInt(TAG_SUCCESS);
        	 
            if (success == 1) {
            	// successfully received product details
                JSONArray productObj = json.getJSONArray(TAG_ITEM); // JSON Array

                // get first product object from JSON Array
                JSONObject item = productObj.getJSONObject(0);

                // item with this title found
                resultMusicList.add(jsonToMusicData(item));
            } else {
                // failed to create product
            }
		
		}catch(JSONException e){
			e.printStackTrace();
		}
		finally{
			
		}
		
		return resultMusicList;
	}
	
	public ArrayList<MusicData> getMusicbyAnyKeyword(String generalKeyword){
		ArrayList<MusicData> resultMusicList = new ArrayList<MusicData>();
		
		return resultMusicList;
	}
	
	private MusicData jsonToMusicData(JSONObject item) throws JSONException{
		return new MusicData(item.getString(TAG_PID), item.getString(TAG_TITLE), item.getString(TAG_ARTIST), item.getString(TAG_THUMBNAIL), item.getString(TAG_MUSICFILE), item.getString(TAG_DESCRIPTION));
	}
}
