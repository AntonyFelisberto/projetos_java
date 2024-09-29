<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOProfessor"%>
<%@page import="MODEL.Professor"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/new_searchp.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>consulta</title>
    </head>
    <body>
        <div style="text-align: center">
        <form method="post" action="consultar_professor.jsp">
            <label >pesquisar</label>
            <input type="text" name="nome" placeholder="digite o nome da pessoa"/>
            <input type="submit" value="search"/>            
        </form>   
        <h1>DADOS PROFESSOR</h1>
        </div>
        <%
           out.print("<table border='1' style='margin:auto'>");
           out.print("<tr>");
            out.print("<th>ID</th>");
            out.print("<th>NOME</th>");
            out.print("<th>EMAIL</th>");
            out.print("<th>SENHA</th>");
            out.print("<th>EXCLUIR</th>");
            out.print("<th>ALTERAR</th>");
           out.print("</tr>");
           DAOProfessor dados=new DAOProfessor();
           if(request.getParameter("nome")==null||request.getParameter("nome").equals("")){
            ArrayList<Professor>listar=dados.listar();
            for(int i=0;i<listar.size();i=i+1){
              out.print("<tr>");
                out.print("<td>"+listar.get(i).getId()+"</td>");
                out.print("<td>"+listar.get(i).getNome()+"</td>");
                out.print("<td>"+listar.get(i).getEmail()+"</td>");
                out.print("<td>"+listar.get(i).getSenha()+"</td>");
                out.print("<td><a href='fazer_remocao_prof.jsp?id="+listar.get(i).getId()+"&nome="+listar.get(i).getNome()+"&email="+listar.get(i).getEmail()+"&senha="+listar.get(i).getSenha()+"'>EXCLUIR</a></td>");
                out.print("<td><a href='fazer_atualizacao_prof.jsp?id="+listar.get(i).getId()+"&nome="+listar.get(i).getNome()+"&email="+listar.get(i).getEmail()+"&senha="+listar.get(i).getSenha()+"'>ALTERAR</a></td>");
              out.print("</tr>"); 
            }
           }else{
               ArrayList<Professor>listar=dados.listarP(request.getParameter("nome"));
               for(int i=0;i<listar.size();i=i+1){
                out.print("<tr>");
                    out.print("<td>"+listar.get(i).getId()+"</td>");
                    out.print("<td>"+listar.get(i).getNome()+"</td>");
                    out.print("<td>"+listar.get(i).getEmail()+"</td>");
                    out.print("<td>"+listar.get(i).getSenha()+"</td>");
                    out.print("<td><a href='fazer_remocao_prof.jsp?id="+listar.get(i).getId()+"&nome="+listar.get(i).getNome()+"&email="+listar.get(i).getEmail()+"&senha="+listar.get(i).getSenha()+"'>EXCLUIR</a></td>");
                    out.print("<td><a href='fazer_atualizacao_prof.jsp?id="+listar.get(i).getId()+"&nome="+listar.get(i).getNome()+"&email="+listar.get(i).getEmail()+"&senha="+listar.get(i).getSenha()+"'>ALTERAR</a></td>");
                out.print("</tr>"); 
                }
           }
           out.print("</table>");
        %>
        <br><br>
        <div style="text-align: center">
         <a href="index.jsp"><button>Pagina inicial</button></a>
        </div>
    </body>
</html>
