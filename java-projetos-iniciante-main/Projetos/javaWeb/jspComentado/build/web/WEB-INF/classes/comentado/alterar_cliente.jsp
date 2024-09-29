<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <form method="post" action="executar_alterar.jsp" >
                 <!-- method é como vai ser enviado as informações -->  <!-- action é pra onde vai ser enviado as informações-->
                 <label for="id">ID</label><br>
                  <!-- for="" é com o que a label esta ligada-->
                 <input type="text" name="id" value="<%=request.getParameter("id")%>" readonly><br>
                  <!--type é o tipo do input e o name seria o nome da variavel input-->
                    <!--  sempre quando for fazer um input que recebe parametro o type="" pode ser de qualquer tipo(mesmo se aparecer mensagem de erro)//name é a criação do nome da sua variavel que vai guardar os dados do input//value="" você tem que usar < %=  %>  dai dentro dele você pega o parametro que recebeu value="< %=request.getParameter("nomedavariavelquefoiusada"),o value vai mostrar esse valor no input %>"-->
                 <label for="nome">NOME</label>
                  <!-- for="" é com o que essa tag esta ligada -->
                  <input type="text" name="nome" value="<%= request.getParameter("nome")%>" required/><br>
                   <!--type é o tipo do input e o name seria o nome da variavel input-->
                     <!--  sempre quando for fazer um input que recebe parametro o type="" pode ser de qualquer tipo(mesmo se aparecer mensagem de erro)//name é a criação do nome da sua variavel que vai guardar os dados do input//value="" você tem que usar < %=  %>  dai dentro dele você pega o parametro que recebeu value="< %=request.getParameter("nomedavariavelquefoiusada"),o value vai mostrar esse valor no input %>"-->
             <label for="email">EMAIL</label>
              <!-- for="" é com o que essa tag esta ligada -->
             <input type="text" name="email" value="<%=request.getParameter("email")%>" required/><br>
             <!--type é o tipo do input e o name seria o nome da variavel input-->
             <!--  sempre quando for fazer um input que recebe parametro o type="" pode ser de qualquer tipo(mesmo se aparecer mensagem de erro)//name é a criação do nome da sua variavel que vai guardar os dados do input//value="" você tem que usar < %=  %>  dai dentro dele você pega o parametro que recebeu value="< %=request.getParameter("nomedavariavelquefoiusada"),o value vai mostrar esse valor no input %>"-->
             <input type="submit" value="ATUALIZAR"/>
              <!--submit é o que faz o form enviar as informações pra outro lugar////value é o nome que estara no botão de enviar e o que faz enviar valor das informações-->
        </form>
    </body>
</html>
