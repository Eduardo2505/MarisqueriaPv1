/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adicionales.xml;

import com.dao.impl.ProductoDaoImpl;
import com.mapping.Categoria;
import com.mapping.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdom.jdom;
import otrosNOsirve.conexion;

/**
 *
 * @author Eduardo
 */
public class Crearadicionales {

    public static void main(String[] args) {

        conexion mysql = new conexion();
        Connection cn = mysql.Conectar();
        String sSQl;
        String resp = "";

        // sSQl = "SELECT idProducto,nombre FROM producto where idCategoria='BOTELLAS_P23'";
        sSQl = "SELECT * FROM producto where idCategoria in (\"ANTOJO\",\"CEVICHES\",\"CHOPAS\",\"COCTELES\",\"PLATILLOS\",\"TACOS\",\"TERRESTRES\")";

        try {

            Statement st = cn.createStatement();
            ResultSet rset;
            rset = st.executeQuery(sSQl);

            while (rset.next()) {

              /* ProductoDaoImpl dao = new ProductoDaoImpl();
               /* Producto p = new Producto();
                p.setIdProducto("PROMO-"+rset.getString(1));
                p.setNombre(rset.getString(2)+" 2X1");
                p.setTamano(rset.getInt(3));
                Categoria c = new Categoria();
                c.setIdCategoria(rset.getString(4));
                p.setCategoria(c);
                p.setTipo(rset.getString(5));
                p.setTipoEvento(rset.getString(6));
                p.setPrecio(rset.getFloat(7));
                p.setImportacion(rset.getString(8));
                p.setUrl("0");
                p.setOpcion(rset.getString(12));
                p.setMedida(rset.getString(13));
                dao.insertar(p);
                dao.actulizar(rset.getString(1), "Cocina", "Adicional","ml");*/

                //eliminar(rset.getInt(1));
                System.out.println(rset.getString(1));
                copiar("C:\\Users\\Eduardopc\\Desktop\\comida.xml","C:\\Users\\Eduardopc\\Desktop\\xml\\"+rset.getString(1)+".xml");
                // jdom dao = new jdom();
                // dao.editar("C:\\Users\\Eduardo\\Desktop\\064258193.xml", rset.getString(1), rset.getString(2), "botella");



            }


            st.close();
            rset.close();
            cn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }

    static void copiar(String sourceFile, String destinationFile) {


        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);

            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Hubo un error de entrada/salida!!!");
        }

    }
}
