/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOPizza;
import static Entidades.Access.$Pizza;
import Entidades.Pizza;
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
@WebServlet(name = "PizzaServlet", urlPatterns = {"/PizzaServlet"})
public class PizzaServlet extends HttpServlet {

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
            DAOPizza DAOPizza = new DAOPizza();
            Pizza pizza = new Pizza();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            // udi.
            String funcao = request.getParameter("function");
            // variaveis
            Integer id = Integer.parseInt(request.getParameter("id"));
            // operaçoes.
            // buscar.

            if ("SEARCH".equals(funcao)) {
                try {
                    Integer i = Integer.parseInt(request.getParameter("id"));
                    Pizza p = $Pizza.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/pizza/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/pizza/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idpizza = Integer.valueOf(request.getParameter("id"));
                    Pizza acom = $Pizza.get(idpizza);
                    String nome = request.getParameter("nome");
                    String sabor = request.getParameter("sabor");
                    Double preco = Double.parseDouble(request.getParameter("preco"));
                    String tamanho = request.getParameter("tamanho");
                    acom.setNomepizza(nome);
                    acom.setPreco(preco);
                    acom.setSabor(sabor);
                    acom.setTamanho(tamanho);
                    DAOPizza.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/pizza/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }

            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    pizza = new Pizza();
                    String nome = request.getParameter("nome");
                    String sabor = request.getParameter("sabor");
                    Double preco = Double.parseDouble(request.getParameter("preco"));
                    String tamanho = request.getParameter("tamanho");

                    pizza.setIdtable1(id);
                    pizza.setNomepizza(nome);
                    pizza.setPreco(preco);
                    pizza.setSabor(sabor);
                    pizza.setTamanho(tamanho);
                    DAOPizza.inserir(pizza);
                    response.sendRedirect("/dw2-marcao-cristofer/pizza/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Pizza.excluir($Pizza.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/pizza/index.jsp");
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
