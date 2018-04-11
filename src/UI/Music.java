package UI;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import sun.applet.Main;
import sun.audio.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Music {
	InputStream is;
	AudioStream as;
	AudioData ad;
	ContinuousAudioDataStream cas;

	public void startBGMusic() { // Plays the background music
		new Thread(new Runnable() {
			// The wrapper thread is unnecessary, unless it blocks on the
			// Clip finishing; see comments.
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(Main.class.getResourceAsStream("\\Sounds\\belltest.mp3"));
					clip.open(inputStream);
					clip.start();
					System.out.println("works");
				} catch (Exception e) {
					System.err.println("Music Doesn't Work");
				//	System.out.println("Die");
					
				}
			}
		}).start();
	}
}
