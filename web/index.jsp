<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="pt-br">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="https://wallpaperaccess.com/full/6354771.png" type="image/x-icon">
    <title>Menu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="css/menu.css">
    <link rel="stylesheet" href="css/defalt.css">
  </head>

  <body>

    <!-- navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
          <li class="nav-item dropdown">
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

    <div class="centro">
      <main>
        <div class="centro">
          <img class="img-logo" src="midia/fundo-foda.png" alt="fundo-foda">
        </div>
        <div class="container">
          <div class="row descricao-index">
            <h1>Bem Vindo ao nosso Site amigos!!!</h1>
            <hr>
            <p>
              O objetivo do desse sistema é projetar um E-comerce de pizzaria
              que tem acesso a um banco de dados MySQL, uma interface bonita,
              ser funcional para o cliente e o administrador, e ter muitas outras
              funcionalidades além de vender pizzas.
            </p>
            <button class="col-12 btn btn-success btn-index">
              Fazer pedido
              <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" fill="currentColor" class="bi bi-cart3"
                viewBox="0 0 16 16">
                <path
                  d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
              </svg>
            </button>
          </div>
        </div>
      </main>
    </div>

    <!-- <aside>
    <div class="ad1">
      <img src="../midia/ad1.png" class="add-foto" alt="ad1">
    </div>
    <div class="ad2">
      <img src="../midia/ad4.png" class="add-foto" alt="ad2">
    </div>
  </aside>  -->

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



    <!-- ###
  codigos
  ### -->
    <script src="js/index.js"></script>
    <script src="js/estilo.js"></script>
    <script src="js/conta.js"></script>
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