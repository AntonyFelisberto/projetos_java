<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOCliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="consultar_clientes.jsp">
            <%-- method é o tipo de envio que vai ser feito e action é pra onde os dados são enviados(no caso é pra mesma pagina)--%>
            <label>PESQUISAR</label>
            <input type="text" name="nome"/>
               <%--type é o tipo do input e name seria a criação do nome da variavel que guarda os dados do input--%>
            <input type="submit" /> 
        </form>
        <%
          out.print("<table border='1'>");
                    //border é quão grossa é a borda da tabela
          out.print("<tr>");
            out.print("<th>ID</th>");
            out.print("<th>NOME</th>");
            out.print("<th>EMAIL</th>");
            out.print("<th>EDITAR</th>");
            out.print("<th>EXCLUIR</th>");
          out.print("</tr>");
          DAOCliente cli=new DAOCliente();//instanciando a class pra usar ela
          
          //verifica se a variavel nome que esta no form de pesquisa possui algum valor
          if(request.getParameter("nome")==null||request.getParameter("nome")==""){
              //o if tem que estar nessa ordem senão ele não vai (request.getParameter("nome")==null||request.getParameter("nome")=="")
             //request.getParameter("nome da varivel name que foi passada pela sua pagina")->ele basicamente pega os dados do seu input que foi passado(os dados ficam na variavel name)
          //codigo para listar nome
          ArrayList<Cliente> lista=cli.listarClientes();
          //cria um array <com o tamanho de dados da classe cliente> nome array=classedao.função(); que vai fazer o array receber todos os dados que estão sendo passados
          for(int i=0;i<lista.size();i=i+1){
                       //vai ficar no laço até os dados serem vazios
          out.print("<tr>");
             out.print("<td>"+lista.get(i).getId()+"</td>");
             out.print("<td>"+lista.get(i).getNome()+"</td>");
             out.print("<td>"+lista.get(i).getEmail()+"</td>");
             out.print("<th><a href='alterar_cliente.jsp?id="+lista.get(i).getId()+"&nome="+lista.get(i).getNome()+"&email="+lista.get(i).getEmail()+"'>EDITAR</a></th>");
                         //pra fazer um redirecionamento você coloca "<tag><a href='local.tipo'>nomequeficanatag</a></tag>"
                         //agora pra fazer um redirecionamento e enviar dados é diferente "<tag><a href='local.tipo?nomedavariavel="+valor+"&nomeoutravariavel="+valor+"'>nomequevainatag</a></tag>"
             out.print("<th><a href='excluir_cliente.jsp?id="+lista.get(i).getId()+"&nome="+lista.get(i).getNome()+"'>EXCLUIR</a></th>");
          out.print("</tr>");
          }
          }else{
             ArrayList<Cliente> lista=cli.listarClientesNome(request.getParameter("nome"));
             //cria um array <com o tamanho de dados da classe cliente> nome array=classedao.função(request.getParameter("nomedavariaveldoforms")); que vai fazer o array receber todos os dados que estão sendo passados, nesse caso pega os dados do forms e envia para servir como parametro no select pra ser selecionado só o que é igual a esse valor
             for(int i=0;i<lista.size();i=i+1){
             out.print("<tr>");
             out.print("<td>"+lista.get(i).getId()+"</td>");
             out.print("<td>"+lista.get(i).getNome()+"</td>");
             out.print("<td>"+lista.get(i).getEmail()+"</td>");
             out.print("<th><a href='alterar_cliente.jsp?id="+lista.get(i).getId()+"&nome="+lista.get(i).getNome()+"&email="+lista.get(i).getEmail()+"'>EDITAR</a></th>");
             out.print("<th><a href='excluir_cliente.jsp?id="+lista.get(i).getId()+"&nome="+lista.get(i).getNome()+"'>EXCLUIR</a></th>");
             out.print("</tr>");
          }
          }
          out.print("</table>");
        %>
    </body>
</html>
