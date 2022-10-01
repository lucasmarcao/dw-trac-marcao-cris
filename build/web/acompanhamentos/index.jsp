<%@page import="static Entidades.Access.$Fornecedor" %>
<%@page import="Entidades.Fornecedor" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="https://wallpaperaccess.com/full/6354771.png" type="image/x-icon">
        <title>Bem vindo !!!</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/defalt.css">
    </head>

    <body>
        <div class="crud">
            <form method="post" action="/dw2-marcao-cristofer/AcompanhamentosServlet" autocomplete="off" class="cabeca" id="form">
                <label for="id" class="id-label">ID</label></label>
                <input type="tel" class="campo input" name="id" id="id" oninput="mascaraId(this)" onpaste="return false"
                       ondrop="return false" onclick="controlaFalhasInputId()" required>
                <div class="centraliza">
                    <input type="hidden" value="SEARCH" id="opcao" name="function"> <button type="submit" onclick="buscarBotao()" class="campo botao buscar" id="buscar">buscar</button>
                </div>
                <div class="centraliza">
                    <a href="listar.jsp">
                        <button type="button" class="btn campo botao listar" id="listar">listar</button>
                    </a>
                </div>
                <div class="corpo container">
                    <div class="linha row">
                        <div class="col-6 label-dado">Nome Acompanhamentos</div>
                        <input type="text" name="nome" class="col-6 input-dado" id="lb2" min="1" maxlength="20" required disabled>
                    </div>

                    <div class="linha row">
                        <div class="col-6 label-dado">Fornecedor</div>
                        <select type="text" name="idfornecedor" class="col-6 input-dado" id="lb4" required disabled>
                            <%for (Fornecedor fornecedor : $Fornecedor.result("all")) {%>
                            <option value="<%=fornecedor.getIdfornecedor()%>"> <%=fornecedor.getIdfornecedor()%> -  {<%=fornecedor.getNomefornecedor()%>} </option>
                            <%}%>
                        </select>
                    </div>
                </div>
            </form>
            <div class="centro">
                <a href="../adm.jsp" class="btn btn-primary" style="width: 300px; font-size: 20px;
                   ">
                    Menu
                </a>
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