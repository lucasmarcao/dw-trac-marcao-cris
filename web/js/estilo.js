// cores foda

// background-color: #2B181E;
// background-gradient: #2B181E;
// link-color: #f9c440;
// link-hover-color: #d00;
// text-color: #c5b184;
// 3c212a fundo menores
// corrige o listar
window.onload = function () {
  try {
    let corpao = document.querySelector(".scroll");
    if (corpao.clientHeight <= 320) {
      let cab = document.querySelector(".cabeca-modal");
      cab.setAttribute("style", "margin-left: 7px;");
      console.log(cab.clientHeight);
    }
  } catch (error) {
    console.log(error, "deus me ama");
  }
};
let enter = document.getElementById("id");
if (document.body.contains(enter)) {
  console.log("o input id existe aqui");
  document.getElementById("id").onkeypress = function (e) {
    var chr = String.fromCharCode(e.which);
    if ("1234567890".indexOf(chr) < 0) return false;
  };
  //deixa digitar apenas numeros.
  function mascaraId(n) {
    let c = n.value;

    if (
      "0" != c[c.length - 1] &&
      "1" != c[c.length - 1] &&
      "2" != c[c.length - 1] &&
      "3" != c[c.length - 1] &&
      "4" != c[c.length - 1] &&
      "5" != c[c.length - 1] &&
      "6" != c[c.length - 1] &&
      "7" != c[c.length - 1] &&
      "8" != c[c.length - 1] &&
      "9" != c[c.length - 1]
    ) {
      // impede entrar outro caractere que não seja número
      n.value = c.substring(0, c.length - 1);
      return;
    }
    // delimita o maximo de caracteres no Input
    n.setAttribute("maxlength", "5");
  }

  // controla uma possivel vulnerabilidade do Sistema.
  function controlaFalhasInputId() {
    let adcionar = document.getElementById("adcionar");
    let excluir = document.getElementById("excluir");
    let alterar = document.getElementById("alterar");
    if (document.body.contains(adcionar)) {
      adcionar.remove();
      console.log("pagina adcionar");
    }
    if (document.body.contains(alterar)) {
      alterar.remove(); // botão Alterar some
      excluir.remove(); // botão excluir some
      console.log("pagina alterar");
    }
  }
} else {
  console.log("o input id NAO existe aqui");
}
