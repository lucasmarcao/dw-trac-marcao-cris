<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="pt-br">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="https://wallpaperaccess.com/full/6354771.png" type="image/x-icon">
    <title>Fala ai !!!</title>
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
          <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="https://media.tribunadointerior.com.br/2021/06/bc01c031-1567425537-5d6d0424f03cb-utfpr.jpg"
                  class="d-block caroselfaleconosco" alt="1">
              </div>
              <div class="carousel-item">
                <img
                  src="https://especiais.gazetadopovo.com.br/wp-content/uploads/sites/22/2020/01/07065916/gazeta-do-povo-blog-concurseiros-utfpr-divulgacao-campo-mourao.jpg"
                  class="d-block caroselfaleconosco" alt="2">
              </div>
              <div class="carousel-item">
                <img src="midia/1ano.png" class="d-block caroselfaleconosco" alt="3">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-target="#carouselExampleControls"
              data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-target="#carouselExampleControls"
              data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </button>
          </div>
        </div>
        <hr>
        <form action="https://api.staticforms.xyz/submit" method="post" class="needs-validation" novalidate
          autocomplete="off">
          <input type="hidden" name="accessKey" value="970b682f-5c85-429e-9f1c-8f475cd6e43a">
          <input type="hidden" name="subject" value="Contato com dw.">
          <div class="card mb-3">
            <div class="row no-gutters">
              <div class="col-md-4 side-img">

              </div>
              <div class="col-md-8 side-txt">
                <div class="card-body">
                  <h5 class="card-title" style="color: whitesmoke;
                text-align: center;">Manda um Email pra noix !!!</h5>
                  <div class="form-row">
                    <div class="col">
                      <input type="text" name="$nome" class="form-control" placeholder="Nome" minlength="3" required>
                    </div>
                    <div class="col">
                      <input type="number" name="$idade" class="form-control" placeholder="Idade" min="1" required>
                    </div>
                  </div>
                  <div class="form-group">
                    <hr>
                    <input type="text" class="form-control" id="email"
                      pattern="[ a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-z.]{3,}$" name="$teuEmail"
                      placeholder="gmail de preferencia" required>
                    <div class="custom-control custom-switch">
                      <input type="checkbox" class="custom-control-input" name="$daUTF" id="utf">
                      <label class="custom-control-label" for="utf" style="color: wheat;">Sou da UTFPR</label>
                    </div>
                  </div>
                  <div class="form-group">
                    <hr>
                    <div class="mb-3">
                      <textarea class="form-control" name="$falaai" id="validationTextarea"
                        placeholder="Desabafa ai pra nois" rows="4" required></textarea>
                      <div class="invalid-feedback">
                        coloca mais coisa.
                      </div>
                    </div>

                  </div>
                  <input type="hidden" name="redirectTo" value="http://127.0.0.1:5500/faleconosco.jsp">
                  <div class="centro">
                    <br>
                    <button class="btn btn-danger" style="margin-right: 10px;">
                      Enviar
                    </button>
                    <button type="reset" class="btn btn-success">
                      Limpar
                    </button>
                  </div>
                </div>
              </div>
            </div>
        </form>
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