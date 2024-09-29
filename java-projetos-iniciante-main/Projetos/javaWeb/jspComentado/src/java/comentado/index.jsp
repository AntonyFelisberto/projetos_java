<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="executar_inserir.jsp" >
                 <!-- method é como vai ser enviado as informações -->  <!-- action é pra onde vai ser enviado as informações-->
            <label for="nome">NOME</label>
                  <!-- for="" é com o que essa tag esta ligada -->
            <input type="text" name="nome" required/><br>
                   <!--type é o tipo do input e o name seria o nome da variavel input-->
             <label for="email">EMAIL</label>
             <input type="text" name="email" required/><br>
             <input type="submit" value="enviar"/>
                 <!--submit é o que faz o form enviar as informações pra outro lugar////value é o nome que estara no botão de enviar e o que faz enviar valor das informações-->
        </form>
        <a href="consultar_clientes.jsp">consultar</a>
    </body>
</html>
