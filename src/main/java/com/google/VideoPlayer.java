package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
	  System.out.println("Here's a list of all available videos:");
	  //videoLibrary.getVideos().sort(Title); sorting still to do
	  for(int i=0; i<videoLibrary.getVideos().size(); i++) {
		  System.out.println(videoLibrary.getVideos().get(i).getTitle()+ " "+ "("+videoLibrary.getVideos().get(i).getVideoId()+") "+videoLibrary.getVideos().get(i).getTags());  
	  }
  }
  
  public String playing = "";
  public String playingID = "";
  public Boolean pause = false;
  
  public void playVideo(String videoId) {
	  try {
		  if(videoLibrary.getVideo(videoId) == null) {
			  System.out.println("Cannot play video: Video does not exist ");
		  }
		  else if(playing != "") {
			  System.out.println("Stopping video: " + playing);
			  System.out.println("Playing video: " + videoLibrary.getVideo(videoId).getTitle());
		  }else {
			  System.out.println("Playing video: " + videoLibrary.getVideo(videoId).getTitle());
		  }
		  playing = videoLibrary.getVideo(videoId).getTitle();
		  playingID = videoLibrary.getVideo(videoId).getVideoId();
		  pause = false;
  	  }
	  catch(NullPointerException e)
      {
		  
      }   
  }

  public void stopVideo() {
	  if(playing != "") {
		  System.out.println("Stopping video: " + playing);
		  playing= "";
		  playingID = "";
		  pause = false;
	  }
	  else {
		  System.out.println("Cannot stop video: No video is currently playing"); 
	  }
  }

  public void playRandomVideo() {
	Random rand = new Random();
	int int_random = rand.nextInt(videoLibrary.getVideos().size());
	String random_Vid = videoLibrary.getVideos().get(int_random).getTitle();
	String random_VidID = videoLibrary.getVideos().get(int_random).getVideoId();
	if(playing != "") {
		System.out.println("Stopping video: " +playing);
		System.out.println("Playing video: " + random_Vid) ;
		playing = random_Vid;
		playingID = random_VidID;
	}
	else {
		System.out.println("Playing video: " +videoLibrary.getVideos().get(int_random).getTitle());
		playing = random_Vid;
		playingID = random_VidID;
	}
  }
  
  public void pauseVideo() {
	if(playing == "") {
		System.out.println("Cannot pause video: No video is currently playing" );
	}
	else if(pause == true) {
		System.out.println("Video already paused: " +playing);
	}
	else {
		System.out.println("Pausing video: " +playing); 
		pause = true;
	}

  }

  public void continueVideo() {
	  if(playing == "") {
			System.out.println("Cannot continue video: No video is currently playing" );
		}
		else if(pause == false) {
			System.out.println("Cannot continue video: Video is not paused ");
		}
		else {
			System.out.println("Continuing video: " +playing); 
			pause = false;
		}
  }

  public void showPlaying() {
	  if(playing == "") {
			System.out.println("No video is currently playing"); 
		}  
	  	else if(pause == true) {
	  		System.out.println("Currently playing: "+playing + " ("+playingID+") " + videoLibrary.getVideo(playingID).getTags() + " - PAUSED" );
	  	}
	  	else {
	  		System.out.println("Currently playing: "+playing + " ("+playingID+") " + videoLibrary.getVideo(playingID).getTags());
	  		
	  	}
	
   
  }
  ArrayList<VideoPlaylist> AllPlaylists = new ArrayList<VideoPlaylist>();

  public void createPlaylist(String playlistName) {
		if(AllPlaylists.toString().toLowerCase().contains(playlistName.toLowerCase())) {
			System.out.println("Cannot create playlist: A playlist with the same name already exists:");
		}else {
			AllPlaylists.add(new VideoPlaylist(playlistName));
			 System.out.println("Successfully created new playlist:");
		}
		
	}
	

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}