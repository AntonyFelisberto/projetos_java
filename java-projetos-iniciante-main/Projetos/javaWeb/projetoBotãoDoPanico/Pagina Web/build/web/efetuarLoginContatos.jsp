<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente" %>
<%@page import="DAO.DAOCliente" %>
<%@page import="METODOS.validarCpf" %>
<%@page import="METODOS.Email" %>
<% 
      try{
          String cpf,senha,email;
          validarCpf valide=new validarCpf();
          Email validarEmail=new Email();
          boolean logado,verificado,emailValidado;
          email=request.getParameter("email");
          cpf=request.getParameter("cpf");
          senha=request.getParameter("senha");
          verificado=valide.validado(cpf);
          emailValidado=validarEmail.isValidEmailAddress(email);
          if(senha.isEmpty()||cpf.isEmpty()||verificado==false||emailValidado==false){
              out.print("<script>window.alert('dados incorretos verifique seu email e cpf');</script>");
              out.print("<meta http-equiv='refresh' content='1,Contatos.jsp'");
              response.sendRedirect("loginContatos.jsp");
          }else{
            Cliente dados=new Cliente();
            DAOCliente executar=new DAOCliente();
            dados.setCpf(cpf);
            dados.setSenha(senha);
            logado=executar.login(dados);
            if(logado==true){
                response.sendRedirect("Contatos.jsp?email="+email+"&cpf="+cpf);
            }else{
                out.print("<script>window.alert('dados incorretos')</script>");
                response.sendRedirect("loginContatos.jsp");
            }
          }
      }catch(Exception erro){
          throw new RuntimeException("erro ao fazer login :",erro);
      }
%>
