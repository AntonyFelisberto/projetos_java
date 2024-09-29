/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication33;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.FileInputStream;
import java.net.URL;
import javax.swing.JFileChooser;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author VP
 */
public class JavaApplication33 {
    
    public static void main(String[] args) {
        
    /*EXISTEM 3 MANEIRAS DE PEGAR LOCALIZAÇÃO,PEDINDO PRO USUARIO,DEFININDO VOCÊ MESMO,PEGANDO O LOCAL E ARMAZENANDO EM VARIAVEIS
      private String AUDIO_URL = getClass().getResource("/aularedes/audio1.mp3").toString();
         //NOME DA VARIAVEL QUE TEM LOCALIZAÇÃO         //PACOTE//local do recurso.tipo//passando o parametro como string
                                                        //caso não esteja em outro pacote você só coloca "nome.tipo"
     
      1 FORMA
      Media media=new Media("file:///C:/Users/VP/Documents/aularedes/audio1.mp3");
      Media media=new Media("/aularedes/audio1.mp3");
      Media media=new Media("audio1.mp3");
                            //DEFININDO VOCÊ MESMO
    
      2 FORMA    
      Media media=new Media(AUDIO_URL);
                            //LOCAL ARMAZENADO
    
      3 FORMA
     FileChooser seletorDeArquivos=new FileChooser();
     File arquivoSelecionado=seletorDeArquivos.showOpenDialog(null);
     caminhoDoArquivoSelecionado=arquivoSelecionado.toURI().toString();
                            //LOCAL DEFINIDO PELO USUARIO
     Media media=new Media(caminhoDoArquivoSelecionado);
    */
            /*
            JFileChooser escolha=new JFileChooser();
            File selecione=escolha.getCurrentDirectory();
            String arquivado=selecione.toURI().toString();
            */
            final JFXPanel fxPanel = new JFXPanel();
            String uriString = new File("C:/Users/VP/Documents/NetBeansProjects/interface/build/classes/sons/dark.mp3").toURI().toString();
            Media pick = new Media(uriString); 
            MediaPlayer player = new MediaPlayer(pick); 
             player.play();
             //player.pause();
             // player.stop();

            }
        }
      

      
