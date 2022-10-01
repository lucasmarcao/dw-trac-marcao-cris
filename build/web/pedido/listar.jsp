<%@page import="static Entidades.Access.$Pedido" %>
<%@page import="Entidades.Pedido" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="https://wallpaperaccess.com/full/6354771.png"
              type="image/x-icon">
        <title>Listar !!!</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/defalt.css">
        <link rel="stylesheet" href="../css/list.css">
    </head>

    <body>
        <div class="centro">
            <div class="crud">
                <form method="post" autocomplete="off" class="cabeca" id="form">
                    <div class="corpo container">
                        <!-- Modal Listar-->
                        <div class="pai-modal" id="modal-listar">
                            <div class="caixa-lista">
                                <div class="modal-conteudo">
                                    <div class="modal-header titulo-modal">
                                        <h5 class="modal-titulo" id="staticBackdropLabel">Listando os Pedidos</h5>
                                        <a href="index.jsp" id="fechalista" class="close" data-dismiss="modal"
                                           aria-label="Close">
                                            <span aria-hidden="true" class="x">voltar</span>
                                        </a>
                                    </div>
                                    <div class="modal-corpo corpo-modal">
                                        <div class="demo">
                                            <div class="scroll" id="corpo-lista">
                                                <div class="cabeca-modal">
                                                    <div class="cabeca-item">
                                                        <h4>ID</h4>
                                                    </div>
                                                    <div class="cabeca-item" style="width: 220px">
                                                        <h4>CLIENTE</h4>
                                                    </div>
                                                    <div class="cabeca-item" style="width: 220px">
                                                        <h4> ACOMPANHAMENTOS
                                                        </h4>
                                                    </div>
                                                    <div class="cabeca-item">
                                                        <h4>DATA PEDIDO</h4>
                                                    </div>
                                                    <div class="cabeca-item">
                                                        <h4>ENTREGE</h4>
                                                    </div>
                                                </div>
                                               
                                                <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
                                                <%for (Pedido pedido : $Pedido.result("all")) {%>
                                                <div class="itens">
                                                    <div class="id-item dado-item" 
                                                         >
                                                        <%=pedido.getIdpedido()%>
                                                    </div>
                                                    <div class="dado-item" style="width: 220px">
                                                        <%=pedido.getClienteIdcliente()%>
                                                    </div>
                                                    <div class="dado-item" style="width: 220px">
                                                        <%=pedido.getAcompanhamentosidacompanhamentos()%>                                                                                                            
                                                    </div>
                                                    <div class="dado-item">
                                                        <%=df.format(pedido.getDatapedido())%>                                                        
                                                    </div>
                                                    <div class="dado-item">
                                                        <%=pedido.getEntregue()%>                                                        
                                                    </div>
                                                </div>
                                                <%}%>

                                            </div>
                                            <div class="modal-footer">
                                                <div class="centro">
                                                    <a href="../adm.jsp" class="btn btn-primary" 
                                                       style="width: 200px; font-size: 18px;
                                                       ">
                                                        Menu
                                                    </a>
                                                </div>
                                                <button type="button" class="btn btn-danger" data-dismiss="modal" disabled>
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                         class="bi bi-trash" viewBox="0 0 16 16">
                                                    <path
                                                        d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
                                                    <path fill-rule="evenodd"
                                                          d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
                                                    </svg>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </form>
            </div>
        </div>



        <!-- ###
        codigos
        ### -->
        <script src="../js/index.js"></script>
        <script src="../js/estilo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
                integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
                integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
    </body>

</html>