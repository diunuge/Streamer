package com.glasscube.streamer;

// this class for search list item
public class MusicData {
	
	private String pid;
	private String title;
	private String artist;
	private String thumbnail_link;
	private String musicfile_link;
	private String description;
	
	public MusicData(){
	}
	
	public MusicData(String title, String artist){
		this.artist = artist;
		this.title = title;
	}
	
	public MusicData(String pid, String title, String artist, String thumbnail_link, String musicfile_link, String description){
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
