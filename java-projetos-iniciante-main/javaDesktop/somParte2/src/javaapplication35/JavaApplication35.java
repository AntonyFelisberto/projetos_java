package javaapplication35;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class JavaApplication35 {
    
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
    public static void main(String[] args) {
      final JFXPanel fxPanel = new JFXPanel();
            String uriString = new File("dark.mp3").toURI().toString();
            Media pick = new Media(uriString); 
            MediaPlayer player = new MediaPlayer(pick); 
             player.play();
    }
    
}
