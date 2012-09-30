package com.glasscube.streamer;

// this class for search list item
public class MusicData {
	
	private String title;
	private String artist;
	
	public MusicData(String title, String artist){
		this.artist = artist;
		this.title = title;
	}
	
	public String getTitle() { 
		return title; 
	}
	public void setTitle(String title) { 
		this.title = title; 
	}
	public String getArtist() { 
		return artist; 
	}
	public void setArtist(String artist) { 
		this.artist = artist; 
	}
}
