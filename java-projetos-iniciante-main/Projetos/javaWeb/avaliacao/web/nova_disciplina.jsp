<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/new_disciplina.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <div style="text-align: center">
        <h1>CADASTRAR DISCIPLINA</h1>
        <form method="post" action="insere_dis.jsp">
            <label for="nome">NOME</label>
            <input type="text" name="nome" placeholder="nome" required />
            <label for="email">Carga</label>
            <input type="number" name="carga" placeholder="carga" required/><br><br>
            <input type="submit" value="cadastrar"/>
        </form>
        <br>
        <a href="index.jsp"><button>Pagina inicial</button></a>
        </div>
    </body>
</html>
