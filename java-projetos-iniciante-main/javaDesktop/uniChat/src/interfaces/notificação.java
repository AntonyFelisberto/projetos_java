/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author VP
 */
public class notificação {
       public static void ma(int x) {
            String uriString = new File("cole.mp3").toURI().toString();
            Media pick = new Media(uriString); 
            MediaPlayer player = new MediaPlayer(pick); 
            x=1;
            if(x==1){
                 player.play();
            }else{
                 player.stop();
            }
            }
        

 }

