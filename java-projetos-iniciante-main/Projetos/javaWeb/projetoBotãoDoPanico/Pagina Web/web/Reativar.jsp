<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="MODEL.Cliente"%>
<%@page import="METODOS.validarCpf" %>
<%
   try{
       DAOCliente cliente=new DAOCliente();
       Cliente dados=new Cliente();
       validarCpf validar=new validarCpf();
       boolean validado,reativacao;
       String senha=request.getParameter("senha");
       String cpf=request.getParameter("cpf");
       validado=validar.validado(cpf);
       if(cpf.isEmpty()||validado==false||senha.isEmpty()){
           out.print("<script>window.alert('cpf ou senha invalidos')</script>");
           response.sendRedirect("Cadastro.jsp");
       }else{
           dados.setCpf(cpf);
           dados.setSenha(senha);
           reativacao=cliente.reativar(dados);
           if(reativacao){
               out.print("<script>window.alert('reativação concluida')</script>");
               response.sendRedirect("Inicio.jsp");
           }else{
               out.print("<script>window.alert('reativação concluida')</script>");
               response.sendRedirect("Cadastro.jsp");
           }
       }
   }catch(Exception erro){
       throw new RuntimeException("erro ao desativar dados",erro);
   }  
%>
