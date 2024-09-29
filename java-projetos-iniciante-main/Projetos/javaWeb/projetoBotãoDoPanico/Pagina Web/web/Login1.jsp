<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente" %>
<%@page import="DAO.DAOCliente" %>
<%@page import="METODOS.validarCpf" %>
<%@page import="java.util.ArrayList" %>
<% 
      try{
          String cpf,senha;
          validarCpf valide=new validarCpf();
          boolean logado,verificado;
          cpf=request.getParameter("cpf");
          senha=request.getParameter("senha");
          verificado=valide.validado(cpf);
          if(senha.isEmpty()||cpf.isEmpty()||verificado==false){
              out.print("<script>window.alert('dados incorretos verifique seu cpf e senha');</script>");
              response.sendRedirect("Login.jsp");
          }else{
            Cliente dados=new Cliente();
            DAOCliente executar=new DAOCliente();
            dados.setCpf(cpf);
            dados.setSenha(senha);
            logado=executar.login(dados);
            if(logado==true){
                int i;
                String nome="";
                String Cpf="";
                String endereco="";
                String Senha="";
                String telefone="";
                ArrayList<Cliente>lista=executar.listar(dados);
                for(i=0;i<lista.size();i=i+1){
                    Cpf=lista.get(i).getCpf();
                    nome=lista.get(i).getNome();
                    endereco=lista.get(i).getEndereço();
                    Senha=lista.get(i).getSenha();
                    telefone=lista.get(i).getTelefone();
                }                
                response.sendRedirect("Cadastro.jsp?cpf="+Cpf+"&nome="+nome+"&endereco="+endereco+"&senha="+Senha+"&telefone="+telefone);
            }else{
                out.print("<script>window.alert('dados incorretos');</script>");
                response.sendRedirect("Login.jsp");
            }
          }
      }catch(Exception erro){
          throw new RuntimeException("erro ao fazer login :",erro);
      }
%>
