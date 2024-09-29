<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- inserir as classes do java--%>
<%@page  import="MODEL.Cliente"%>
<%@page  import="DAO.DAOCliente"%>
<%-- você pode perceber que os metodos de crear,atualizar e deletar só usam os pacotes que você criou--%>
        <%
        
           try{
               Cliente  cli = new Cliente();//transporta a classe e instancia ela
               DAOCliente clm = new DAOCliente();//transporta a classe e instancia ela
               //pegar os valores que foram passado
               String nome=request.getParameter("nome");//request.getParameter("nome da varivel name que foi passada pela sua pagina")->ele basicamente pega os dados do seu input que foi passado(os dados ficam na variavel name)
               //faz a variavel receber os valores do input
               String email=request.getParameter("email");//request.getParameter("nome da varivel name que foi passada pela sua pagina")->ele basicamente pega os dados do seu input que foi passado(os dados ficam na variavel name)
               //faz a variavel receber os valores do input
               if(nome.equals(null)||email.equals(null)){
              
               }
               else{
                   //inserir os valores da classe
                   cli.setNome(nome);
                   cli.setEmail(email);
                   //passa os dados pro metodo de inserir
                   clm.inserirCliente(cli);
                    //responde pra pagina//volta pra ela//ou te leva pra essa pagina
                   response.sendRedirect("index.jsp"); 
               }
           }catch(Exception erro){
               throw new RuntimeException("erro na pagina executar inserir",erro);
           }
        %>

