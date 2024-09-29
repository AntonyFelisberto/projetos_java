<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="MODEL.Cliente"%>
<%@page import="METODOS.validarCpf" %>
<%
   try{
       DAOCliente cliente=new DAOCliente();
       Cliente dados=new Cliente();
       validarCpf validar=new validarCpf();
       boolean validado,desativacao;
       String senha=request.getParameter("senha");
       String cpf=request.getParameter("cpf");
       validado=validar.validado(cpf);
       if(cpf.isEmpty()||validado==false||senha.isEmpty()){
           out.print("<script>window.alert('cpf ou senha invalidos');</script>");
           out.print("<script>window.alert('dados incorretos verifique seu cpf e senha');</script>");
           response.sendRedirect("Cadastro.jsp");
       }else{
           dados.setCpf(cpf);
           dados.setSenha(senha);
           desativacao=cliente.inativar(dados);
           if(desativacao){
             out.print("<script>window.alert('inativação concluida')</script>");
             response.sendRedirect("index.jsp"); 
           }else{
              out.print("<script>window.alert('inativação concluida')</script>");
              response.sendRedirect("index.jsp");
           }
       }
   }catch(Exception erro){
       throw new RuntimeException("erro ao desativar dados",erro);
   }  
%>