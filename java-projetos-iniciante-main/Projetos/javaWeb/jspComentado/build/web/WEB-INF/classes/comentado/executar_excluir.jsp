<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente" %>
<%-- você pode perceber que os metodos de crear,atualizar e deletar só usam os pacotes que você criou--%>
<%
   try{
       DAOCliente cliente=new DAOCliente();//transporta a classe e instancia ela
       int id=Integer.parseInt(request.getParameter("id"));//request.getParameter("nome da varivel name que foi passada pela sua pagina")->ele basicamente pega os dados do seu input que foi passado(os dados ficam na variavel name)
       cliente.deletar(id);//envia os dados pro metodo de deletar da classe
       out.print("cliente excluido");//printa excluido na pag
       out.print("<meta http-equiv='refresh' content='2, url=consultar_clientes.jsp'>");
                                  //    |        |                 |>>>>>>>>>>>>>>>>>>>|
                                  //    |        |                                     |
                        //atualiza a pagina   //tempo de atualização em segundos  //pág que ela vai ir
   }catch(Exception erro){
       throw new RuntimeException("erro na exclusão de dados",erro);
   }
%>
