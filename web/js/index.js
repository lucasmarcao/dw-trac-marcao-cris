// validação de form
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
  "use strict";
  window.addEventListener(
    "load",
    function () {
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.getElementsByClassName("needs-validation");
      // Loop over them and prevent submission
      var validation = Array.prototype.filter.call(forms, function (form) {
        form.addEventListener(
          "submit",
          function (event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add("was-validated");
          },
          false
        );
      });
    },
    false
  );
})();

// botões
let buscar = document.getElementById("buscar");
let adcionar = document.querySelector(".adcionar");
let excluir = document.querySelector(".excluir");
let alterar = document.querySelector(".alterar");
let listar = document.getElementById("listar");
let salvar = document.getElementById("salvar");
let cancelar = document.getElementById("cancelar");
// valor dos botões.

// Valores de entrada || dados
let entradaId = document.getElementById("id");
let inputDado = document.querySelectorAll(".input-dado");
// action

let opcao = document.getElementById("opcao");
// adicionar
function adcionarBotao() {
  //controla os botãoes que podem aparecer.
  buscar.style.display = "none";
  adcionar.setAttribute("style", "display: none !important;");
  salvar.style.display = "inline";
  cancelar.style.display = "inline";

  //controla os inputs que podem ser digitados.
  //reabilita o botão Salvar.
  salvar.removeAttribute("disabled");
  entradaId.style.color = "gray";
  // Estiliza os inputs.
  entradaId.setAttribute("readonly","true");
  opcao.value = "INSERT";
  try {
    inputDado.item(0).removeAttribute("disabled");
    inputDado.item(0).setAttribute("style", "background: white;");
    inputDado.item(1).removeAttribute("disabled");
    inputDado.item(1).setAttribute("style", "background: white;");
    inputDado.item(2).removeAttribute("disabled");
    inputDado.item(2).setAttribute("style", "background: white;");
    inputDado.item(3).removeAttribute("disabled");
    inputDado.item(3).setAttribute("style", "background: white;");
    inputDado.item(4).removeAttribute("disabled");
    inputDado.item(4).setAttribute("style", "background: white;");
  } catch (error) {
    console.log("quero é secsu");
  }
}

//alterar
function alterarBotao() {
  //controla os botãoes que podem aparecer.
  buscar.style.display = "none";
  alterar.setAttribute("style", "display: none !important;");
  excluir.setAttribute("style", "display: none !important;");
  salvar.style.display = "inline";
  cancelar.style.display = "inline";

  //controla os inputs que podem ser digitados.
  //reabilita o botão Salvar.
  salvar.removeAttribute("disabled");
  // Estiliza os inputs.
  entradaId.style.color = "gray";
  entradaId.setAttribute("readonly","true");
  opcao.value = "UPDATE";
  try {
    inputDado.item(0).removeAttribute("disabled");
    inputDado.item(0).setAttribute("style", "background: white;");
    inputDado.item(1).removeAttribute("disabled");
    inputDado.item(1).setAttribute("style", "background: white;");
    inputDado.item(2).removeAttribute("disabled");
    inputDado.item(2).setAttribute("style", "background: white;");
    inputDado.item(3).removeAttribute("disabled");
    inputDado.item(3).setAttribute("style", "background: white;");
    inputDado.item(4).removeAttribute("disabled");
    inputDado.item(4).setAttribute("style", "background: white;");
  } catch (error) {
    console.log("busco coito");
  }
}

// excluir
function excluirBotao() {
  // essa constante é o texto do MODAL.
  const textoExclui = document.getElementById("texto-exclusao");

  // Mensagem enviada para o texto do modal.
  textoExclui.innerHTML =
    "Deseja excluir o item de id  : <br> [ " +
    entradaId.value +
    " ]. E de nome : <br> {  " +
    inputDado.item(0).value +
    "  } ?";
}
// buscar
function buscarBotao() {
  console.log("tu apertou o botao buscar");
  opcao.value = "SEARCH";
}

// cria input
function criaInput() {
  //   <div class="linha row">
  //      <input type="number" name="lb3" class="col-6 input-dado" id="lb3" min="1" maxlength="24" required disabled>
  //      <input type="number" name="lb4" class="col-6 input-dado" id="lb4" min="1" maxlength="24" required disabled>
  //   </div>

  let linhaRow = document.createElement("div");
  linhaRow.setAttribute("class", "linha row");
  let lb3input = document.createElement("input");
  let lb4input = document.createElement("input");
  lb3input.setAttribute("class", "col-6 input-dado");
  lb4input.setAttribute("class", "col-6 input-dado");
  lb3input.setAttribute("id", "lb3");
  lb3input.setAttribute("id", "lb4");
  linhaRow.insertAdjacentElement("beforeend", lb3input);
  linhaRow.insertAdjacentElement("beforeend", lb4input);

  let iduau = document.getElementById("uau");
  // adiciona o novo elemento criado e seu conteúdo ao DOM
  let corpoNpraM = document.getElementById("corpoNpraM");
  corpoNpraM.insertAdjacentElement("beforeend", linhaRow);
}