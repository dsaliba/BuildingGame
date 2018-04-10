package UI;

import java.io.FileInputStream;

import javax.swing.JOptionPane;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Music {

	public void startBGMusic() { //Plays the background music
            //make a new AudioPlayer.
              AudioPlayer myBackgroundPlayer = AudioPlayer.player;

              ContinuousAudioDataStream myLoop = null;
  			//use a try block in case the file doesn't exist.
              try {
              AudioStream myBackgroundMusic = new AudioStream(new FileInputStream("Sounds\\belltest.mp3"));
              AudioData myData = myBackgroundMusic.getData();
              myLoop = new ContinuousAudioDataStream(myData);
              }
              catch(Exception error) {System.out.println("invalid file");}
             
              // play background music.
              myBackgroundPlayer.start(myLoop);
        }
}