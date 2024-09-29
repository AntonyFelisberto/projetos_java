<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="DAO.DAOProfessor"%>
<%@page  import="MODEL.Professor"%>

<%
   try{
      DAOProfessor dprof=new DAOProfessor();
      Professor prof=new Professor();
      
      String nome=request.getParameter("nome");
      String email=request.getParameter("email");
      String senha=request.getParameter("senha");
      
      if(nome.isEmpty()||email.isEmpty()||senha.isEmpty()){
          response.sendRedirect("novo_professor.jsp");
      }else{
          prof.setNome(nome);
          prof.setEmail(email);
          prof.setSenha(senha);
          dprof.inserir(prof);
          response.sendRedirect("novo_professor.jsp");  
      }
   }catch(Exception erro){
       throw new RuntimeException("erro ao fazer a inserção de dados de professor",erro);
   }  
%>
