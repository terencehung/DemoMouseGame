package com.terence.DemoGame;


import com.terence.DemoGame.R;

import com.terence.DemoGame.musicTools.VolumsPlayer;
import com.terence.DemoGame.musicTools.musicPlayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class SetVolums extends Activity {

	public SetVolums() {
		// TODO Auto-generated constructor stub
	}

	private Switch musicSwitch, volumSwitch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setvolum);
		musicSwitch = (Switch) this.findViewById(R.id.musicSwitch);
		musicSwitch.setChecked(musicPlayer.getflag());   //设置开关的初始值
		musicSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				musicPlayer.setFlag(isChecked);
			}
		});
		volumSwitch = (Switch) this.findViewById(R.id.volumSwitch);
		volumSwitch.setChecked(VolumsPlayer.getflag());  //设置开关的初始值
		volumSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				VolumsPlayer.setFlag(isChecked);
			}
		});
	}

}
