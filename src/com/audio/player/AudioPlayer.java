package com.audio.player;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class AudioPlayer {

	 String fileName;
	    Context contex;
	    MediaPlayer mp;

	    //Constructor
	    public AudioPlayer(String name, Context context) {
	        fileName = name;
	        contex = context;
	       // playAudio();
	    }

	    //Play Audio
	    public void playAudio() {
	        mp = new MediaPlayer();
	        try {
	            AssetFileDescriptor descriptor = contex.getAssets()
	                    .openFd(fileName);
	            mp.setDataSource(descriptor.getFileDescriptor(),
	                    descriptor.getStartOffset(), descriptor.getLength());
	            descriptor.close();
	            mp.prepare();
	            mp.setLooping(true);
	            mp.start();
	            mp.setVolume(3, 3);

	        } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    //Stop Audio
	    public void stop() {
	    	if(mp != null){
	        mp.stop();
	    	}
	    }
	    
	    //Pause Audio
	    public void pause(){
	    	if(mp != null){
	    		mp.pause();
	    	}
	    }
	    
}
