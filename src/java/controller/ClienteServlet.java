/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOCliente;
import DAOs.DAOPessoa;
import static Entidades.Access.$Cliente;
import Entidades.Cliente;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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
            DAOCliente daoCliente = new DAOCliente();
            Cliente cliente = new Cliente();
            DAOPessoa daoPessoa = new DAOPessoa();
            // udi.
            String funcao = request.getParameter("function");
            // variaveis
            Integer id = Integer.parseInt(request.getParameter("id"));
            // operaçoes.
            // buscar.
            if ("SEARCH".equals(funcao)) {
                try {
                    Integer i = Integer.parseInt(request.getParameter("id"));
                    Cliente p = $Cliente.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/cliente/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/cliente/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idcliente = Integer.valueOf(request.getParameter("id"));
                    Cliente acom = $Cliente.get(idcliente);
                    Integer idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
                    Integer avaliacao = Integer.parseInt(request.getParameter("avaliacao"));
                    Integer totalCompras = Integer.parseInt(request.getParameter("compras"));
                    // mysql
                    acom.setTotalDeCompras(totalCompras);
                    acom.setAvaliacaoDoServico(avaliacao);
                    acom.setPessoaidpessoa(daoPessoa.obter(idpessoa));
                    daoCliente.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/cliente/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    cliente = new Cliente();
                    Integer idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
                    Integer avaliacao = Integer.parseInt(request.getParameter("avaliacao"));
                    Integer totalCompras = Integer.parseInt(request.getParameter("compras"));
                    // mysql
                    cliente.setIdcliente(id);
                    cliente.setAvaliacaoDoServico(avaliacao);
                    cliente.setTotalDeCompras(totalCompras);
                    cliente.setPessoaidpessoa(daoPessoa.obter(idpessoa));
                    daoCliente.inserir(cliente);
                    response.sendRedirect("/dw2-marcao-cristofer/cliente/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Cliente.excluir($Cliente.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/cliente/index.jsp");
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
