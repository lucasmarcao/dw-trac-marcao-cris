<%@page import="static Entidades.Access.$Fornecedor" %>
<%@page import="Entidades.Fornecedor" %>
<%@page import="static Entidades.Access.$Acompanhamentos" %>
<%@page import="Entidades.Acompanhamentos" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="https://ps.w.org/menu-image/assets/icon-128x128.png?rev=2123398" type="image/x-icon">
        <title>atualizar CRUD !!!</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/index.css">
        <link rel="stylesheet" href="../css/crud.css">
    </head>

    <body class="scroll">
         <%
            Integer id = Integer.parseInt(request.getParameter("id"));
            Acompanhamentos acompanhamentos = $Acompanhamentos.get(id);
            String n1 = acompanhamentos.getNomeaconpanhamento();
            Integer n2 = Integer.parseInt(String.valueOf(acompanhamentos.getFornecedoridfornecedor()).split(" ")[0]);
        %>
        <!-- navbar -->
        <nav class="navbar navbar-expand-lg navbar-light">
            <a class="navbar-brand" href="../index.jsp">
                <img class="nav-img" src="../midia/nav-gif.gif" alt="nav">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="../index.jsp">Menu <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../faleconosco.jsp">Fale Conosco</a>
                    </li>
                    <li class="nav-item dropdown conta-nav">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                            Conta
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" id="conta1" href="conta/login.jsp">Login</a>
                            <a class="dropdown-item" id="conta2" href="conta/cadastro.jsp">Cadastrar</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- fim da navbar -->

        <form action="/dw2-marcao-cristofer/AcompanhamentosServlet" method="post" autocomplete="off">
            <h1>Atualizar Acompanhamentos</h1>
            <div class="centro master">
                <div class="segura-index">
                    <img
                        src="https://img.freepik.com/fotos-gratis/pizza-de-vista-lateral-com-pimenta-e-tomate-e-fatias-de-pizza-em-panelas-de-bordo_176474-3184.jpg?w=360"
                        class="img-index" alt="pizza">
                </div>
                <div id="formulario">
                    <div class="campo-top">
                        <button type="button" class="label-id">ID</button>
                        <input type="tel" name="id" id="id" oninput="mascaraId(this)" onpaste="return false" ondrop="return false"
                               onclick="controlaFalhasInputId()" value="<%=id%>" required>
                        <input type="hidden" value="SEARCH" id="opcao" name="function">
                        <button class="btn-buscar" id="buscar">
                            BUSCAR
                        </button>
                    </div>
                    
                    <div class="forms-brutos">
                        <button type="button" class="lb-defalt">NOME ACOMPANHAMENTOS</button>
                        <input class="input-dado" name="nome" type="text" minlength="3" maxlength="25" value="<%=n1%>" id="lb1" required disabled>
                    </div>
                    <div class="forms-brutos">
                        <button type="button" class="lb-defalt">FORNECEDOR</button>
                        <select type="text" name="idfornecedor" class="col-6 input-dado" id="lb2" required disabled>
                            <%for (Fornecedor fornecedor : $Fornecedor.result("all")) {%>
                            <option value="<%=fornecedor.getIdfornecedor()%>"  <%=(fornecedor.getIdfornecedor() == n2) ? "selected" : ""%> > 
                                <%=fornecedor.getIdfornecedor()%> -  {<%=fornecedor.getNomefornecedor()%>} 
                            </option>
                            <%}%>
                        </select>
                    </div>
                   

                </div>
                <div class="segura-index-2">
                    <img
                        src="https://st.depositphotos.com/1020618/2868/i/600/depositphotos_28687469-stock-photo-delicious-italian-pizza.jpg"
                        class="img-index-2" alt="pizza">
                </div>
            </div>

            <div class="centro">
                <div class="conteudo-extra">
                    <div class="flex">
                        <a class="botao-baixo-crud alterar" id="alterar" onclick="alterarBotao()">
                            atualizar
                        </a>
                    </div>
                    <div class="flex">
                        <a data-toggle="modal" data-target="#modal-excluir" id="excluir" onclick="excluirBotao()"
                           class="botao-baixo-crud excluir" id="excluir">
                            excluir
                        </a>
                    </div>
                    <div class="flex">
                        <button type="submit" class="botao-baixo-crud salvar" id="salvar">
                            salvar
                        </button>
                    </div>
                    <div class="flex">
                        <a href="index.jsp" class="botao-baixo-crud cancelar" id="cancelar">
                            cancelar
                        </a>
                    </div>
                    <div class="flex">
                        <a href="listar.jsp" class="botao-baixo-crud">
                            LISTAR
                        </a>
                    </div>
                    <div class="flex">
                        <a href="../adm.jsp" class="botao-baixo-crud">
                            VOLTAR PRO ADM
                        </a>
                    </div>
                </div>
            </div>
        </form>


        <!-- Modal excluir -->
        <form method="post" action="/dw2-marcao-cristofer/AcompanhamentosServlet" autocomplete="off">
            <div class="modal fade pai-modal" id="modal-excluir" data-backdrop="static" data-keyboard="false" tabindex="-1"
                 aria-labelledby="texto-exclusao" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content conteudo-modal">
                        <div class="modal-header titulo-modal">
                            <h5 class="modal-title" id="texto-exclusao">Deseja mesmo Excluir?</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true" class="x">&times;</span>
                            </button>
                        </div>
                        <input type="hidden" name="id" value="<%=id%>">
                        <input type="hidden" value="DELETE" name="function">
                        <div class="modal-body corpo-modal fundo-modal-foter">
                            <div class="modal-footer anti-borda">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-lg-6 col-sm-12 variavel centro">
                                            <input id="negado" type="submit" class="btn btn-warning" value="SIM">
                                        </div>
                                        <div class="col-lg-6 col-sm-12 variavel centro">
                                            <button id="confirmado" type="button" class="btn btn-danger" data-dismiss="modal">N??O</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-sm-12 text-footer">?? 2022 feito por Marc??o e Cris.</div>
                    <div class="col-lg-6 col-sm-12">
                        <div class="centro">
                            <img src="https://i.pinimg.com/originals/04/1c/2d/041c2d8031605a06c8976fac89bad54e.png" class="logo-footer"
                                 alt="logo">
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- scripts -->
        <script src="../js/conta.js"></script>
        <script src="../js/crud.js"></script>
        <script src="../js/estilo.js"></script>
        <script src="../js/index.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
                integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
                integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
        <!-- scripts -->
    </body>

</html>