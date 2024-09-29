<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="METODOS.validarCpf"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="MODEL.Cliente"%> 
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PLAT DU JOUR</title>
</head>
<body>
   <div id="ind">
    <fieldset id="yuki">
    <h1 id="titulo">PLAT DU JOUR</h1><br>
    <form method="post" action="inserir.jsp">
        <label for="nome" class="dds">Nome</label><br>
        <input type="text" name="nome" placeholder="nome" class="dds" required/><br>
        <label for="senha" class="dds">Senha</label><br>
        <input type="password" name="senha" placeholder="senha" class="dds" required/><br>
        <label for="cpf" class="dds">Cpf</label><br>
        <input type="text" name="cpf" placeholder="cpf" class="dds" required/><br>
        <label for="telefone" class="dds">Telefone</label><br>
        <input type="text" name="telefone" placeholder="telefone com (ddd)" class="dds" required/><br>
        <label for="endereco" class="dds">Endereço</label><br>
        <input type="text" name="endereco" placeholder="endereco" class="dds" required/><br><br>
        <input type="submit" value="Registrar"><br>
    </form>
    <br>
    <a href="Inicio.jsp"><button>Entrar</button></a>
    </fieldset>     
   </div>
</body>
</html>
