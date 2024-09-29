package aularedes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
import Resp.Perguntas;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class FXMLDocumentController implements Initializable {
    public static int f=0;
    public static boolean troca=true;
    public static int pontos;
    public int resp;
    public boolean jaRespondeu=true;
    private String AUDIO_URL = getClass().getResource("/audios/audios.mp3").toString();
                               //classe//local do recurso//passando o parametro como string
    private String Audio_Url=getClass().getResource("/audios/20 ANOS.mp3").toString();
    
    @FXML
    private TextArea text;
    
    @FXML
    private Label pontuacao;

    @FXML
    private Spinner<Integer> rodaDeResposta;
    SpinnerValueFactory<Integer>roda=new  SpinnerValueFactory.IntegerSpinnerValueFactory(1,4);
    
    @FXML
    private TextArea texto;
    
    @FXML
    public void handleButtonAction(ActionEvent event) {
      boolean verificado;
      Media media=new Media(AUDIO_URL);
      MediaPlayer controle=new MediaPlayer(media);
      Media mediaB=new Media(Audio_Url);
      MediaPlayer controleB=new MediaPlayer(mediaB);  
       
       if(jaRespondeu){
           JOptionPane.showMessageDialog(null,"ja respondeu ou não trocou de pergunta");
       }else{
           Perguntas perguntas=new Perguntas();
           resp=roda.getValue();
           verificado=perguntas.verifiqueResposta(resp,f);
           
           if(verificado){
                pontos=pontos+1;
                pontuacao.setText("Pontuação:"+pontos);
                JOptionPane.showMessageDialog(null,"resposta correta");
                controle.play();
                f=f+1;
           }else{
                f=f+1;
                JOptionPane.showMessageDialog(null,"resposta incorreta");
                controleB.play(); 
           }
         jaRespondeu=true;
       }
       troca=true;
    }
    public void Próxima(){
       texto.setEditable(false);
       text.setEditable(false);
       roda.setValue(1);
       rodaDeResposta.setValueFactory(roda);
      if(troca){
        if(f==0){
            texto.setText("O QUE É O GATEAWAY");
            text.setText("1-é um nó de rede utilizado para unir redes que utilizam protocolos de comunicação diferentes\n2-é um protocolo\n3-é uma rede\n4-é um sistema de controle de versionamento para produzir um rendimento na sua rede e aumentar sua produção" );
            troca=false;
            jaRespondeu=false;
        }else if (f==1){
            texto.setText("O QUE ELE PODE CONTER");
            text.setText("1-sistemas avançados de calculos produzidos em C\n2-pode conter dispositivos para traduzir protocolos, sinais de dados, converter taxas de impedância e outros fatores que bloqueariam a troca de informações entre dois computadores\n3-um sistema que implementa leis que são usadas fora do pais\n4-uma sensação diferenciada no ar que te faz ficar louco");
            troca=false;
            jaRespondeu=false;
        }else if (f==2){
            texto.setText("OS GATEWAYS TAMBEM SÃO CHAMADOS DE CONVERSORES DE:");
            text.setText("1-protocolo\n2-sistema\n3-rede\n4-switch");
            troca=false;
            jaRespondeu=false;
        }else if(f==3){
            texto.setText("O QUE É UM IP:");
            text.setText("1-uma rede neural\n2-sistema que conduz a rede a distancia\n3-dispositivo de conduta\n4-um protocolo de internet");
            troca=false;
            jaRespondeu=false;
        }else if(f==4){
            texto.setText("PRA QUE SERVE UM IP:");
            text.setText("1-são numeros que identificam seu computador em uma rede\n2-são dois numeros um identifica o ip da sua casa e outro na rede\n3-somente a 1 esta correta\n4-a primeira e segunda esta correta");
            troca=false;
            jaRespondeu=false;  
        }else if(f==5){
            texto.setText("PRA QUE SERVE UM IP:");
            text.setText("1-são numeros que identificam seu computador em uma rede\n2-são dois numeros um identifica o ip da sua casa e outro na rede\n3-somente a 1 esta correta\n4-a primeira e segunda esta correta");
            troca=false;
            jaRespondeu=false;  
        }else if(f==6){
            texto.setText("");
            text.setText("");
            troca=false;
            jaRespondeu=false; 
        }else if(f==7){
            texto.setText("");
            text.setText("");
            troca=false;
            jaRespondeu=false; 
        }else if(f==8){
            texto.setText("");
            text.setText("");
            troca=false;
            jaRespondeu=false; 
            
        }else if(f==9){
            texto.setText("");
            text.setText("");
            troca=false;
            jaRespondeu=false; 
        }else if(f==10){
            texto.setText("Conversão entre Bases - Decimal para Binário\n" +
                          "• Para converter um número entre bases podem ser aplicados alguns métodos\n" +
                          "• Para converter um número no sistema decimal para binário:Basta dividir o maior número por 2 até restar 0 ou 1\n" +
                          "• Após cada divisão observa-se se sobrou resto, caso tenha sobrado atribua o valor 1, caso contrário (divisão exata, par) atribua o valor 0\n" +
                          "• Depois leia esse número invertido e você terá o valor binário para aquele número decimal");
            text.setText("considere o texto acima e verifique qual o numero binario de 1026\n1-111010110\n2-10000000101\n3-10000100101\n4-10000000010");
            troca=false;
            jaRespondeu=false; 
        }else if(f==11){
            texto.setText("Endereços IP\n" +
                          "• O IPv4 possui endereços com o tamanho de 32 bits 255.255.255.0->cada uma valendo 8bits\n" +
                          "• Cada host e roteador na rede tem um endereço IP que pode ser\n" +
                          "usado nos campos Endereço de origem e Endereço de destino dos pacotes IP\n" +
                          "• Cada endereço de 32 bits é composto de uma parte de rede de\n" +
                          "tamanho variável nos bits superiores e uma parte de host nos bits inferiores\n" +
                          "• A parte de rede tem o mesmo valor para todos os hosts em uma única rede, como uma LAN Ethernet\n" +
                          "• Isso significa que uma rede corresponde a um bloco contíguo de\n" +
                          "espaço de endereços IP. Esse bloco é o Prefixo\nsabendo disso o que determina o numero do prefixo");
            text.setText("1-nada\n2-o endereço de ip da rede\n3-numero de bits na parte da rede\n4-numero de bits na parte do host");
            troca=false;
            jaRespondeu=false; 
        }else if(f==12){
            texto.setText("Endereços IP\n" +
                          "• Os endereços IP são escritos em notação decimal com ponto\n" +
                          "• Nesse formato, cada um dos 4 bytes é escrito em decimal, de 0 a\n" +
                          "255. Por exemplo, o endereço hexadecimal de 32 bits 80D00297 é\n" +
                          "escrito como 128.208.2.151\n" +
                          "• Os prefixos são escritos dando o menor endereço IP no bloco de endereços\n" +
                          "• O tamanho do prefixo é determinado pelo número de bits na parte de rede\n" +
                          "• Os bits restantes fazem parte do campo de ____ e podem variar");
            text.setText("1-wwan\n2-ip\n3-rede\n4-host");
            troca=false;
            jaRespondeu=false; 
        }else if(f==13){
            texto.setText("Endereços IP\n" +
                          "•O tamanho do endereço deve ser uma potência de dois\n" +
                          "• Por convenção, ele é escrito após o prefixo com uma barra seguida pelo tamanho em bits da parte da rede\n" +
                          "• Em nosso exemplo, se o prefixo tiver 28 endereços e, portanto,\n"+
                          "deixar 24 bits para a parte de rede, ele é escrito como 128.208.0.0/24.");
            text.setText("");
            troca=false;
            jaRespondeu=false; 
        }else if(f==14){
            texto.setText("Endereços IP\n" +
                          "• Como o tamanho do prefixo não pode ser deduzido apenas pelo\n" +
                          "endereço IP, os protocolos de roteamento de_x0002_vem\n" +
                          "transportar os prefixos aos roteadores\n" +
                          "• Às vezes, os prefixos são simplesmente descritos por seu tamanho,\n" +
                          "como em um ‘/16’ que é pronunciado como ‘barra 16’\n" +
                          "• O tamanho do prefixo corresponde a uma máscara binária de 1s na parte destinada à rede\n" +
                          "• Quando escrita dessa forma, ela é chamada máscara de sub-rede");
            text.setText("");
            troca=false;
            jaRespondeu=false;             
        }else if(f==15){
            texto.setText("");
            text.setText("");
            troca=false;
            jaRespondeu=false;             
        }else if(f==16){
            texto.setText("");
            text.setText("");
            troca=false;
            jaRespondeu=false;             
        }else if(f==17){
            texto.setText("");
            text.setText("");
            troca=false;
            jaRespondeu=false;             
        }
        
        
        
        else{
            texto.setText("");
            text.setText("");
            String F="parabens você chegou ao fim sua pontuação total foi "+pontos;
            JOptionPane.showMessageDialog(null,F);
        }
      }else{
          JOptionPane.showMessageDialog(null,"responda primeiro");
      }
    }
/*
    
2-

• Para que o seu funcionamento ocorra com alta qualidade, é
necessário que ambas as infraestruturas sigam alguns padrões em
comum, tornando o trabalho desse equipamento mais simples

icmp-internet control protocol message-tem por objetivo prover mensagens de controle na comunicados dos equipamentos

interfaces de rede-é um software e/ou hardware que faz a comunicação em uma rede de computadores
		   uma dessas interfaces é o loopback um tipo especial de interface que permite fazer conexõe
		   com você mesmo,com ela,você pode testar vários programas sem  interfirir em sua rede padrão, o endereço ip 127.0.0.1
		   foi escolhido para loopback*/
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
