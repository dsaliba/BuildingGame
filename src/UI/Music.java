package UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javazoom.jl.player.Player;
import sun.applet.Main;
import sun.audio.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Music {
	Player playMP3;
	boolean music = true;

	public void startBGMusic(String file) { // Plays the background music
		if (music == true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						FileInputStream fis = new FileInputStream("Sounds/" + file);
						playMP3 = new Player(fis);
						playMP3.play();

					} catch (Exception e) {
						System.out.println(e);
					}
				}

			}).start();
		}
	}
	
	
	public void turnoffmusic() {
		music = false;
	}
	
	public void turnonmusic() {
		music = true;
	}
}
