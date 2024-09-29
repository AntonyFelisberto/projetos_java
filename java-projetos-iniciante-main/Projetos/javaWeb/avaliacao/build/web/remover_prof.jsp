<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="DAO.DAOProfessor"%>


<%
  try{
      DAOProfessor nova=new DAOProfessor();
      int iden=Integer.parseInt(request.getParameter("id"));
      nova.deletar(iden);
      response.sendRedirect("fazer_remocao_prof.jsp");
  }catch(Exception erro){
      throw new RuntimeException("erro ao tentar remover dados do professor:",erro);
  }  






%>