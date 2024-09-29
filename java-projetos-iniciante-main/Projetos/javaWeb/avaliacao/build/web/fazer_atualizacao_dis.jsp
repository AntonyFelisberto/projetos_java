<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/new_disciplina.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>atualizar</title>
    </head>
    <body>
        <div style="text-align: center">
        <h1>MODIFICAR</h1>
        <form method="post" action="atualizar_dis.jsp">
            <label for="id">ID</label><br>
            <input type="text" name="id" value="<%=request.getParameter("id")%>" readonly/><br>
            <label for="nome">NOME</label><br>
            <input type="text" name="nome" value="<%=request.getParameter("nome")%>" placeholder="digite o nome da disciplina" /><br>
            <label for="carga">CARGA</label><br>
            <input type="number" name="carga" value="<%=request.getParameter("carga")%>"  placeholder="digite o numero da carga horaria"/><br><br>
            <input type="submit" value="atualizar"/><br><br>
        </form>
             <a href="index.jsp"><button>Pagina inicial</button></a>
        </div>
    </body>
</html>
