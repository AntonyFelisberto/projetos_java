package VIEW;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import MODEL.Dados;
import MODEL.TabelaFilmes;
import DAO.ValidarCpf;
import DAO.Metodos;
import DAO.Conexao;
import DAO.DAOReserva;
import MODEL.Reserva;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {
    ValidarCpf validar=new ValidarCpf();
    static int s=0,saida=0,saidaC=0,saidaB=0,saidaA=0,menorValor=20,m=1;
    static String guardarcpf;
    static String nomeFilme;
    public ResultSet rest;
    public PreparedStatement prepare;
    public Statement estado;
    public Connection conec;
    static Integer valor;
    
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
    
    Media mediaA= new Media("file:///C:/Users/VP/Documents/GitHub/prova/src/TRAILERS/Homem-Aranha.mp4");
    MediaPlayer Aranha= new MediaPlayer(mediaA);
    
    Media mediaE= new Media("file:///C:/Users/VP/Documents/GitHub/prova/src/TRAILERS/Eternos.mp4");
    MediaPlayer Eternos= new MediaPlayer(mediaE);
         
    Media mediaV= new Media("file:///C:/Users/VP/Documents/GitHub/prova/src/TRAILERS/Venom.mp4");
    MediaPlayer Venom= new MediaPlayer(mediaV);
            
    Media mediaS= new Media("file:///C:/Users/VP/Documents/GitHub/prova/src/TRAILERS/Shang-Chi.mp4");
    MediaPlayer player= new MediaPlayer(mediaS);
    
    @FXML
    private TableColumn<TabelaFilmes, String> NumeroCadeira;

    @FXML
    private TableColumn<TabelaFilmes, String> Status;

    @FXML
    private TableView<TabelaFilmes> TabelaCadeiras;
    
    ObservableList<TabelaFilmes>listar=FXCollections.observableArrayList();
    
    @FXML
    private MediaView trailer;
    
    @FXML
    private TextField Ingresso;
    
    @FXML
    void reservarLugar(ActionEvent event) {
            try{
                valor=valorDaRoda.getValue();
                Reserva dados=new Reserva();
                DAOReserva reservar=new DAOReserva();
                String tipoIngresso;
                boolean validacao;
                tipoIngresso=Ingresso.getText();
                if(valor<=0 || valor>10 || tipoIngresso.isEmpty()){
                    JOptionPane.showMessageDialog(null,"insira os valores corretamente nos campos");
                }else{
                    if(tipoIngresso.equals("M")||tipoIngresso.equals("m")){
                        dados.setCpf(guardarcpf);
                        dados.setNomeFilme(nomeFilme);
                        dados.setTipoIngresso("M");
                        validacao=reservar.inserir(dados, valor, nomeFilme);
                        if(validacao){
                            JOptionPane.showMessageDialog(null,"dados cadastrados ja pode ir ao cinema");
                        }else{
                            JOptionPane.showMessageDialog(null,"não foi possivel registrar os dados verifique se preencheu seus dados corretamente e se escolheu uma cadeira vazia");
                        }
                    }else if(tipoIngresso.equals("I")||tipoIngresso.equals("i")){
                        dados.setCpf(guardarcpf);
                        dados.setNomeFilme(nomeFilme);
                        dados.setTipoIngresso("I");
                        validacao=reservar.inserir(dados, valor, nomeFilme); 
                        if(validacao){
                            JOptionPane.showMessageDialog(null,"dados cadastrados ja pode ir ao cinema");
                        }else{
                            JOptionPane.showMessageDialog(null,"não foi possivel registrar os dados verifique se preencheu seus dados corretamente e se escolheu uma cadeira vazia");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Digite M para meia ou I para inteira");
                    }
                }
            }catch(Exception erro){
                throw new RuntimeException("erro ao registrar cliente ao cinema",erro);
            }
    }
    
    public void listarTabelaCadeiras(){
        try{
            String filme=this.nomeFilme;
            String sql="SELECT * FROM "+filme+" WHERE STATUS='A'";
            conec=new Conexao().Conectar();
            estado=conec.createStatement();
            rest=estado.executeQuery(sql);
            while(rest.next()){
               TabelaFilmes tabelas=new TabelaFilmes();
               tabelas.setId(rest.getInt("id"));
               tabelas.setSTATUS(rest.getString("STATUS"));
               listar.add(tabelas);        
               if(rest.getInt("id")<menorValor){
                   menorValor=rest.getInt("id");
               }else{
                   menorValor=0;
               }
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao listar dados "+erro.getMessage());
        }
        NumeroCadeira.setCellValueFactory(new PropertyValueFactory("id"));
        Status.setCellValueFactory(new PropertyValueFactory("STATUS"));
        TabelaCadeiras.setItems(listar);
        valorDaRoda.setValue(menorValor);
        rotacao.setValueFactory(valorDaRoda);

    }
    
    @FXML
    private Button botaoA;
    
    @FXML
    private Button botaoE;

    @FXML
    private Button botaoS;

    @FXML
    private Button botaoV;
    
    @FXML
    private Button bt_login;

    @FXML
    private TextField tx_cpf;

    @FXML
    private PasswordField tx_senha;
    
    @FXML
    private Button Logar;
    
    @FXML
    private Button Botao;
    
    @FXML
    private TextField Cpf;
    
    @FXML
    private Button btCadastrar;

    @FXML
    private Spinner<Integer> rotacao;
    SpinnerValueFactory<Integer> valorDaRoda=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
    
    @FXML
    private Button voltar;
    
    @FXML
    private TextField Email;

    @FXML
    private TextField Nome;


    @FXML
    private PasswordField Senha;

    @FXML
    private TextField Telefone;
    
    @FXML
    void trailers(ActionEvent event){
            Aranha.setVolume(15);
            Eternos.setVolume(15);
            Venom.setVolume(15);
            player.setVolume(15);
        if(s==3){
           if(saidaA==0){
                trailer.setMediaPlayer(Aranha);
                play();
                saidaA=1;
           }else{
               Aranha.stop();
               saidaA=0;
            } 
        }else if(s==2){
           if(saidaB==0){
                 trailer.setMediaPlayer(Eternos);
                 play();
                saidaB=1;
           }else{
               Eternos.stop();
               saidaB=0;
            } 
        }else if(s==1){
           if(saidaC==0){
                 trailer.setMediaPlayer(Venom);
                 play();
                 saidaC=1;
           }else{
               Venom.stop();
               saidaC=0;
           } 
        }else{
           if(saida==0){
                 trailer.setMediaPlayer(player);
                 play();
                saida=1;
           }else{
               player.stop();
               saida=0;
            } 
       }
    }
    
    public void play(){
        if(s==1){
            Venom.play();
            player.stop();
            Eternos.stop();
            Aranha.stop();
        }else if(s==2){
            Eternos.play();
            player.stop();
            Venom.stop();
            Aranha.stop();
        }else if(s==3){
            Aranha.play();
            player.stop();
            Eternos.stop();
            Venom.stop();
        }else{
            player.play();
            Venom.stop();
            Eternos.stop();
            Aranha.stop();
        }
    }
    @FXML
    void proximaTelaAranha(ActionEvent event) throws IOException {
        this.s=3;
        this.nomeFilme="Aranha";
        try{
        Stage stages = (Stage) botaoA.getScene().getWindow();
        stages.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXML_2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 650, 800);
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
              e.printStackTrace();
        }
    }
 
    @FXML
    void proximaTelaEternos(ActionEvent event) throws IOException {
        this.s=2;
        this.nomeFilme="Eternos";
        try{
        Stage stages = (Stage) botaoE.getScene().getWindow();
        stages.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXML_2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 650, 800);
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
              e.printStackTrace();
        }
    }

    @FXML
    void proximaTelaShang(ActionEvent event) throws IOException {
        this.s=4;
        this.nomeFilme="Shang";
        try{
        Stage stages = (Stage) botaoS.getScene().getWindow();
        stages.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXML_2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 650, 800);
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
              e.printStackTrace();
        }
    }

    @FXML
    void proximaTelaVenom(ActionEvent event) throws IOException {
        this.s=1;
        this.nomeFilme="Venom";
         try{
        Stage stages = (Stage) botaoV.getScene().getWindow();
        stages.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXML_2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 650, 800);
        stage.setScene(scene);
        stage.show(); 
        } catch (IOException e) {
              e.printStackTrace();
        }
    }
    @FXML
    public void cadastrar() throws IOException{
        String nome,cpf,senha,telefone,email;
        boolean validado;
        nome=this.Nome.getText();
        senha=this.Senha.getText();
        telefone=this.Telefone.getText();
        cpf=this.Cpf.getText();
        email=this.Email.getText();
        validado=validar.validado(cpf);
        
        if(nome.isEmpty()||senha.isEmpty()||telefone.isEmpty()||cpf.isEmpty()||email.isEmpty()||validado==false){
            JOptionPane.showMessageDialog(null,"valores incorretos, verifique campos vazios e seu cpf");
        }else{
            Metodos chamarRegistros=new Metodos();
            Dados dados=new Dados();
            boolean receber;
            dados.setCpf(cpf);
            dados.setEmail(email);
            dados.setNome(nome);
            dados.setSenha(senha);
            dados.setTelefone(telefone);
            receber=chamarRegistros.inserir(dados);
        if(receber){
            guardarcpf=cpf;
            try{
             Stage stages = (Stage) Botao.getScene().getWindow();
             stages.close();
             Parent root = FXMLLoader.load(getClass().getResource("FXML_3.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene(root, 800, 800);
             stage.setScene(scene);
             stage.show();
            } catch (IOException e) {
              e.printStackTrace();
            }
        }else{
                JOptionPane.showMessageDialog(null,"valores incorretos ou dados já cadastrados");
            }
        }
    }
    @FXML
    public void logar() throws Exception{
        try{         
        Stage stages = (Stage) Logar.getScene().getWindow();
        stages.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 650, 600);
        stage.setScene(scene);
        stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void inicio() throws Exception {
        try{
        if(s==1){
            Venom.stop();
        }else if(s==2){
            Eternos.stop();
        }else if(s==3){
            Aranha.stop();
        }else{
            player.stop();
        }
        Stage stages = (Stage) voltar.getScene().getWindow();
        stages.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXML_3.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 1000, 650);
        stage.setScene(scene);
        stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }   
    }
    
    @FXML
    public void registrar() throws Exception {
        try{
        Stage stages = (Stage) btCadastrar.getScene().getWindow();
        stages.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXML_1.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 650, 600);
        stage.setScene(scene);
        stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }   
    }
    
    @FXML
    public void telaprincipal(ActionEvent event)throws Exception{
        try{
           Dados dados = new Dados();
           Metodos metodos = new Metodos();
           String cpf,senha;
           cpf = tx_cpf.getText();
           senha= tx_senha.getText();
           Boolean valide;
           valide=validar.validado(cpf);
           if(cpf.isEmpty()||senha.isEmpty()||valide==false){
               JOptionPane.showMessageDialog(null, "Verifique se os campos estão completos");
           }else{
               dados.setCpf(cpf);
               dados.setSenha(senha);
               Boolean logar;
               logar=metodos.logar(dados);
               if(logar){
                    guardarcpf=cpf;
                    Stage stages = (Stage) bt_login.getScene().getWindow();
                    stages.close();
                    Parent root = FXMLLoader.load(getClass().getResource("FXML_3.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root, 1000, 650);
                                               //largura//altura
                    stage.setScene(scene);
                    stage.show();
               }else{
                   JOptionPane.showMessageDialog(null, "Verifique se os dados estão corretos!Erro de autenticação");
               }
           }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 
    } 
    
  }





/*@FXML TABELA PARA VISUALIZAÇÃO DE USUARIOS
    private TableView<Tabela> table;
    
    @FXML
    private TableColumn<Tabela,String> cpf;

    @FXML
    private TableColumn<Tabela, String> email;

    @FXML
    private TableColumn<Tabela, String> senha;

    @FXML
    private TableColumn<Tabela, String> nome;

    @FXML
    private TableColumn<Tabela, String> telefone;
    
    @FXML
    private TableColumn<Tabela, String> status;
    
    ObservableList<Tabela>lista=FXCollections.observableArrayList();

    public void listarTabela(){
        try{
            String sql="SELECT * FROM usuario";
            conec=new Conexao().Conectar();
            estado=conec.createStatement();
            rest=estado.executeQuery(sql);
            while(rest.next()){
               Tabela tabelas=new Tabela();
               tabelas.setCpf(rest.getString("cpf"));
               tabelas.setTelefone(rest.getString("telefone"));
               tabelas.setEmail(rest.getString("email"));
               tabelas.setSenha(rest.getString("senha"));
               tabelas.setNome(rest.getString("nome"));
               tabelas.setStatus(rest.getString("status"));
               lista.add(tabelas);        
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao listar dados "+erro.getMessage());
        }
        telefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        nome.setCellValueFactory(new PropertyValueFactory("nome"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        cpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        senha.setCellValueFactory(new PropertyValueFactory("senha"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        table.setItems(lista);
    }*/

    
       
    
