<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Disciplina" %>
<%@page import="DAO.DAODisciplina" %>

<%
  try{
      Disciplina dis=new Disciplina();
      DAODisciplina chamada=new DAODisciplina();
      
      String disciplina=request.getParameter("nome");
      int carga=Integer.parseInt(request.getParameter("carga"));
      
      if(carga<=0||disciplina.isEmpty()){
          response.sendRedirect("nova_disciplina.jsp");
      }else{
          dis.setDisciplina(disciplina);
          dis.setCarga(carga);
          chamada.inserir(dis);
          response.sendRedirect("nova_disciplina.jsp");
      }
  }catch(Exception erro){
      throw new RuntimeException("erro ao fazer a inserção da disciplina:",erro);
  }  
%>
