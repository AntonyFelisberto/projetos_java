
package aprendendojava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AprendendoJava {

    public static void main(String[] args) throws IOException {
        try {
            URL url=new URL ("https://docs.oracle.com/javase/language/");
            //URL serve pra pegar um link//dizendo a pagina com a qual vai se conectar
            URLConnection urlConexao=url.openConnection();
            //URLConnection serve pra pegar e fazer a conexao com a pagina passada//fazendo conexao com a pagina
            BufferedReader buff= new BufferedReader(new InputStreamReader(urlConexao.getInputStream()));
                                                        //InputStreamReader pega os dados da pagina você poderia fazer tambem InputStreamReader input=new InputStreamReader(urlConexao.getInputStream())
                                                                          //urlConexao.getInputStream() faz a conexao e ja pega os dados pra passar para o InputStream
            //BufferedReader transforma todos os dados que pegou em linha ou seja espaços e quebras de linha
            
            System.out.print(buff.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
                                                                        //replaceAll("stringQueVoceVaiSubstituir", "novaString")
            //buff.lines().collect() coleta todas as linhas da pagina
                                                //Collectors.joining() concatena tudo em uma sequencia de caracteres
        } catch (MalformedURLException ex) {
                 //MalformedURLException é uma exceção mas de url o que significa que o link não foi reconhecido
            Logger.getLogger(AprendendoJava.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger é pra pegar a mensagem de erro(nomeclasse.class.getName()).log(Level.SEVERE, null, ex)
                                                                                          //.log diz o erro
                                                                              //getName pega o nome da classe
        }
        
    }
    
}
