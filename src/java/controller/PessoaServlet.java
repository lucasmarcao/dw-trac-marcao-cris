/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAOs.DAOAcompanhamentos;
import DAOs.DAOPessoa;
import DAOs.DAOFornecedor;
import static Entidades.Access.$Acompanhamentos;
import static Entidades.Access.$Pessoa;
import Entidades.Acompanhamentos;
import Entidades.Pessoa;
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
        try {
            DAOPessoa DAOPessoa = new DAOPessoa();
            Pessoa pessoa = new Pessoa();
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
                    Pessoa p = $Pessoa.get(i);
                    if (p != null) {
                        response.sendRedirect("/dw2-marcao-cristofer/pessoa/atualizar.jsp?id=" + i);
                    } else {
                        response.sendRedirect("/dw2-marcao-cristofer/pessoa/adicionar.jsp?id=" + i);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // atualizar
            if ("UPDATE".equals(funcao)) {
                try {
                    Integer idpessoa = Integer.valueOf(request.getParameter("id"));
                    Pessoa acom = $Pessoa.get(idpessoa);
                    String nome = request.getParameter("nome");
                    Double altura = Double.parseDouble(request.getParameter("altura"));
                    String cpf = request.getParameter("cpf");
                    String cep = request.getParameter("cep");
                    acom.setNome(nome);
                    acom.setAltura(altura);
                    acom.setCpf(cpf);
                    acom.setCep(cep);
                    acom.setDatanascimento(simpleDateFormat.parse((request.getParameter("data"))));
                    DAOPessoa.atualizar(acom);
                    response.sendRedirect("/dw2-marcao-cristofer/pessoa/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }

            }
            // inserir
            if ("INSERT".equals(funcao)) {
                try {
                    pessoa = new Pessoa();
                    String nome = request.getParameter("nome");
                    Double altura = Double.parseDouble(request.getParameter("altura"));
                    String cpf = request.getParameter("cpf");
                    String cep = request.getParameter("cep");

                    pessoa.setIdpessoa(id);
                    pessoa.setNome(nome);
                    pessoa.setAltura(altura);
                    pessoa.setCpf(cpf);
                    pessoa.setCep(cep);
                    pessoa.setDatanascimento(simpleDateFormat.parse((request.getParameter("data"))));
                    DAOPessoa.inserir(pessoa);
                    response.sendRedirect("/dw2-marcao-cristofer/pessoa/index.jsp");
                } catch (Exception e) {
                    response.sendRedirect("/dw2-marcao-cristofer/error.jsp?desc=" + e);
                }
            }
            // deletar
            if ("DELETE".equals(funcao)) {
                try {
                    $Pessoa.excluir($Pessoa.get(id));
                    response.sendRedirect("/dw2-marcao-cristofer/pessoa/index.jsp");
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
