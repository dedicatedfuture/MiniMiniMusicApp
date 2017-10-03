package com.BillZerega;

import javax.sound.midi.*;

/**
 * Created by Bill on 10/2/17.
 */
public class MiniMiniMusicApp {

    public void play(){

        //try-catch block deals with risky behavior, if program doesn't find a track it will print the error
        try{
            //Get a sequencer(music player) and open it
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            //create a track or song for the sequencer to play
            Track track = seq.createTrack();


            ShortMessage a = new ShortMessage();
            //(message type 144=on 128=off, channel what type of instrument, note to play 0-127, velocity soft to hard
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();
            System.out.println("Player succeeded!");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
