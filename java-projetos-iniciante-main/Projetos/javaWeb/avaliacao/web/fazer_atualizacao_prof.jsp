<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/new_professor.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>atualizar</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Novos dados</h1>
            <form method="post" action="atualizar_prof.jsp">
                <label for="id">ID</label><br>
                <input type="text" name="id" value="<%=request.getParameter("id")%>" readonly/><br>
                <label for="nome">NOME</label><br> 
                <input type="text" name="nome" value="<%=request.getParameter("nome")%>" placeholder="digite o nome"/><br>
                <label for="email">EMAIL</label><br> 
                <input type="email" name="email" value="<%=request.getParameter("email")%>" placeholder="digite o email"/><br>
                <label for="senha">SENHA</label><br> 
                <input type="password" name="senha" value="<%=request.getParameter("senha") %>" placeholder="digite a senha"/><br><br>
                <input type="submit" value="atualizar"/><br><br>
            </form>
             <a href="index.jsp"><button>Pagina inicial</button></a>
        </div>
    </body>
</html>
