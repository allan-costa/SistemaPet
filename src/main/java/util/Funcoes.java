package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcoes {
    
    public static Date strToDate(String data){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String dateToStr(Date data){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

}
