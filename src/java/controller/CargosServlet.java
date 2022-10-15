/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOCargos;
import static Entidades.Access.$Cargos;
import Entidades.Cargos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "CargosServlet", urlPatterns = {"/CargosServlet"})
public class CargosServlet extends HttpServlet {

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
            DAOCargos DAOCargos = new DAOCargos();
            Cargos cargos = new Cargos();

            // udi.
            String funcao = request.getParameter("function");
            // variaveis
            Integer id = Integer.parseInt(request.getParameter("id"));
            // operaçoes.
            // buscar.

            if ("SEARCH".equals(funcao)) {
                try {
                    Integer i = Integer.parseInt(request.getParameter("id"));
                    Cargos p = $Cargos.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/cargos/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/cargos/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idcargos = Integer.valueOf(request.getParameter("id"));
                    Cargos acom = $Cargos.get(idcargos);
                    String nome = request.getParameter("nome");
                    String descricao = request.getParameter("descricao");
                    acom.setNomecargo(nome);
                    acom.setDescricaoCargo(descricao);
                    DAOCargos.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/cargos/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }

            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    cargos = new Cargos();
                    String nome = request.getParameter("nome");
                    String desc = request.getParameter("descricao");
                    cargos.setIdcargos(id);
                    cargos.setNomecargo(nome);
                    cargos.setDescricaoCargo(desc);
                    DAOCargos.inserir(cargos);
                    response.sendRedirect("/dw2-marcao-cristofer/cargos/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Cargos.excluir($Cargos.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/cargos/index.jsp");
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
