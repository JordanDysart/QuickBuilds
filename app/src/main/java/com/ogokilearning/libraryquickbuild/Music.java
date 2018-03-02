package com.ogokilearning.libraryquickbuild;

import android.media.MediaPlayer;


/**
 * Created by jordandysart on 2018-01-19.
 *
 */

public class Music {

    public static boolean OFF = false;


    public static void playFile(int file) {
        if (!OFF) {
            OFF = true;
            MediaPlayer mp = MediaPlayer.create(Shared.context, file);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    OFF = false;
                }
            });
            mp.start();
        }
    }


}
