/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOFornecedor;
import static Entidades.Access.$Fornecedor;
import Entidades.Fornecedor;
import java.io.IOException;
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
@WebServlet(name = "FornecedorServlet", urlPatterns = {"/FornecedorServlet"})
public class FornecedorServlet extends HttpServlet {

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
            DAOFornecedor daoFornecedor = new DAOFornecedor();
            Fornecedor fornecedor = new Fornecedor();
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
                    Fornecedor p = $Fornecedor.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/fornecedor/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/fornecedor/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idfornecedor = Integer.valueOf(request.getParameter("id"));
                    Fornecedor acom = $Fornecedor.get(idfornecedor);
                    String nome = request.getParameter("nome");
                    String porteEmpresa = request.getParameter("porteempresa");
                    // mysql
                    acom.setNomefornecedor(nome);
                    acom.setInicioDaParceria(simpleDateFormat.parse((request.getParameter("data"))));
                    acom.setPorteDaEmpresa(porteEmpresa);
                    daoFornecedor.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/fornecedor/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    fornecedor = new Fornecedor();
                    String nome = request.getParameter("nome");
                    String porteEmpresa = request.getParameter("porteempresa");
                    // mysql
                    fornecedor.setIdfornecedor(id);
                    fornecedor.setNomefornecedor(nome);
                    fornecedor.setInicioDaParceria(simpleDateFormat.parse((request.getParameter("data"))));
                    fornecedor.setPorteDaEmpresa(porteEmpresa);
                    daoFornecedor.inserir(fornecedor);
                    response.sendRedirect("/dw2-marcao-cristofer/fornecedor/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Fornecedor.excluir($Fornecedor.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/fornecedor/index.jsp");
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
