/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.impl.ProductoDaoImpl;
import com.mapping.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
public class BuscarProductoAc extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nomproducto = request.getParameter("nomproducto");
        
        try {
            Thread.sleep(1000);
            /* TODO output your page here. You may use following sample code. */
            out.println(" <script type=\"text/javascript\">\n"
                    + "\n"
                    + "\n"
                    + "                                        $(document).ready(function() {\n"
                    + "                                            $('.editarproducto').click(function() {\n"
                    + "                                                var idpro = $(this).attr(\"name\");\n"
                    + "                                              \n"
                    + "                                                var dataString = 'idpro=' +idpro;"
                    + "\n"
                    + "                                                $.ajax({\n"
                    + "                                                    type: \"POST\",\n"
                    + "                                                    url: \"../ProductoController\",\n"
                    + "                                                    data: dataString,\n"
                    + "                                                    success: function(data) {\n"
                    + "                                                        //alert(data)\n"
                    + "\n"
                    + "                                                        $('#editarprod').html(data);\n"
                    + "\n"
                    + "                                                    }\n"
                    + "                                                });\n"
                    + "                                                //}\n"
                    + "\n"
                    + "                                            }\n"
                    + "\n"
                    + "\n"
                    + "                                            );\n"
                    + "                                        });\n"
                    + "                                    </script>");
            List res = null;
            ProductoDaoImpl dao = new ProductoDaoImpl();
            res = dao.getFiltro("", "Nocturno", nomproducto);

            Iterator itr = res.iterator();
            while (itr.hasNext()) {
                Producto p = (Producto) itr.next();
                // System.out.println(p.getIdProducto() + p.getNombre());
                p.setIdProducto(p.getIdProducto());

                //System.out.println(pre.getCosto());

                out.print("<li class='ui-state-default'><h4>" + p.getIdProducto() + " ------> " + p.getNombre() + " "+p.getTamano()+" "+p.getMedida()+" // $ "+p.getPrecio()+"  <a href=\"#\" name=\"" + p.getIdProducto() + "\" class=\"btn btn-primary editarproducto\"><samp style=\"color:black\">Editar</samp></a></h4></li>");

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(BuscarProductoAc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
