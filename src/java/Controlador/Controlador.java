/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tareas;
import Modelo.TareasDAO;
import com.mysql.jdbc.SQLError;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hanss
 */

public class Controlador extends HttpServlet {
    Tareas nuevaTarea = new Tareas(); 
    TareasDAO tdao=new TareasDAO();
    int ide;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *"
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");    
        String accion=request.getParameter("accion");     
        switch (accion) {
            case "listar":
                List<Tareas> lista=tdao.cargar();
                request.setAttribute("listado", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "agregar":                
                String tarea=request.getParameter("tarea");               
                String txt=null;
                String msj=null;
                if (tarea != null && !tarea.trim().isEmpty()) {
                    nuevaTarea.setTarea(tarea);
                    tdao.agregar(nuevaTarea);  
                } else {
                    msj="danger";
                    txt="No ingreso la tarea";
                }
                request.setAttribute("tipo", msj);
                request.setAttribute("mensaje", txt);
                request.getRequestDispatcher("/Controlador?accion=listar").forward(request, response);
                break;
            case "actualizar":
                ide=Integer.parseInt(request.getParameter("id"));
                String t_check=request.getParameter("tarea_check");         
                t_check = "0".equals(t_check) ? "1" : "0";               
                nuevaTarea.setCompletado(t_check);
                nuevaTarea.setId(ide);
                tdao.actualizar(nuevaTarea);
                request.getRequestDispatcher("/Controlador?accion=listar").forward(request, response);
                break;
            case "eliminar":
                ide=Integer.parseInt(request.getParameter("id"));
                nuevaTarea.setId(ide);
                tdao.eliminar(nuevaTarea);               
                request.getRequestDispatcher("/Controlador?accion=listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
                   
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
