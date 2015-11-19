package com.audio.player;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnPlay, btnPause, btnStop;
	AudioPlayer audioPlayer;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnPlay = (Button) findViewById(R.id.buttonPlay);
		btnPause = (Button) findViewById(R.id.buttonPause);
		btnStop = (Button) findViewById(R.id.buttonStop);

		context = getApplicationContext();
		audioPlayer = new AudioPlayer("audio_sample.mp3", context);

		btnPlay.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				audioPlayer.playAudio();
				btnPlay.setEnabled(false);
			}
		});

		btnPause.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				btnPlay.setEnabled(true);
				if (audioPlayer != null) {
					audioPlayer.pause();
				}
			}
		});

		btnStop.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				btnPlay.setEnabled(true);
				if (audioPlayer != null) {
					audioPlayer.stop();
				}
			}
		});
	}

	/*@Override
	public void onBackPressed() {
		if (audioPlayer != null) {
			audioPlayer.stop();
		}
		super.onBackPressed();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (audioPlayer != null) {
			audioPlayer.stop();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (audioPlayer != null) {
			audioPlayer.pause();
		}
	}
*/
}
