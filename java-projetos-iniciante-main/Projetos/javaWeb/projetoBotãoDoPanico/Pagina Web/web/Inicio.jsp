<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link href="css/cds2.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<script src="https://use.fontawesome.com/5dc6c19131.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>PLAT DU JOUR</title>
        <script src="css/Ingredientes.js"></script> 
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
        <h2>Clique nas imagens para ver receitas</h2>
      </div>
      <div class="logo1">
        <img src="css/logo1.png" onclick="CDS()">
        <img src="css/logo2.png" onclick="BS()">
        <img src="css/logo3.png" onclick="RZ()">
        <img src="css/logo4.png" onclick="RTD()">
      </div>
      <div style="text-align: center">
        <p id="nova"></p>
        <p id="novo" class="linha"></p>
      </div>
    </body>
</html>

