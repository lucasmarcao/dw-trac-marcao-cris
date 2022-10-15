/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOIngredientes;
import DAOs.DAOFornecedor;
import static Entidades.Access.$Ingredientes;
import Entidades.Ingredientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "IngredientesServlet", urlPatterns = {"/IngredientesServlet"})
public class IngredientesServlet extends HttpServlet {

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
            DAOIngredientes daoIngredientes = new DAOIngredientes();
            Ingredientes ingredientes = new Ingredientes();
            DAOFornecedor daoFornecedor = new DAOFornecedor();

            // udi.
            String funcao = request.getParameter("function");
            // variaveis
            Integer id = Integer.parseInt(request.getParameter("id"));
            // operaçoes.
            // buscar.

            if ("SEARCH".equals(funcao)) {
                try {
                    Integer i = Integer.parseInt(request.getParameter("id"));
                    Ingredientes p = $Ingredientes.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/ingredientes/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/ingredientes/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idingredientes = Integer.valueOf(request.getParameter("id"));
                    Ingredientes acom = $Ingredientes.get(idingredientes);
                    Integer idfornecedor = Integer.parseInt(request.getParameter("idfornecedor"));
                    String nome = request.getParameter("nome");
                    acom.setNome(nome);
                    acom.setFornecedoridfornecedor(daoFornecedor.obter(idfornecedor));
                    daoIngredientes.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/ingredientes/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }

            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    ingredientes = new Ingredientes();
                    Integer idfornecedor = Integer.parseInt(request.getParameter("idfornecedor"));
                    String nome = request.getParameter("nome");

                    ingredientes.setIdingredientes(id);
                    ingredientes.setNome(nome);
                    ingredientes.setFornecedoridfornecedor(daoFornecedor.obter(idfornecedor));
                    daoIngredientes.inserir(ingredientes);
                    response.sendRedirect("/dw2-marcao-cristofer/ingredientes/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Ingredientes.excluir($Ingredientes.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/ingredientes/index.jsp");
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
