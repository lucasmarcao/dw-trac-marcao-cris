package controller;

import static Entidades.Access.$Pet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.Pet;

public class PetServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String funcao = request.getParameter("function");

        // udi.
        if ("UDI".equals(funcao)) {// Update, Delete, Insert
            String operacao = request.getParameter("operation");

            // variaveis
            Integer id = Integer.parseInt(request.getParameter("id"));
            int idade = Integer.parseInt(request.getParameter("idade"));
            String nome = request.getParameter("nome");
            String especie = request.getParameter("especie");
            String tutor = request.getParameter("tutor");
            int a = 0;
            // operaçoes.
            try {
                if ("UPDATE".equals(operacao)) {
                    Pet pet = $Pet.get(id);
                    pet.setEspecie(especie);
                    pet.setIdade(idade);
                    pet.setNome(nome);
                    pet.setTutor(tutor);
                    $Pet.atualizar(pet);
                }
                if ("INSERT".equals(operacao)) {
                    try {
                        $Pet.adicionar(new Pet(id, nome, especie, idade, tutor));
                    } catch (Exception e) {
                        a = 1;
                        response.sendRedirect("mensagemErro.jsp?message=erro-ao-inserir&redir=menu");
                    }

                }
                if ("DELETE".equals(operacao)) {
                    $Pet.excluir($Pet.get(id));
                }
            } catch (IOException ex) {
                response.sendRedirect("index.jsp");
                // Lidar com as exceções aqui

            }
            if (a == 0) {
                response.sendRedirect("menu.jsp");
            }
        }
        // buscar.
        if ("SEARCH".equals(funcao)) {
            Integer i = Integer.parseInt(request.getParameter("id"));
            Pet p = $Pet.get(i);
            if (p != null) {
                response.sendRedirect("alterar.jsp?id=" + i);
            } else {
                response.sendRedirect("mensagemErro.jsp?message=pet-nao-encontrado&redir=menu");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "descricao";
    }// </editor-fold>

}
