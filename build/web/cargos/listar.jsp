<%@page import="static Entidades.Access.$Cargos" %>
    <%@page import="Entidades.Cargos" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html lang="pt-br">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="shortcut icon" href="https://ps.w.org/menu-image/assets/icon-128x128.png?rev=2123398"
                    type="image/x-icon">
                <title>Listar !!!</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
                    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
                    crossorigin="anonymous">
                <link rel="stylesheet" href="../css/index.css">
                <link rel="stylesheet" href="../css/crud.css">
                <link rel="stylesheet" href="../css/default.css">
                <link rel="stylesheet" href="../css/list.css">
            </head>

            <body class="scroll">
                <!-- navbar -->
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="../index.jsp">
                        <img class="nav-img" src="../midia/nav-gif.gif" alt="nav">
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
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
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                                    aria-expanded="false">
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

                <h1>Listar os Cargos</h1>

                <div class="centro">
                    <div class="listao">
                        <form method="post" autocomplete="off" class="cabeca" id="form">
                            <div class="corpo container">
                                <!-- Modal Listar-->
                                <div class="pai-modal" id="modal-listar">
                                    <div class="caixa-lista">
                                        <div class="modal-conteudo">

                                            <div class="modal-corpo corpo-modal">
                                                <div class="demo centro">
                                                    <div class="scroll-lista" id="corpo-lista">
                                                        <div class="cabeca-modal">
                                                            <div class="cabeca-item">
                                                                <h4>ID CARGO</h4>
                                                            </div>
                                                            <div class="cabeca-item">
                                                                <h4>NOME CARGO</h4>
                                                            </div>
                                                            <div class="cabeca-item">
                                                                <h4> DESCRIÇÃO CARGO
                                                                </h4>
                                                            </div>
                                                        </div>

                                                        <%for (Cargos cargos : $Cargos.result("all")) {%>
                                                            <div class="itens">
                                                                <div class="id-item dado-item">
                                                                    <%=cargos.getIdcargos()%>
                                                                </div>
                                                                <div class="dado-item">
                                                                    <%=cargos.getNomecargo()%>
                                                                </div>
                                                                <div class="dado-item">
                                                                    <%=cargos.getDescricaoCargo()%>
                                                                </div>
                                                            </div>
                                                            <%}%>
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


                <div class="centro">
                    <img class="img-listar"
                        src="https://png.pngtree.com/thumb_back/fw800/back_our/20190621/ourmid/pngtree-pizza-color-art-banner-image_195261.jpg"
                        alt="">
                </div>

                <div class="centro">
                    <div class="conteudo-extra">
                        <div class="flex">
                            <a href="index.jsp" class="botao-baixo-crud">
                                VOLTAR
                            </a>
                        </div>
                        <div class="flex">
                            <a href="../adm.jsp" class="botao-baixo-crud">
                                VOLTAR PRO ADM
                            </a>
                        </div>
                    </div>
                </div>

                <footer>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 col-sm-12 text-footer">© 2022 feito por Marcão e Cris.</div>
                            <div class="col-lg-6 col-sm-12">
                                <div class="centro">
                                    <img src="https://i.pinimg.com/originals/04/1c/2d/041c2d8031605a06c8976fac89bad54e.png"
                                        class="logo-footer" alt="logo">
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