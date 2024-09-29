<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente" %>
<%@page import="DAO.DAOCliente"%>
<%@page import="METODOS.validarCpf" %>

<%
  try{
      DAOCliente cliente=new DAOCliente();
      Cliente dados=new Cliente();
      validarCpf validarcpf=new validarCpf();
      boolean validadoCpf;
      String nome,senha,cpf,telefone,endereco,senhaNova;
      nome=request.getParameter("nome");
      senha=request.getParameter("senha");
      telefone=request.getParameter("telefone");
      endereco=request.getParameter("endereco");
      senhaNova=request.getParameter("senhaNova");
      cpf=request.getParameter("cpf");
      validadoCpf=validarcpf.validado(cpf);
      if(nome.isEmpty()||senha.isEmpty()||endereco.isEmpty()||cpf.isEmpty()||telefone.isEmpty()||senhaNova.isEmpty()||validadoCpf==false){
          out.print("<script>window.alert('não foi possivel atualizar seus dados verifique se digitou tudo corretamente')</script>");
          response.sendRedirect("Login.jsp");
      }else{
          dados.setCpf(cpf);
          dados.setEndereço(endereco);
          dados.setNome(nome);
          dados.setSenha(senha);
          dados.setTelefone(telefone);
          cliente.atualizar(dados,senhaNova);
          out.print("<script>window.alert('dados atualizados')</script>");
          response.sendRedirect("Login.jsp");
      }
  }catch(Exception erro){
      throw new RuntimeException("erro ao atualizar dados do usuario",erro);
  }
%>