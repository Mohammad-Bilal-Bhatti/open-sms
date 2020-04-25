/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Javed Ali Dahri
 */
public class CurrentDate {

    /*
    * @Purpose: To Return Current System Date with out Time Information.
    * @Params: None
    * @Return: java.util.Date Object
    */
    public static Date getCurrentDate() {
        String format = "MMM d, yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return new Date(formatter.format(new Date()));
    }
}
