/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOCliente;
import DAOs.DAOPedido;
import DAOs.DAOAcompanhamentos;
import static Entidades.Access.$Pedido;
import Entidades.Pedido;
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
@WebServlet(name = "PedidoServlet", urlPatterns = {"/PedidoServlet"})
public class PedidoServlet extends HttpServlet {

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
            DAOPedido daoPedido = new DAOPedido();
            Pedido pedido = new Pedido();
            DAOAcompanhamentos daoAcompanhamentos = new DAOAcompanhamentos();
            DAOCliente daoCliente = new DAOCliente();
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
                    Pedido p = $Pedido.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/pedido/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/pedido/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idpedido = Integer.valueOf(request.getParameter("id"));
                    Pedido acom = $Pedido.get(idpedido);
                    Integer idcliente = Integer.parseInt(request.getParameter("idcliente"));
                    Integer idacompanhamentos = Integer.parseInt(request.getParameter("idacompanhamentos"));
                    Short entregue = Short.parseShort(request.getParameter("entregue"));

                    acom.setDatapedido(simpleDateFormat.parse((request.getParameter("data"))));
                    acom.setEntregue(entregue);
                    acom.setAcompanhamentosidacompanhamentos(daoAcompanhamentos.obter(idacompanhamentos));
                    acom.setClienteIdcliente(daoCliente.obter(idcliente));
                    daoPedido.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/pedido/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }

            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    pedido = new Pedido();
                    Integer idcliente = Integer.parseInt(request.getParameter("idcliente"));
                    Integer idacompanhamentos = Integer.parseInt(request.getParameter("idacompanhamentos"));
                    Short entregue = Short.parseShort(request.getParameter("entregue"));
                    
                    pedido.setIdpedido(id);
                    pedido.setDatapedido(simpleDateFormat.parse((request.getParameter("data"))));
                    pedido.setEntregue(entregue);
                    pedido.setAcompanhamentosidacompanhamentos(daoAcompanhamentos.obter(idacompanhamentos));
                    pedido.setClienteIdcliente(daoCliente.obter(idcliente));
                    daoPedido.inserir(pedido);
                    response.sendRedirect("/dw2-marcao-cristofer/pedido/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Pedido.excluir($Pedido.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/pedido/index.jsp");
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
