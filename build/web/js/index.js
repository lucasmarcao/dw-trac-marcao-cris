console.log("BOM DIA \n \n");
try {
  let itens = document.querySelectorAll(".itens div").length;
  let itensFilho = itens / document.querySelectorAll(".itens").length;

  let item = document.querySelectorAll(".dado-item");
  console.log(
    "o tanto de div dentro de itens é = ",
    itens,
    "itens filho = ",
    itensFilho
  );
  let minhalista = [];
  let valorAltura = 0;
  let b = 0;
  for (let index = 0; index < item.length; index++) {
    b++;
    if (b <= 6) {
      if (item[index].clientHeight > valorAltura) {
        valorAltura = item[index].clientHeight;
        console.log(
          "id = ",
          index,
          "| a altura do maior item é = ",
          item[index].clientHeight
        );
      }
    }
    if (b == 6) {
      minhalista.push(valorAltura);
      console.info(minhalista);
      b = 0;
      valorAltura = 0;
    }
  }
  let contadorlista = 0;
  for (let index = 0; index < item.length; index++) {
    b++;
    if (b <= 6) {
      item[index].setAttribute(
        "style",
        "height: " + minhalista[contadorlista].toString() + "px"
      );
    }
    if (b == 6) {
      contadorlista++;
      b = 0;
    }
  }
} catch (error) {
  console.log(error);
}
console.log("BOM DIA \n \n");
try {
  let itens = document.querySelectorAll(".itens div").length;
  let itensFilho = itens / document.querySelectorAll(".itens").length;

  let item = document.querySelectorAll(".dado-item");
  console.log(
    "o tanto de div dentro de itens é = ",
    itens,
    "itens filho = ",
    itensFilho
  );
  let minhalista = [];
  let valorAltura = 0;
  let b = 0;
  for (let index = 0; index < item.length; index++) {
    b++;
    if (b <= itensFilho) {
      if (item[index].clientHeight > valorAltura) {
        valorAltura = item[index].clientHeight;
        console.log(
          "id = ",
          index,
          "| a altura do maior item é = ",
          item[index].clientHeight
        );
      }
    }
    if (b == itensFilho) {
      minhalista.push(valorAltura);
      console.info(minhalista);
      b = 0;
      valorAltura = 0;
    }
  }
  let contadorlista = 0;
  for (let index = 0; index < item.length; index++) {
    b++;
    if (b <= itensFilho) {
      item[index].setAttribute(
        "style",
        "height: " + minhalista[contadorlista].toString() + "px"
      );
    }
    if (b == itensFilho) {
      contadorlista++;
      b = 0;
    }
  }
} catch (error) {
  console.log(error);
}
