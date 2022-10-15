/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOUser;
import static Entidades.Access.$User;
import Entidades.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DAOUser DAOUser = new DAOUser();
            User user = new User();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            // udi.
            String funcao = request.getParameter("function");
            // variaveis
            String email = request.getParameter("email");
            // operaçoes.
            // buscar.

            if ("SEARCH".equals(funcao)) {
                try {
                    String iemail = request.getParameter("email");
                    User p = $User.get(iemail);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/user/atualizar.jsp?id=" + iemail);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/user/adicionar.jsp?id=" + iemail);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer iduser = Integer.valueOf(request.getParameter("id"));
                    User acom = $User.get(iduser);
                    String nome = request.getParameter("nome");
                    String senha = request.getParameter("senha");
                    String cargo = request.getParameter("cargo");
                    acom.setNome(nome);
                    acom.setSenha(senha);
                    acom.setCargo(cargo);

                    DAOUser.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/user/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }

            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    user = new User();
                    String nome = request.getParameter("nome");
                    String senha = request.getParameter("senha");
                    String cargo = request.getParameter("cargo");

                    user.setEmail(email);
                    user.setNome(nome);
                    user.setSenha(senha);
                    user.setCargo(cargo);

                    DAOUser.inserir(user);
                    response.sendRedirect("/dw2-marcao-cristofer/user/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $User.excluir($User.get(email));
                    response.sendRedirect("/dw2-marcao-cristofer/user/index.jsp");
                } catch (Exception e) {

                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=Nao-Da-Pra-excluir-isso");
                }
            }
        } catch (Exception e) {
            response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
