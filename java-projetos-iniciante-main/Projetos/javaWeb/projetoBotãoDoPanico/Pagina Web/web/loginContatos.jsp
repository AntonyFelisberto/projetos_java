<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente" %>
<%@page import="DAO.DAOCliente" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <title>PLAT DU JOUR</title>
</head>
<body>
   <div id="ind">
    <fieldset id="yuki">
    <h1 id="titulo">PLAT DU JOUR</h1><br>
    <form action="efetuarLoginContatos.jsp" method="post">
        <label for="email" class="dds">email</label><br>
        <input type="text" name="email" placeholder="email" class="dds" required/><br>
        <label for="cpf" class="dds">cpf</label><br>
        <input type="text" name="cpf" placeholder="cpf" class="dds" required/><br>
        <label for="senha" class="dds">Senha</label><br>
        <input type="password" name="senha" placeholder="senha" class="dds" required/><br><br>
        <input type="submit" value="Logar"><br><br>
    </form> 
    <a href="Inicio.jsp"><button>Entrar</button></a><br><br>
    <a href="index.jsp">não possuo uma conta</a><br>
    </fieldset>
   </div>
</body>
</html>
