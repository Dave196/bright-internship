package com.google;

/** A class used to represent a Playlist */
class VideoPlaylist {
	String playListName;
	VideoPlaylist(String playListName){
		this.playListName = playListName;
	}
	
	public String toString() {
		return playListName;
	}

}
