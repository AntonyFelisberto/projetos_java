package conexaowebvideo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private WebView webTela;
    
    private WebEngine engine;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //webTela.getEngine().load("https://www.youtube.com/watch?v=vJMQ0_nndis");//pra carregar tanto youtube quanto qualquer outro link com tudo aparecendo você coloca o link completo(youtube,drive,instagram.......)
                //getEngine pass os dados pra view e o load() carrega a tela com a url
        webTela.getEngine().load("https://www.youtube.com/embed/m1eKlGr1U9Q");//utilizar somente o video sem comentarios ou outras coisas em volta
                //você tira o watch?v=    e coloca /embed/
        //webTela.getEngine().load("https://drive.google.com/file/d/cbXM8aiFk1P8xXzHow_OeM0J/view");
    }    
    
}
