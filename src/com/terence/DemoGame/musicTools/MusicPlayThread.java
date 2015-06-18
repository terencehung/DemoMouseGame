package com.terence.DemoGame.musicTools;

public class MusicPlayThread extends Thread{

	public MusicPlayThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		musicPlayer.play();
	}

}
