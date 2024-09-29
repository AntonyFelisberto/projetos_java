<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="DAO.DAOProfessor"%>
<%@page  import="MODEL.Professor"%>


<%
    try{
        DAOProfessor nova=new DAOProfessor();
        Professor prof=new Professor();
        int id=Integer.parseInt(request.getParameter("id"));
        String nome=request.getParameter("nome");
        String email=request.getParameter("email");
        String senha=request.getParameter("senha");
        if(nome.isEmpty()||email.isEmpty()||senha.isEmpty()){
            response.sendRedirect("fazer_atualizacao_prof.jsp");
        }else{
            prof.setId(id);
            prof.setNome(nome);
            prof.setEmail(email);
            prof.setSenha(senha);
            nova.atualizar(prof);
            response.sendRedirect("fazer_atualizacao_prof.jsp"); 
        }
    }catch(Exception erro){
        throw new RuntimeException("erro ao fazer a atualização dos dados do professor:",erro);
    }





%>
