package com.glasscube.streamer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class StartingPoint extends Activity{

	MediaPlayer ring;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_point);
		ring = MediaPlayer.create(StartingPoint.this, R.raw.budhdha_ring);
		ring.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(9000);
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}finally{
					Intent openStartingPoint = new Intent("com.glasscube.streamer.MAINACTIVITY");
					startActivity(openStartingPoint);
				}
			}
		};
		
		timer.setName("newThread");
		timer.start();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ring.release();
		finish();
	}
	
}
