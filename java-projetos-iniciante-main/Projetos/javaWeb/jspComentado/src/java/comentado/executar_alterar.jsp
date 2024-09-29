<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>
<%-- você pode perceber que os metodos de crear,atualizar e deletar só usam os pacotes que você criou--%>
<%
  try{
    Cliente cli=new Cliente();//transporta a classe e instancia ela
    DAOCliente cld=new DAOCliente();//transporta a classe e instancia ela
    
    //inserir os valores da classe
    cli.setId(Integer.parseInt(request.getParameter("id")));//request.getParameter("nome da varivel name que foi passada pela sua pagina")->ele basicamente pega os dados do seu input que foi passado(os dados ficam na variavel name)
    cli.setNome(request.getParameter("nome"));//request.getParameter("nome da varivel name que foi passada pela sua pagina")->ele basicamente pega os dados do seu input que foi passado(os dados ficam na variavel name)
    cli.setEmail(request.getParameter("email"));//request.getParameter("nome da varivel name que foi passada pela sua pagina")->ele basicamente pega os dados do seu input que foi passado(os dados ficam na variavel name)
    //passa os dados pro metodo de alterar
    cld.atualizarCliente(cli);
       //responde pra pagina//volta pra ela//ou te leva pra essa pagina
    response.sendRedirect("consultar_clientes.jsp");
}catch(Exception erro){
    throw new RuntimeException("erro ao tranferir dados",erro);
}  



%>
