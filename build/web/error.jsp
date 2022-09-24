<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="pt-br">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="https://wallpaperaccess.com/full/6354771.png" type="image/x-icon">
    <title>Erro !!!</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="css/menu.css">
    <link rel="stylesheet" href="css/defalt.css">
    <link rel="stylesheet" href="css/NpraM.css">
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
            <a class="nav-link" href="/adm.jsp">Menu <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/faleconosco.jsp">Fale Conosco</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
              Conta
            </a>
            <div class="dropdown-menu">
              <a class="dropdown-item" id="conta1" href="/conta/login.jsp">Login</a>
              <a class="dropdown-item" id="conta2" href="/conta/cadastro.jsp">Cadastrar</a>
            </div>
          </li>
        </ul>
      </div>
    </nav>
    <!-- fim da navbar -->

    <div class="centro">
      <main>
        <div class="centro">
          <h1> Deu ERRO !!!!</h1>
        </div>
        <hr>
        <div class="centro">
          <img class="img-logo"
            src="https://ichef.bbci.co.uk/news/640/amz/worldservice/live/assets/images/2015/09/26/150926165742__85730600_monkey2.jpg"
            alt="mamaco">
        </div>
        <div class="centro">
          O seu erro é o : {200 : Tudo Ok}
        </div>
        <hr>
        <!-- colapse -->
        <div class="accordion" id="accordionExample">
          <div class="card colapso">
            <div class="card-header" id="headingOne">
              <h2 class="mb-0">
                <button class="btn btn-link btn-block text-left colapse-btn" type="button" data-toggle="collapse"
                  data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                  Erro N : 404
                </button>
              </h2>
            </div>
            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
              <div class="card-body">
                Este erro ocorre quando a página não é encontrada.
                Verifique se sua <code>{URL}</code> esta correta.
              </div>
            </div>
          </div>
          <div class="card colapso">
            <div class="card-header" id="headingTwo">
              <h2 class="mb-0">
                <button class="btn btn-link btn-block text-left collapsed colapse-btn" type="button"
                  data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                  Erro N : 500
                </button>
              </h2>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
              <div class="card-body">
                Deu pau no Servidor, Provavelmente o <code>{Banco de dados}</code> caiu e é culpa do Marcão.
              </div>
            </div>
          </div>
          <div class="card colapso">
            <div class="card-header" id="headingThree">
              <h2 class="mb-0">
                <button class="btn btn-link btn-block text-left collapsed colapse-btn" type="button"
                  data-toggle="collapse" data-target="#collapseThree" aria-expanded="false"
                  aria-controls="collapseThree">
                  Erro N : 503
                </button>
              </h2>
            </div>
            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
              <div class="card-body">
                Verifique se o seu <code> {Wifi}</code> não está um lixo. ;)
              </div>
            </div>
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