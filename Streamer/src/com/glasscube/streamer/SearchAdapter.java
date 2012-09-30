package com.glasscube.streamer;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SearchAdapter extends BaseAdapter {
	
	private ArrayList<MusicData> musicList = new ArrayList<MusicData>();

	public SearchAdapter() {
		musicList.add(new MusicData("Mage mariyo", "Artist 1"));
		musicList.add(new MusicData("Ranabime", "Artist 2"));
		musicList.add(new MusicData("Take Me Home", "Artist 3"));
		musicList.add(new MusicData("lowama nidana", "Artist 1"));
	}
	
	public void addMusicToList(String title, String artist){
		musicList.add(new MusicData(title, artist));
	}
	
	public void clearMusicList(){
		musicList.clear();
	}

	@Override
	public int getCount() {
		return musicList.size();
	}

	@Override
	public Object getItem(int index) {
		return getItem(index); //The data for a row at the index is the musicData in the ArrayList at that same index
	}

	@Override
	public long getItemId(int index) {
		return index;  //return a unique ID for the data. Since the index ID is unique for a row, standard practice is just to return the index.
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		if(convertView==null){  // Check if the View is null. If it is, retrieve the layout inflater and inflate the view.
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.search_list_item, parent, false);
		}
		
		MusicData musicData = musicList.get(index);
		
		TextView titleTextView = (TextView) convertView.findViewById(R.id.tvMusicName);
		titleTextView.setText(musicData.getTitle());
		
		TextView artistTextView = (TextView) convertView.findViewById(R.id.tvArtist);
		artistTextView.setText(musicData.getArtist());
		
		return convertView;
	}

}
