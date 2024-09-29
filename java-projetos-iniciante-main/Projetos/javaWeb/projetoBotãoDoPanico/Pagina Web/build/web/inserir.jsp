<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="METODOS.validarCpf"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="MODEL.Cliente"%> 
<%@page import="METODOS.MatchPhoneNumbers" %>
   <%
      try{
          validarCpf validar=new validarCpf();
          MatchPhoneNumbers telefoneValido=new MatchPhoneNumbers();
          String nome,senha,cpf,telefone,endereço;
          boolean validado,fone;
          
          nome=request.getParameter("nome");
          senha=request.getParameter("senha");
          cpf=request.getParameter("cpf");
          telefone=request.getParameter("telefone");
          endereço=request.getParameter("endereco");
          fone=telefoneValido.valide(telefone);
          validado=validar.validado(cpf);
          if(nome.isEmpty()||senha.isEmpty()||cpf.isEmpty()||telefone.isEmpty()||endereço.isEmpty()||validado==false||fone==false){
              out.print("<script>window.alert('dados incorretos verifique todos os campos');</script>");
             response.sendRedirect("index.jsp");
          }else{
              boolean result;
              Cliente dados=new Cliente();
              DAOCliente executar=new DAOCliente();
              dados.setCpf(cpf);
              dados.setEndereço(endereço);
              dados.setNome(nome);
              dados.setSenha(senha);
              dados.setTelefone(telefone);
              result=executar.inserir(dados);
              if(result==true){
                  response.sendRedirect("Inicio.jsp?");
              }else{
                  out.print("<script>window.alert('dados incorretos ou já cadastrados');</script>");
                  response.sendRedirect("index.jsp");
              }
             }
          
      }catch(Exception erro){
          throw new RuntimeException("erro ao cadastrar dados :",erro);
      }  
    %> 
