/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOAcompanhamentos;
import DAOs.DAOFornecedor;
import static Entidades.Access.$Acompanhamentos;
import Entidades.Acompanhamentos;
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
@WebServlet(name = "PessoaServlet", urlPatterns = {"/PessoaServlet"})
public class PessoaServlet extends HttpServlet {

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
        String funcao = request.getParameter("function");
        DAOAcompanhamentos daoAcompanhamentos = new DAOAcompanhamentos();
        Acompanhamentos acompanhamentos = new Acompanhamentos();
        DAOFornecedor daoFornecedor = new DAOFornecedor();
        // udi.
        if ("UDI".equals(funcao)) {// Update, Delete, Insert
            String operacao = request.getParameter("operation");

            // variaveis
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer idfornecedor = Integer.parseInt(request.getParameter("idfornecedor"));
            String nome = request.getParameter("nome");

            int a = 0;
            // operaçoes.
            try {
                if ("UPDATE".equals(operacao)) {
                    acompanhamentos.setIdacompanhamentos(id);
                    acompanhamentos.setNomeaconpanhamento(nome);
                    acompanhamentos.setFornecedoridfornecedor(daoFornecedor.obter(idfornecedor));
                    daoAcompanhamentos.atualizar(acompanhamentos);
                }
                if ("INSERT".equals(operacao)) {
                    try {
                        acompanhamentos = new Acompanhamentos();
                        acompanhamentos.setIdacompanhamentos(id);
                        acompanhamentos.setNomeaconpanhamento(nome);
                        acompanhamentos.setFornecedoridfornecedor(daoFornecedor.obter(idfornecedor));
                        daoAcompanhamentos.inserir(acompanhamentos);
                    } catch (Exception e) {
                        a = 1;
                        response.sendRedirect("error.jsp");
                    }

                }
                if ("DELETE".equals(operacao)) {
                    $Acompanhamentos.excluir($Acompanhamentos.get(id));
                }
            } catch (IOException ex) {
                response.sendRedirect("index.jsp");
                // Lidar com as exceções aqui

            }
            if (a == 0) {
                response.sendRedirect("adm.jsp");
            }
        }
        // buscar.
        if ("SEARCH".equals(funcao)) {
            Integer i = Integer.parseInt(request.getParameter("id"));
            Acompanhamentos p = $Acompanhamentos.get(i);
            try {
                if (p != null) {
                    response.sendRedirect("dw2-marcao-cristofer/acompanhamentos/atualizar.jsp");
                } else {
                    response.sendRedirect("dw2-marcao-cristofer/acompanhamentos/adicionar.jsp");
                }
            } catch (Exception e) {
                response.sendRedirect("error.jsp");
            }

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
