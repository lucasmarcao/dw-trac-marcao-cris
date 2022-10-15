/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOCargos;
import DAOs.DAOFuncionario;
import DAOs.DAOPessoa;
import static Entidades.Access.$Funcionario;
import Entidades.Funcionario;
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
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

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
            DAOFuncionario daoFuncionario = new DAOFuncionario();
            Funcionario funcionario = new Funcionario();
            DAOPessoa daoPessoa = new DAOPessoa();
            DAOCargos daoCargos = new DAOCargos();

            // udi.
            String funcao = request.getParameter("function");
            // variaveis
            Integer id = Integer.parseInt(request.getParameter("id"));
            // operaçoes.
            // buscar.

            if ("SEARCH".equals(funcao)) {
                try {
                    Integer i = Integer.parseInt(request.getParameter("id"));
                    Funcionario p = $Funcionario.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/funcionario/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/funcionario/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idfuncionario = Integer.valueOf(request.getParameter("id"));
                    Funcionario acom = $Funcionario.get(idfuncionario);
                    Integer idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
                    Integer idcargos = Integer.parseInt(request.getParameter("idcargos"));
                    Double salario = Double.parseDouble(request.getParameter("salario"));
                    Short trabalhando = Short.parseShort(request.getParameter("trabalhando"));

                    acom.setSalario(salario);
                    acom.setTrabalhando(trabalhando);
                    acom.setPessoaidpessoa(daoPessoa.obter(idpessoa));
                    acom.setCargosidcargos(daoCargos.obter(idcargos));
                    daoFuncionario.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/funcionario/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }

            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    funcionario = new Funcionario();
                    Integer idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
                    Integer idcargos = Integer.parseInt(request.getParameter("idcargos"));
                    Double salario = Double.parseDouble(request.getParameter("salario"));
                    Short trabalhando = Short.parseShort(request.getParameter("trabalhando"));

                    funcionario.setIdfuncionario(id);
                    funcionario.setSalario(salario);
                    funcionario.setTrabalhando(trabalhando);
                    funcionario.setPessoaidpessoa(daoPessoa.obter(idpessoa));
                    funcionario.setCargosidcargos(daoCargos.obter(idcargos));
                    daoFuncionario.inserir(funcionario);
                    response.sendRedirect("/dw2-marcao-cristofer/funcionario/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Funcionario.excluir($Funcionario.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/funcionario/index.jsp");
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
