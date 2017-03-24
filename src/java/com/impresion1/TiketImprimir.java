/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impresion1;

/**
 *
 * @author Eduardo
 */
public class TiketImprimir {

    public String ImprimirComanda(String mesero, String clave, String idMesa, String idComanda, String fechaAc, String horaAc, String tipo, String autoriza, String Obs, String res, String ita, String imbr, String pakete) {

        StringBuffer resultado = new StringBuffer("");
        String cabecera = "**\n\n\t      \tMARISQUERIA\n"
                + "\t    \tBARRA PEDIDO\n";
        String cabeceracopia = "**\n\n\t      \tMARISQUERIA\n"
                + "**\t ** COCINA PEDIDO **\n";
        String cabeceracopiaITA = "**\n\n\t      \tMARISQUERIA\n"
                + "**\t **CAJA PEDIDO**\n";
        resultado.append(""
                + "Mesero:\n"
                + "" + mesero + "\n"
                + "Clave: 	"
                + "" + clave + "\n"
                + "	\n"
                + "Cuenta:  " + idMesa + " 	\n"
                + "Comanda: " + idComanda + " 	\n"
                + "FECHA: 	" + fechaAc + " 	\n"
                + "HORA: 	" + horaAc + " 	\n"
                + "TIPO: "
                + "" + tipo + "\n");


        if (!tipo.equals("VENTA")) {
            resultado.append("Autorización:\n"
                    + "" + autoriza + ""
                    + "\nDescripción:\n"
                    + "" + Obs + "");
        }


        resultado.append("	\n"
                + "	"
                + "Producto	Cantidad\n");
        resultado.append(res + "\n\n");

        String original = "";
        String copia = "", cajat = "";
        //  String copiaITA = cabeceracopiaITA + resultado.toString() + "\n\n\n" + CortarHoja();
        //Ticket ti = new Ticket(original + copia);
        // ti.print();
        String tiket = "";
        cajat = cabeceracopiaITA + resultado.toString() + "\n\n\n" + CortarHoja();
        if (pakete.equals("Activo")) {
            original = cabecera + resultado.toString() + "\n\n\n" + CortarHoja();
            copia = cabeceracopia + resultado.toString() + "\n\n\n" + CortarHoja();
            
        } else {
            if (imbr.equals("Activo")) {
                original = cabecera + resultado.toString() + "\n\n\n" + CortarHoja();
            }
            if (ita.equals("Activo")) {
                copia = cabeceracopia + resultado.toString() + "\n\n\n" + CortarHoja();

                // tiket = original + copia + copiaITA;
            }
        }
        tiket = original + copia + cajat;


        System.out.println(tiket);

        return tiket;

    }

    public String ImprimirComandaCancelad(String mesero, String clave, String idMesa, String idComanda, String fechaAc, String horaAc, String tipo, String autoriza, String Obs, String res) {

        StringBuffer resultado = new StringBuffer("");
        String cabecera = "**\n\n\t      MARISQUERIA\n"
                + "\t    CANCELACION\n";
        String cabeceracopia = "**\n\n\t **COMANDA**\n"
                + "**No es valido para barra** \n";
        resultado.append(""
                + "Mesero:\n"
                + "" + mesero + "\n"
                + "Clave: 	"
                + "" + clave + "\n"
                + "	\n"
                + "Cuenta:  " + idMesa + " 	\n"
                + "Comanda: " + idComanda + " 	\n"
                + "Autorización: " + autoriza + " 	\n"
                + "Descripción: " + Obs + " 	\n"
                + "FECHA: 	" + fechaAc + " 	\n"
                + "HORA: 	" + horaAc + " 	\n"
                + "TIPO: "
                + "" + tipo + "\n");




        resultado.append("	\n"
                + "	"
                + "Producto	Cantidad\n");
        resultado.append(res + "\n\n");

        String original = cabecera + resultado.toString() + "\n\n\n" + CortarHoja();

        Ticket ti = new Ticket(original);
        // ti.print();
        String tiket = original;


        //   System.out.println(tiket);

        return tiket;

    }

    public String Imprimirtiket(String mesero, String clave, int posicion, String idMesa, int per, String fechaAc, String horaAc, String subto, String ste, float sumatotal, String re) {

        StringBuffer resultado = new StringBuffer("");


        String valo = "  **  \n\n              MARISQUERIA \n"
                + "  Niza 19 Col. Juarez \nDel. Cuauhtemoc\n"
                + "            MEXICO, D. F.\n"
                + "           TEL. 41 69 18 20\n"
                + "          RFC: OPR1403115F3\n"
                + "Mesero:		\n"
                + "" + mesero + "\n"
                + "	\n"
                + "Clave: "
                + "" + clave + "\n"
                + "	\n"
                + "Mesa: 	"
                + "" + posicion + "\n"
                + "	\n"
                + "Cuenta: 	" + idMesa + " 	\n"
                + "Personas Aprox: 	" + per + "	\n"
                + "FECHA: 	" + fechaAc + " 	\n"
                + "HORA: 	" + horaAc + " 	\n"
                + "	\n";

        resultado.append(valo);

        resultado.append(re);
        String su = "	_________________\n"
                + "Subtotal:   	   $ " + subto + "\n"
                + "IVA 16%:	   $ " + ste + "\n"
                + "	___________________\n"
                + "TOTAL:	    $ " + sumatotal + "\n\n\n"
                + "     PROPINA NO INCLUIDA\n"
                + "    PROPINA NO OBLIGATORIA\n"
                + "     RESERVA PARA NO COVER\n"
                + "       Y PROMOCIONES\n"
                + "    marisqueriapv.mx\n"
                + "   Tel. 41 69 18 20\n\n\n\n\n\n\n" + CortarHoja();
        resultado.append(su);

        System.out.println(resultado.toString());

        return resultado.toString();
    }

    public static String CortarHoja() {
        return (char) 27 + "m";
    }

    public static void main(String[] args) {
        TiketImprimir dao = new TiketImprimir();
        // dao.Imprimirtiket();

    }
}
