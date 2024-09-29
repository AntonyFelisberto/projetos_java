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
    <header>
     <div style="text-align: center">
        <h1>PLAT DU JOUR</h1>
      </div>
    </header>
    <section style="text-align: center;">

<form action="https://formspree.io/f/xeqvbwkb" method="POST" >
    <label class="linha2">Digite seu nome:</label><br>
    <input type="text" name="vitima" required><br><br>
    <label class="linha2">Digite seu email:</label><br>
    <input type="email" name="email"><br><br>
    <label class="linha2">Digite seu endereço:</label><br>
    <input type="text" name="endereço" required><br><br> 
    <label class="linha2">Digite seu telefone:</label><br>
    <input type="tel" name="telefone" required><br><br>   
    <label class="linha2">Digite como anda a preparação da receita:</label><br>
    <textarea name="mensagem" rows="15" cols="50" id="rest" required></textarea><br><br>
    <button type="submit" class="button2">Enviar</button>
</form>
    </section>  
</html>

