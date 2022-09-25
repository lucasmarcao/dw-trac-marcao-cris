// navbar

// fim da navbar

// cores foda

// background-color: #2B181E;
// background-gradient: #2B181E;
// link-color: #f9c440;
// link-hover-color: #d00;
// text-color: #c5b184;
// 3c212a fundo menores
window.onload = function () {
  try {
    let corpao= document.querySelector(".scroll");
    if (corpao.clientHeight <= 320) {
      let cab = document.querySelector(".cabeca-modal");
      cab.setAttribute("style","margin-left: 7px;")
      console.log(cab.clientHeight);
    }
  } catch (error) {
    console.log(error, "deus me ama")
  }
};
