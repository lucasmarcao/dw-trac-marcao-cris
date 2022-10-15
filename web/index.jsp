<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="pt-br">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="https://ps.w.org/menu-image/assets/icon-128x128.png?rev=2123398"
      type="image/x-icon">
    <title>Menu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
  </head>

  <body class="scroll">
    <!-- navbar -->
    <nav class="navbar navbar-expand-lg navbar-light">
      <a class="navbar-brand" href="index.jsp">
        <img class="nav-img" src="midia/nav-gif.gif" alt="nav">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Menu <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="faleconosco.jsp">Fale Conosco</a>
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

    <h1>Pizza do Marcristopher</h1>
    <div class="centro master">
      <aside>
        <img src="midia/pizza-margherita.jpg" class="img-logo" alt="deusa-rara">
      </aside>
      <main>
        <div class="titulo-main">
          Recomendações:
        </div>
        <div class="caixa-main centro">
          <ul class="lista-main">
            <li class="lista-main-item">Pizza 4 Queijos</li>
            <li class="lista-main-item">Pizza Calabresa </li>
            <li class="lista-main-item">Pizza Chocolate Branco </li>
            <li class="lista-main-item">Pizza Baiana</li>
          </ul>
        </div>
        <div class="botoes-main">
          <div class="centro">
            <a class="botao-main">
              fazer pedido
            </a>
            <a class="botao-main">
              Ver Cardápio
            </a>
          </div>
        </div>
      </main>
    </div>

    <div class="centro">
      <div class="conteudo-extra">
        <h2>
          O que tem na nossa Web Page?
        </h2>
        <div class="card-group">
          <div class="card">
            <img src="https://cdn-icons-png.flaticon.com/512/2620/2620669.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Controle de conta</h5>
              <p class="card-text">Aqui é possivel tu fazer cadastro e login
                com seu email, com isso voce vai criar um perfil personalizavel
                e com cargos, seu cargo é controlado pelos ADMS do site.</p>
            </div>
            <div class="card-footer">
              <small class="text-muted">Area em Desenvolvimento.</small>
            </div>
          </div>
          <div class="card">
            <img src="https://cdn-icons-png.flaticon.com/512/1199/1199128.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Jsp e MySQL</h5>
              <p class="card-text">O sistema é feito a base de JSP, css, javascript e
                Servlet, nosso bd é o MySQL, um banco de dados relacional.</p>
            </div>
            <div class="card-footer">
              <small class="text-muted">Area em Desenvolvimento.</small>
            </div>
          </div>
          <div class="card">
            <img src="https://cdn-icons-png.flaticon.com/512/4919/4919646.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Alta Usabilidade.</h5>
              <p class="card-text">Esse sistema aqui vai ser usado tanto pelos
                clientes quanto pelos funcionários. Muitos componentes do
                mesmo são editáveis.</p>
            </div>
            <div class="card-footer">
              <small class="text-muted">Area em Desenvolvimento.</small>
            </div>
          </div>
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
    <script src="js/conta.js"></script>
    <script src="js/crud.js"></script>
    <script src="js/estilo.js"></script>
    <script src="js/index.js"></script>
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