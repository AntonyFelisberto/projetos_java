<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAODisciplina" %>
<%@page import="MODEL.Disciplina" %>

<%
   try{
       DAODisciplina nova=new DAODisciplina();
       Disciplina dis=new Disciplina();
       int id=Integer.parseInt(request.getParameter("id"));
       String nome=request.getParameter("nome");
       int carga=Integer.parseInt(request.getParameter("carga"));
       if(carga<=0||nome.isEmpty()){
          response.sendRedirect("fazer_atualizacao_dis.jsp");
       }else{
           dis.setId(id);
           dis.setDisciplina(nome);
           dis.setCarga(carga);
           nova.atualizar(dis);
           response.sendRedirect("fazer_atualizacao_dis.jsp");
       }
   }catch(Exception erro){
       throw new RuntimeException("erro ao atualizar dados da disciplina:",erro);
   }  







%>