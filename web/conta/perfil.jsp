<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="https://wallpaperaccess.com/full/6354771.png"
    type="image/x-icon">
  <title>Perfil</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="../css/menu.css">
  <link rel="stylesheet" href="../css/defalt.css">
</head>

<body>

  <!-- navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
            Conta
          </a>
          <div class="dropdown-menu">
            <a class="dropdown-item" id="conta1" href="login.jsp">Login</a>
            <a class="dropdown-item" id="conta2" href="cadastro.jsp">Cadastrar</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
  <!-- fim da navbar -->

  <div class="perfil">
    <div class="bolinha">
      <img class="foto-perfil" src="https://i.pinimg.com/474x/d9/4d/0e/d94d0e51ec2d07577eb64d1f1fb70b4c.jpg"
        alt="miseravel">
      <h5 class="user-name" id="usuarioname">
        Lucas Marcão
      </h5>
    </div>
    <div>
      <button class="btn btn-warning editar-perfil"> Editar Perfil
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen-fill"
          viewBox="0 0 16 16">
          <path
            d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z" />
        </svg>
      </button>
    </div>
    <div class="informacoes">

    </div>
  </div>

  <div class="centro">
    <main class="centro">
      <div class="card text-center fundo-azul">
        <div class="card-body">
          <h5 class="card-title"> Seu cargo é <code>{User}</code></h5>
          <p class="card-text">
            Tu tem acesso a essas Tabelas :
            <hr>
            pessoas / clientes / pedidos
          </p>
          <p class="card-text">
            Informações da sua conta:
            <hr>
            <span id="emailinfo">

            </span>
            <br>
            <span id="senhainfo">

            </span>
          </p>
          <a id="botaovazar" href="../index.jsp" class="btn btn-danger">
            Sair da conta
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-door-open"
              viewBox="0 0 16 16">
              <path d="M8.5 10c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z" />
              <path
                d="M10.828.122A.5.5 0 0 1 11 .5V1h.5A1.5 1.5 0 0 1 13 2.5V15h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V1.5a.5.5 0 0 1 .43-.495l7-1a.5.5 0 0 1 .398.117zM11.5 2H11v13h1V2.5a.5.5 0 0 0-.5-.5zM4 1.934V15h6V1.077l-6 .857z" />
            </svg>
          </a>
        </div>
      </div>
    </main>
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



  <!-- ###
  codigos
  ### -->
  <script src="../js/index.js"></script>
  <script src="../js/estilo.js"></script>
  <script src="../js/conta.js"></script>
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