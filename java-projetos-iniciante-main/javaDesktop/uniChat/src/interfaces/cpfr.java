/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.InputMismatchException;


public class cpfr {
    int CPF (String CPF ){
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {

            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
  
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 

 
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
            
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(1);
            else return(0);
                } catch (InputMismatchException erro) {
                return(0);
            }
        }
}
