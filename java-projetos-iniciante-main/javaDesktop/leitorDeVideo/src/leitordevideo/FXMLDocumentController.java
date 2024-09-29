package leitordevideo;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {
    private String caminhoDoArquivoSelecionado;
    private MediaPlayer controleDoVideo;//essa variavel tem que ser global pois é ela quem controla o video após ser selecionado
    
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

    @FXML
    private MediaView dvd;
    
    @FXML
    private Slider progressoDoVideo;
        
    @FXML
    private Button acelerar;

    @FXML
    private Button avançar;

    @FXML
    private Button desacelerar;

    @FXML
    private Button pausar;

    @FXML
    private Button sair;

    @FXML
    private Button selecionar;

    @FXML
    private Button stop;

    @FXML
    private Button tocar;

    @FXML
    private Button voltar;
    
    @FXML
    public void selecionarVideo(ActionEvent event){
       FileChooser seletorDeArquivos=new FileChooser();
       File arquivoSelecionado=seletorDeArquivos.showOpenDialog(null);
       caminhoDoArquivoSelecionado=arquivoSelecionado.toURI().toString();
                                                        //convertendo o local do arquivo selecionado em string
                                                        
       if(caminhoDoArquivoSelecionado.isEmpty()||caminhoDoArquivoSelecionado==null){
           //verifica se o caminho esta vazio ou nulo
           JOptionPane.showMessageDialog(null,"local não especificado" );
       }else{
           Media cd=new Media(caminhoDoArquivoSelecionado);
                 //selecionando o caminho do arquivo que vai ser aberto
           controleDoVideo=new MediaPlayer(cd);//instanciando o controle após ter declarado como variavel global na linha 22
                 //dizendo qual arquivo vai ter controle
           dvd.setMediaPlayer(controleDoVideo);
                 //setando o arquivo para aparecer
                 
           //essas duas propriedades pegam o tamanho que você colocou na sua mediaView
           DoubleProperty width=dvd.fitWidthProperty();
           DoubleProperty height=dvd.fitHeightProperty();
           //fazendo com que a mediaView receba as propriedades de tamanho corretas e aumente ou diminua
           width.bind(Bindings.selectDouble(dvd.sceneProperty(), "width"));
           height.bind(Bindings.selectDouble(dvd.sceneProperty(), "height"));
           
           //criando uma lambda para ao mesmo tempo que o video roda a barra de progresso aumente
           controleDoVideo.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                           //pega tempo atual//adiciona chamada//instanciando ela(){
               @Override
               //método pode ser sobrescrito
               public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                   //função dentro da lambida
                   progressoDoVideo.setValue(newValue.toSeconds());
                   //seleciona os valores em segundos do video e adiciona a barra de progresso
               }
           });
           
           progressoDoVideo.setOnMousePressed(new EventHandler<MouseEvent>() {
                           //quando o mouse for pressionado na barra de progressoo
               @Override
               public void handle(MouseEvent event) {
                   controleDoVideo.seek(Duration.seconds(progressoDoVideo.getValue()));
                                        //pega a duração do video que esta na barra de progresso e muda o a duração do video pra duração que esta na barra
               }
           }); 
           
           progressoDoVideo.setOnMouseDragged(new EventHandler<MouseEvent>() {
                           //quando o mouse for arrastado na barra de progresso
               @Override
               public void handle(MouseEvent event) {
                   controleDoVideo.seek(Duration.seconds(progressoDoVideo.getValue()));
                                        //pega a duração do video que esta na barra de progresso e muda o a duração do video pra duração que esta na barra
               }
           }); 
           
           controleDoVideo.play();
       }
       /* verifica se o caminho NÃO esta vazio
       if(caminhoDoArquivoSelecionado!=null){
           
       }*/                                             
    }
    public void tocarVideo(ActionEvent event){
        controleDoVideo.setRate(1);//o rate normal padrão do video é 1
        controleDoVideo.play();
    }
    public void pausarVideo(ActionEvent event){
        controleDoVideo.pause();
    }
    public void stopVideo(ActionEvent event){
        controleDoVideo.stop();
    }
    public void avancarVideo(ActionEvent event){
        controleDoVideo.seek(controleDoVideo.getCurrentTime().add(Duration.seconds(10)));
        //seek serve pra pular ou encaixar em uma parte do video(//current time pega o tempo atual//add adiciona tempo//Duration.seconds,minutes,millis,hours(tempo)
    }
    public void voltarVideo(ActionEvent event){
        controleDoVideo.seek(controleDoVideo.getCurrentTime().add(Duration.seconds(-10)));
    }
    public void desacelerarVideo(ActionEvent event){
        controleDoVideo.setRate(0.5);//pra deixar rapido ou lento se usa o rate <0 pra lento >0 pra rapido
    }
    public void acelerarVideo(ActionEvent event){
        controleDoVideo.setRate(2);
    }
    public void sairVideo(ActionEvent event){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
