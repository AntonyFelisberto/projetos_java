<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAODisciplina" %>

<%
  try{
      DAODisciplina dis=new DAODisciplina();
      int dado=Integer.parseInt(request.getParameter("id"));
      dis.remover(dado);
      response.sendRedirect("fazer_remocao_dis.jsp");
  }catch(Exception erro){
      throw new RuntimeException("erro ao remover dados da disciplina:",erro);
  }  






%>