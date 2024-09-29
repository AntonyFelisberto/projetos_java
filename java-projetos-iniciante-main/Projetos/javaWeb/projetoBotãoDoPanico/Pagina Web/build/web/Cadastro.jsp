<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link href="css/cds2.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<script src="https://use.fontawesome.com/5dc6c19131.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>PLAT DU JOUR</title>
        <script src="css/Cadastro.js"></script> 
    </head>
<body>
<input type="checkbox" id="check">
<label class="icone" for="check"><i class="fa fa-bars" aria-hidden="true"></i></label>
<div class="barra">
	<nav>
	    <a href="Inicio.jsp"><div>INICIO</div></a>
	    <a href="Sobre.jsp"><div>SOBRE</div></a>
            <a href="Status.jsp"><div>STATUS</div></a>
            <a href="Login.jsp"><div>CADASTRO</div></a>
	    <a href="loginContatos.jsp"><div>CONTATOS</div></a>
	</nav>
</div>
     <div style="text-align: center">
        <h1>PLAT DU JOUR</h1>
        <img src="css/appCell.jpg" id="image">
        <h2 class="linha3">Clique para fazer mudanças na sua conta</h2>
        <button class="button" onclick="atualize()">ATUALIZAR</button><button class="button" onclick="inative()">INATIVAR</button><button class="button" onclick="ative()">ATIVAR</button>
      </div>
<br><br><br>
<div id="atualizar" style="display: none" class="linha">
    <form method="post" action="Atualizar.jsp" >
        <label for="nome" class="dds">NOME:</label><br>
        <input  type="text" name="nome" value="<%=request.getParameter("nome")%>" class="dds" required/><br>
        <label for="senha" class="dds">SENHA ANTIGA:</label><br>
        <input type="password" name="senha" value="<%=request.getParameter("senha")%>" class="dds" readonly/><br>
        <label for="senha" class="dds">SENHA NOVA:</label><br>
        <input type="password" name="senhaNova" class="dds" required/><br>
        <label for="cpf" class="dds">CPF</label><br>
        <input type="text" name="cpf" class="dds" value="<%=request.getParameter("cpf")%>" readonly/><br>
        <label for="telefone" class="dds">TELEFONE:</label><br>
        <input type="text" name="telefone" class="dds" value="<%=request.getParameter("telefone")%>" required/><br>
        <label for="endereco" class="dds">ENDEREÇO:</label><br>
        <input type="text" name="endereco" class="dds" value="<%=request.getParameter("endereco")%>" required/><br><br>
        <input class="button" type="submit" value="Registrar"><br>
    </form>
   </form>     
</div>

<div id="inativar" style="display: none" class="linha">
   <form action="Desativar.jsp" method="post">
    <label>DIGITE SEU CPF:</label><br>
    <input type="text" name="cpf"/><br>
    <label for="senha">DIGITE SUA SENHA:</label><br>
    <input type="text" name="senha"/><br><br>
    <input class="button" type="submit" value="Inativar">   
   </form>     
</div>

<div id="ativar" style="display: none" class="linha">
   <form action="Reativar.jsp" method="post">
    <label >DIGITE SEU CPF:</label><br>
    <input type="text" name="cpf"/><br>
    <label for="senha">DIGITE SUA SENHA:</label><br>
    <input type="text" name="senha"/><br><br>
    <input class="button2" type="submit" value="Ativar"/>   
   </form>     
</div>
    </body>
</html>