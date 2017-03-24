/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Task;

import com.dao.impl.AltadiaDaoImpl;
import com.mapping.Altadia;
import java.util.Calendar;
import java.util.TimerTask;
import jdom.Reportexml;
import mail.EmailEnv;
import otrosNOsirve.PromocionesAutomatico;
import otrosNOsirve.consultasMysq;

/**
 *
 * @author hp g4
 */
public class SimpleTimer extends TimerTask {

    float total = 0;
    float totalc = 0;

    @Override
    public void run() {
        doCheck();
    }

    private void doCheck() {



        Calendar now = Calendar.getInstance();
        int MINUTE = Calendar.getInstance().get(Calendar.MINUTE);
        int HOUR = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        System.out.println("Minutos: " + MINUTE);
        System.out.println("Hora: " + HOUR);
        System.out.println("Dia: " + dia);


        if (MINUTE == 0 && (HOUR >= 17 && HOUR <= 21) && dia != 1) {
            PromocionesAutomatico dao = new PromocionesAutomatico();
            dao.updatepromociones("promo", "1");// cambialos por 1 los que esten en 0
            dao.updatepromociones("normal", "0");

            System.out.println("Entro Promo");
        }else if (MINUTE == 0) {
            PromocionesAutomatico dao = new PromocionesAutomatico();
            dao.updatepromociones("promo", "0");// cambialos por 1 los que esten en 0
            dao.updatepromociones("normal", "1");

            System.out.println("Entro Normal");
        }





       // System.out.println("Sin reporte: " + now.getTime().toString());

    }
}
