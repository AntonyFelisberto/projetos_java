<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/remoD.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>remover</title>
    </head>
    <body>
        <div style="text-align: center">
        <h1>INATIVAR DISCIPLINA</h1>
        <form method="post" action="remover_dis.jsp">
            <label for="id">ID</label><br>
            <input type="text" name="id" value="<%=request.getParameter("id")%>" readonly/><br>
            <label for="nome">NOME</label><br>
            <input type="text" name="nome" value="<%=request.getParameter("nome")%>" readonly/><br>
            <label for="carga">CARGA</label><br>
            <input type="text" name="carga" value="<%=request.getParameter("carga")%>" readonly/><br><br><br>
            <input type="submit" value="inativar"/><br><br>
        </form>
            <a href="index.jsp"><button>Pagina inicial</button></a>
        </div>
    </body>
</html>
