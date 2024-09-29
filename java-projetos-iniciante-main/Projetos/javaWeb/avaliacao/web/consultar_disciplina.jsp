<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAODisciplina" %>
<%@page import="java.util.ArrayList"%>
<%@page import="MODEL.Disciplina" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="css/new_searchd.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>consulta</title>
    </head>
    <body>
        <div style="text-align: center">
        <form method="post" action="consultar_disciplina.jsp">
            <label >pesquisar</label>
            <input type="text" name="nome" placeholder="digite o nome da matéria"/>        
            <input type="submit" value="search"/>    
        </form>
        <h1>DADOS DISCIPLINA</h1>
        </div>
        <%
          out.print("<table border='1' style='margin:auto'>");
          out.print("<tr>");
             out.print("<th>ID</th>");
             out.print("<th>NOME</th>");
             out.print("<th>CARGA</th>");
             out.print("<th>EXCLUIR</th>");
             out.print("<th>ALTERAR</th>");
          out.print("</tr>");
          DAODisciplina dis=new DAODisciplina();
          if(request.getParameter("nome")==null||request.getParameter("nome").equals("")){
             ArrayList<Disciplina>listar=dis.listar();
            for(int i=0;i<listar.size();i=i+1){
             out.print("<tr>");
              out.print("<th>"+listar.get(i).getId()+"</th>");
              out.print("<th>"+listar.get(i).getDisciplina()+"</th>");
              out.print("<th>"+listar.get(i).getCarga()+"</th>");
              out.print("<th><a href='fazer_remocao_dis.jsp?id="+listar.get(i).getId()+"&nome="+listar.get(i).getDisciplina()+"&carga="+listar.get(i).getCarga()+"'>EXCLUIR</a></th>");
              out.print("<th><a href='fazer_atualizacao_dis.jsp?id="+listar.get(i).getId()+"&nome="+listar.get(i).getDisciplina()+"&carga="+listar.get(i).getCarga()+"'>ALTERAR</a></th>");
             out.print("</tr>");  
              
            }
          }else{
               ArrayList<Disciplina>listar=dis.listarP(request.getParameter("nome"));
                for(int i=0;i<listar.size();i=i+1){
                  out.print("<tr>");
                    out.print("<th>"+listar.get(i).getId()+"</th>");
                    out.print("<th>"+listar.get(i).getDisciplina()+"</th>");
                    out.print("<th>"+listar.get(i).getCarga()+"</th>");
                    out.print("<th><a href='fazer_remocao_dis.jsp?id="+listar.get(i).getId()+"&nome="+listar.get(i).getDisciplina()+"&carga="+listar.get(i).getCarga()+"'>EXCLUIR</a></th>");
                    out.print("<th><a href='fazer_atualizacao_dis.jsp?id="+listar.get(i).getId()+"&nome="+listar.get(i).getDisciplina()+"&carga="+listar.get(i).getCarga()+"'>ALTERAR</a></th>");
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
