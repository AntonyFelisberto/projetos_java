<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="css/cds2.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <script src="https://use.fontawesome.com/5dc6c19131.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <script src="css/Localização.js"></script>   
    <title>JSP Page</title>
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
        <audio id="toque" style="display: none;" src="css/Som De Bip_48k.mp3"></audio>
        <form action="https://formspree.io/f/xknklazg" method="POST">
            <label for="email" class="fora" style="display: none;"></label><br>
            <input type="email" style="display: none;" value="<%=request.getParameter("email")%>" name="email" class="fora"><br>
            <label for="cpf" class="fora" style="display: none;"></label><br>
            <input type="text" value="<%=request.getParameter("cpf")%>" name="cpf" class="fora" style="display: none;"><br>
            <label for="localização" class="fora" style="display: none;"></label><br>
            <input type="text" name="localização" id="localize" class="fora" value="" style="display: none;"><br>
            <button type="submit" onclick="altoridade()" style="background:url('css/imagem-b.jpg');background-size: 500px 500px; height: 500px;  width: 500px;" ></button>
        </form>
      </div>
</body>
</html>



