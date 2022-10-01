<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="https://wallpaperaccess.com/full/6354771.png"
    type="image/x-icon">
  <title>Atualizar</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="../css/forms.css">
  <link rel="stylesheet" href="../css/defalt.css">
  <link rel="stylesheet" href="../css/modals.css">
</head>

<body>
  <div class="crud">
    <form method="post" autocomplete="off" class="cabeca" id="form">
      <label for="id" class="id-label">ID</label></label>
      <input type="tel" class="campo input" name="id" id="id" oninput="mascaraId(this)" onpaste="return false"
        ondrop="return false" onclick="controlaFalhasInputId()" required>
      <div class="centraliza">
        <input type="hidden" value="SEARCH" id="opcao" name="function"> <button type="submit" onclick="buscarBotao()" class="campo botao buscar" id="buscar">buscar</button>
        <button type="button" onclick="alterarBotao()" class="campo botao alterar" id="alterar">alterar</button>
      </div>
      <div class="centraliza">
        <a href="listar.jsp">
          <button type="button" class="btn campo botao listar" id="listar">listar</button>
        </a>
        <button type="button" class="campo botao excluir" data-toggle="modal" data-target="#modal-excluir" id="excluir"
        onclick="excluirBotao()">excluir</button>
      </div>
      <div class="centraliza">
        <button type="submit" onclick="salvarBotao()" class="campo botao salvar" id="salvar">salvar</button>
        <a href="index.jsp">
          <button type="button" class="campo botao cancelar" id="cancelar">cancelar</button>
        </a>
      </div>
      <div class="corpo container">
        <div class="linha row">
          <div class="col-6 label-dado">nome</div>
          <input type="text" name="lb1" class="col-6 input-dado" id="lb1" minlength="3" maxlength="24" required
            disabled>
        </div>
        <div class="linha row">
          <div class="col-6 label-dado">sabor</div>
          <select type="text" name="lb2" class="col-6 input-dado" id="lb2" required disabled>
            <option value="Salgado"> Salgado </option>
            <option value="Doce"> Doce</option>
            <option value="agridoce"> Agridoce</option>
          </select>
        </div>
        <div class="linha row">
          <div class="col-6 label-dado">preço</div>
          <input type="number" name="lb3" class="col-6 input-dado" min="0" id="lb3" maxlength="20" required disabled>
        </div>
        <div class="linha row">
          <div class="col-6 label-dado">tamanho</div>
          <select type="text" name="lb4" class="col-6 input-dado" id="lb4" required disabled>
            <option value="pequeno"> 8 pedaços </option>
            <option value="medio"> 12 pedaços</option>
          </select>
        </div>

      </div>
    </form>
    <div class="centro">
      <a href="../adm.jsp" class="btn btn-primary" 
      style="width: 300px; font-size: 20px;
      ">
        Menu
      </a>
    </div>
  </div>


   <!-- Modal excluir -->
   <div class="modal fade pai-modal" id="modal-excluir" data-backdrop="static" data-keyboard="false" tabindex="-1"
   aria-labelledby="texto-exclusao" aria-hidden="true">
   <div class="modal-dialog">
     <div class="modal-content">
       <div class="modal-header titulo-modal">
         <h5 class="modal-title" id="texto-exclusao">Deseja mesmo Excluir?</h5>
         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
           <span aria-hidden="true" class="x">&times;</span>
         </button>
       </div>
       <div class="modal-body corpo-modal">
         <div class="modal-footer">
           <div class="container">
             <div class="row">
               <div class="col-lg-6 col-sm-12 variavel">
                 <button id="negado" type="button" class="btn btn-warning" data-dismiss="modal"
                   onclick="confirmadoExluir()">SIM</button>
               </div>
               <div class="col-lg-6 col-sm-12 variavel">
                 <button id="confirmado" type="button" class="btn btn-danger" data-dismiss="modal">NÃO</button>
               </div>
             </div>
           </div>
         </div>
       </div>
     </div>
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