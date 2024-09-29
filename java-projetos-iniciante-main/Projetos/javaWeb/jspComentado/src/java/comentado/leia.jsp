<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="DAO.DAODados"%>
<%@page  import="MODEL.Dados"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <form action="leia.jsp" method="post" >
        <label>NOME</label>
        <input type="text" name="nome"/>
        <label>SENHA</label>
        <input type="text" name="senha"/>
        <label>CPF</label>
        <input type="text" name="cpf"/>
        <label>TELEFONE</label>
        <input type="text" name="telefone"/>
        <label>ENDEREÇO</label>
        <input type="text" name="endereco"/>
        <input type="submit" value="enviar"/>
    </form>
    <%--cuidado pra não escrever forms o correto é form--%>
    
    <%
       //existem varias maneiras de fazer o if nessa pagina
       //você pode fazer os ifs com o próprio request ou com as variaveis
       //uma coisa que você não pode fazer de jeito nenhum é fazer um if com uma condição que você não quer que aconteça ficar redirecionando pra pagina do formulario,porque se não ela fica redirecionando em loop//a menos que você tenha feito a inserção em outra página ai sim você pode mandar um reponse pro formulario pois nãop vai ficar em loop
       
       
       try{
           
          if(request.getParameter("cpf")==null||request.getParameter("cpf").equals("")||
          request.getParameter("endereco")==null||request.getParameter("endereco").equals("")||
          request.getParameter("senha")==null||request.getParameter("senha").equals("")||
          request.getParameter("telefone")==null|| request.getParameter("telefone").equals("")||
          request.getParameter("nome")==null||request.getParameter("nome").equals("")){
              //aqui tem um exemplo de if com o request,o if tem que estar nessa ordem senão ele não vai (request.getParameter("nome")==null||request.getParameter("nome")=="")
               
           }
          
           String nome=request.getParameter("cpf");
           int idade=Integer.parseInt(request.getParameter("idade"));
           if(nome!=null && idade>0){
               //aqui tem outro exemplo que funciona igual ao de cima no caso você só coloca o valor dentro das variaveis e verifica elas no if
               response.sendRedirect("");
               //aqui sim você vai redirecionar pois você quer que isso aconteça
           }else if(nome==null||nome.equals("")||idade<=0){
               //o que você não quer que aconteça ou seja você não vai usar o response
           }
           
       }catch(Exception erro){
           throw new RuntimeException("erro ao fazer transferencia",erro);
       } 
        
        
     %>
    </body>
</html>
