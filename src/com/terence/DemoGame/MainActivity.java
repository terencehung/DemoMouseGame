package com.terence.DemoGame;

import com.terence.DemoGame.R;
import com.terence.DemoGame.gametools.MainMapManager;
import com.terence.DemoGame.musicTools.MusicPlayThread;
import com.terence.DemoGame.musicTools.VolumsPlayer;
import com.terence.DemoGame.musicTools.musicPlayer;

import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button startButton, setmusicButton, overButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // 设置为全屏
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置无标题栏
		setContentView(R.layout.activity_main);
		startButton = (Button) this.findViewById(R.id.startButton);
//		startButton.setVisibility();
		startButton.setOnClickListener(this);
		setmusicButton = (Button) this.findViewById(R.id.setmusicButton);
		setmusicButton.setVisibility(View.INVISIBLE);
//		setmusicButton.setOnClickListener(this);
		overButton = (Button) this.findViewById(R.id.overButton);
		setmusicButton.setVisibility(View.INVISIBLE);
		overButton.setOnClickListener(this);
		musicPlayer.init(MainActivity.this);
		new Thread(new MusicPlayThread()).start();
		VolumsPlayer.init(MainActivity.this);
		Intent intent0=new Intent(MainActivity.this,GameActivity.class);
        startActivity(intent0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		musicPlayer.ReleaseIt();
		VolumsPlayer.ReleaseIt();
		this.finish();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.startButton:
            Intent intent0=new Intent(MainActivity.this,GameActivity.class);
            startActivity(intent0);
			break;
		case R.id.setmusicButton:
			Intent intent = new Intent(MainActivity.this, SetVolums.class);
			startActivity(intent);
			break;
		case R.id.overButton:
			musicPlayer.ReleaseIt();   
			VolumsPlayer.ReleaseIt();
			this.finish();
			break;
		}
	}

}
