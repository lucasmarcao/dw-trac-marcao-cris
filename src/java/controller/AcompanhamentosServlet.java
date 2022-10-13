/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOAcompanhamentos;
import DAOs.DAOFornecedor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static Entidades.Access.$Acompanhamentos;
import Entidades.Acompanhamentos;
import java.io.File;
import static java.lang.System.out;
import javax.servlet.http.Cookie;
import org.apache.commons.httpclient.HttpStatus;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AcompanhamentosServlet", urlPatterns = {"/AcompanhamentosServlet"})
public class AcompanhamentosServlet extends HttpServlet {

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
            DAOAcompanhamentos daoAcompanhamentos = new DAOAcompanhamentos();
            Acompanhamentos acompanhamentos = new Acompanhamentos();
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
                    Acompanhamentos p = $Acompanhamentos.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/acompanhamentos/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/acompanhamentos/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idacompanhamentos = Integer.valueOf(request.getParameter("id"));
                    Acompanhamentos acom = $Acompanhamentos.get(idacompanhamentos);
                    Integer idfornecedor = Integer.parseInt(request.getParameter("idfornecedor"));
                    String nome = request.getParameter("nome");
                    acom.setNomeaconpanhamento(nome);
                    acom.setFornecedoridfornecedor(daoFornecedor.obter(idfornecedor));
                    daoAcompanhamentos.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/acompanhamentos/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }

            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    acompanhamentos = new Acompanhamentos();
                    Integer idfornecedor = Integer.parseInt(request.getParameter("idfornecedor"));
                    String nome = request.getParameter("nome");

                    acompanhamentos.setIdacompanhamentos(id);
                    acompanhamentos.setNomeaconpanhamento(nome);
                    acompanhamentos.setFornecedoridfornecedor(daoFornecedor.obter(idfornecedor));
                    daoAcompanhamentos.inserir(acompanhamentos);
                    response.sendRedirect("/dw2-marcao-cristofer/acompanhamentos/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Acompanhamentos.excluir($Acompanhamentos.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/acompanhamentos/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
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
