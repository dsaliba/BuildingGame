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
	InputStream is;
	AudioStream as;
	AudioData ad;
	ContinuousAudioDataStream cas;

	public void startBGMusic() { // Plays the background music
		new Thread(new Runnable() {
				@Override
				public void run() {
					try{
					FileInputStream fis = new FileInputStream("Sounds/belltest.mp3");
				    Player playMP3 = new Player(fis);

				    playMP3.play();

				    }catch(Exception e){System.out.println(e);}
				}
				
				
			
		}).start();
	}
}
