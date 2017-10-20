/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.daoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import net.sf.json.JSONObject;

/**
 *
 * @author skriom
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    private HttpServletRequest varRequest = null;
    private HttpServletResponse varResponse = null;
    private PrintWriter varOut = null;
    private HttpSession varSession = null;
    private daoUsuario daoUsuario = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        daoUsuario=new daoUsuario();
        try {
            response.setContentType("txt/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            varRequest = request;
            varResponse = response;
            varSession = request.getSession();
            varOut = varResponse.getWriter();
            if (varRequest.getParameter("action").equals("list")) {
                list();
            } else if (varRequest.getParameter("action").equals("create")) {
                create();
            } else if (varRequest.getParameter("action").equals("update")) {
                update();
            } else if (varRequest.getParameter("action").equals("delete")) {
                delete();
            }
            varOut.close();
        } catch (SQLException e) {

        }
    }

    private void list() throws SQLException {
        int jtStartIndex = Integer.parseInt(varRequest.getParameter("jtStartIndex"));
        String jtSorting = varRequest.getParameter("jtSorting");
        int jtPageSize = Integer.parseInt(varRequest.getParameter("jtPageSize"));
        JSONObject varJObjectLista = daoUsuario.select(jtStartIndex, jtPageSize, jtSorting);
        varOut.print(varJObjectLista);
    }

    public boolean esNumero(String texto) {
        boolean es = false;
        try {
            Integer.parseInt(texto);
            es = true;
        } catch (Exception e) {
            es = false;
        }
        return es;
    }

    private void create() throws SQLException {
        Usuario dat = new Usuario();
        dat.setUsuario(varRequest.getParameter("Usuario"));
        dat.setPassword(varRequest.getParameter("Password"));
        dat.setNombre(varRequest.getParameter("Nombre"));
        JSONObject varJObjectNuevoRegistro = daoUsuario.insert(dat);
        varOut.print(varJObjectNuevoRegistro);
    }

    private void update() throws SQLException {
        Usuario dat = new Usuario();
        dat.setIdUsuario(Integer.parseInt(varRequest.getParameter("IdUsuario").trim()));
        dat.setUsuario(varRequest.getParameter("Usuario"));
        dat.setPassword(varRequest.getParameter("Password"));
        dat.setNombre(varRequest.getParameter("Nombre"));
        JSONObject varJObjectNuevoRegistro = daoUsuario.update(dat);
        varOut.print(varJObjectNuevoRegistro);
    }

    private void delete() throws SQLException {
        String IdUsuario = varRequest.getParameter("IdUsuario").trim();
        JSONObject varJObjectLista = daoUsuario.delete(IdUsuario);
        varOut.print(varJObjectLista);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
