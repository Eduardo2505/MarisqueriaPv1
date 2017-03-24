/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessiones;

import com.dao.impl.AltadiaDaoImpl;
import com.dao.impl.EmpleadoDaoImpl;
import com.mapping.Altadia;
import com.mapping.Empleado;
import com.mapping.Puesto;
import com.util.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Eduardopc
 */
public class Entrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email").trim();
        String pass = request.getParameter("pass");
        try {
           // Thread.sleep(400);
            EmpleadoDaoImpl dao = new EmpleadoDaoImpl();
            Empleado empleado = new Empleado();
            empleado.setMail(email);          
            empleado.setPassEmail(pass);
            empleado = dao.Login(empleado);
            System.out.println(empleado);
            if (empleado != null) {

                Puesto pu = new Puesto();

                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    pu = empleado.getPuesto();
                   
                    int idpuesto = pu.getIdpuesto();
                    
                    if ( idpuesto==1 || idpuesto==2|| idpuesto==3|| idpuesto==8|| idpuesto==22) {
                         String puesto = pu.getTipo();
                         HttpSession sesion = request.getSession();
                        //AltadiaDaoImpl daoDi = new AltadiaDaoImpl();
                       // Altadia dia = new Altadia();
                        //dia = daoDi.bucar();
                        //try {
                           // String idBarra="BarraReportes";
                            sesion.setAttribute("puesto", puesto);
                            sesion.setAttribute("idpuesto", idpuesto);
                           // sesion.setAttribute("idDia", dia);
                            out.print("Empleado");
                            //System.out.println(dia.getEstado());

                       /* } catch (Exception e) {
                            out.print("<div class='ui-widget'>");
                            out.print("<div class='ui-state-error ui-corner-all' style='padding: 0 .7em;'>");
                            out.print("<p><span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span> <strong>Error:</strong> "
                                    + "<br>NINGUN DIA ACTIVO Ó DOS O MÁS DIAS ESTAN ACTIVOS COMPRUEBE!</p>");
                            out.print("</div>");
                        }*/

                    } else {

                        out.print("<div class='ui-widget'>");
                        out.print("<div class='ui-state-error ui-corner-all' style='padding: 0 .7em;'>");
                        out.print("<p><span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span> <strong>Error:</strong> "
                                + "<br>Acceso denegado!</p>");
                        out.print("</div>");
                    }


                } catch (Exception e) {
                } finally {
                    try {
                        session.close();
                    } catch (HibernateException he) {
                        throw he;
                    }

                }

            } else {
                out.print("<div class='ui-widget'>");
                out.print("<div class='ui-state-error ui-corner-all' style='padding: 0 .7em;'>");
                out.print("<p><span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span> <strong>Error:</strong> "
                        + "Usuario ó Password incorrectos!<br>Intente de nuevo.</p>");
                out.print("</div>");
                System.out.println("No existe el usuario");
            }





        
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
