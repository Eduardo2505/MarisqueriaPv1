<%-- 
    Document   : Productos
    Created on : 30/01/2013, 02:18:43 AM
    Author     : Eduardopc
--%>


<%@page import="com.mapping.Puesto"%>
<%@page import="com.mapping.Categoria"%>
<%@page import="com.mapping.Descuento"%>
<%@page import="com.dao.impl.DescuentoDaoImpl"%>
<%@page import="com.mapping.Altadia"%>
<%@page import="com.mapping.Empleado"%>
<%@page import="com.mapping.Producto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.impl.ProductoDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <%
            String idCategoria = request.getParameter("idCategoria");
            String tipo = request.getParameter("tipo");
            ProductoDaoImpl dao = new ProductoDaoImpl();
            List resp = null;
            HttpSession sesion = request.getSession();
            //Empleado e = new Empleado();
            Altadia d = new Altadia();
            String nombre = "", nomMesero = "", tipoEvento = "", idDescuento = "";
            String idBarra = (String) sesion.getAttribute("idBarra");
            //e = (Empleado) sesion.getAttribute("id");
            String idMesero = "", idMesa = "", idComanda = "";
            int idDia = 0, idpuesto = 0;;


            if (idBarra == null) {
                response.sendRedirect("index.jsp");
            } else {
                nombre = " ByLatino";
                Empleado em = new Empleado();
                idComanda = (String) sesion.getAttribute("idComanda");
                idMesa = (String) sesion.getAttribute("idMesa");
                em = (Empleado) sesion.getAttribute("idMesero");
                idDescuento = (String) sesion.getAttribute("idDescuento");
                nomMesero = em.getNombre() + " " + em.getApellidos();
                d = (Altadia) sesion.getAttribute("idDia");
                idMesero = em.getIdEmpleado();
                idDia = d.getIdaltadia();
                tipoEvento = d.getTipoEvento();
                Puesto pues = new Puesto();
                pues = em.getPuesto();
                idpuesto = pues.getIdpuesto();
                //out.println(idMesa);
                if (idCategoria.equals("") && tipo.equals("")) {

                    resp = dao.getBuscar("", tipoEvento);



                } else {

                    resp = dao.getFiltro(idCategoria, tipo, tipoEvento, "");
                }

            }

        %>
        <style>
            #sortable { list-style-type: none; margin: 0; padding: 0; width: 100%; }
            #sortable li { margin: 3px 3px 3px 0; padding: 1px; float: left;  }

            .addProducto{

                margin: 3px 3px 3px 0; padding: 1px; float: left; width: 110px; height: 120px; font-size: 1em; text-align: center;
            }
            div.bordesolido{ 
                border: 1px solid #aaaaaa; 
            }
        </style>
        <script type="text/javascript">


            $(document).ready(function() {
                $('#NombreProducto').keyup(function() {

                    var user = $(this).val();
                    //  alert(user);
                    var idCategoria = $('#idCategoria').val();
                    var tipo = $('#tipo').val();
                    var dataString = 'NombreProducto=' + user + '&tipo=' + tipo + '&idCategoria=' + idCategoria;
                    //var dataString ='NombreProducto='+user;
                    //alert(user);

                    if (user != "") {
                        $('#verResultadoBuscados').html('<img src="img/ajax-loader.gif" alt=""/>');
                        $.ajax({
                            type: "POST",
                            url: "BuscarProductoController",
                            data: dataString,
                            success: function(data) {
                                //alert(data)

                                $('#verResultadoBuscados').fadeIn(500).html(data);

                                //	 response.sendRedirect("index.jsp");	
                                //alert(data);
                            }
                        });
                        //}
                    }
                }


                );
            });


            //regresar de nuvo............
            $(document).ready(function() {
                $("#Regresar_comandaVenta").click(function(event) {

                    var idCargoria = $(this).attr("title");
                    //alert(idCargoria)
                    $("#div_mostrar").load(idCargoria);
                });
            });

            //Agregar producto a comanda
            $(document).ready(function() {
                $(".addProducto").click(function(event) {
                    var idDescuento = $('#porcentaje').val();

                    var tipro = $('#porcentaje').val();
                    var nombre = "";
                    var idCargoria = $(this).attr("title");

                    $('#passAutorizaciondes').val("");
                    $("#ComandaVirtual").load(idCargoria + idDescuento);

                });
            });




            $(document).ready(function() {
                $(".addProductoBotellas").click(function(event) {
                    var idDescuento = $('#porcentaje').val();

                    if (idDescuento != "Ninguno") {
                        var idCargoria = $(this).attr("title");

                        $("#ComandaVirtual").load(idCargoria + idDescuento);
                    } else {
                        $("#Activar").click();
                        //var idBotella = $(this).attr("name");

                        //alert(idDescuento + idBotella);


                    }
                    //
                });
            });
        </script>



    


        <!--<a href="#" id="Activar" data-reveal-id="Activardiv" data-animation="fadeAndPop" data-animationspeed="300" data-closeonbackgroundclick="true" data-dismissmodalclass="close-reveal-modal" title="" ></a>-->
        <div align="center" >
            <table style="width:100%;text-align:center">
                <tr><td>

                    </td><td style="background-color:orange">

                        <h4>DESCUENTO
                            <input type="hidden" id="porcentaje" value="<% out.println(idDescuento);%>">

                            <% out.println(idDescuento);%></h4>                       




                    </td><td style="background-color:orange">


                        <input type="hidden" value="<% out.println(idCategoria);%>" id="idCategoria">
                        <input type="hidden" value="<% out.println(tipo);%>" id="tipo">
                        <input type="text" id="NombreProducto"  class="input-medium search-query"   placeholder="Búscar...'todo'">




            </table></td>



    </div>
    <div align="center" id="verResultadoBuscados">

        <ul id="sortable" >
            <%
                if (idComanda.equals(
                        "VER")) {

                    
                } else {

                    Iterator itr = resp.iterator();
                    while (itr.hasNext()) {
                        Producto p = (Producto) itr.next();
                        // System.out.println(p.getIdProducto() + p.getNombre());
                        p.setIdProducto(p.getIdProducto());

                        //if (p.getTipo().equals("Botella")) {
                        //    out.print("<li class='ui-state-default'><a class='addProducto' href='#' name='" + p.getIdProducto() + "' title='addVirtual?idProducto=" + p.getIdProducto() + "&idDescuento='><br>" + p.getIdProducto() + "<br><h4>" + p.getNombre() + "</h4><br>$" + p.getPrecio() + " " + p.getTipo() + "</a></li>");
                       // } else {

                            out.print("<li class='ui-state-default'><a class='addProducto' href='#' title='addVirtual?idProducto=" + p.getIdProducto() + "&idDescuento='><br>" + p.getIdProducto() + "<br><h4>" + p.getNombre() + "</h4><br>$" + p.getPrecio() + "</a></li>");
                      //  }
                    }

                }

            %>



        </ul>



    </div>
</body>
</html>
