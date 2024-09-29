/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opcoes;

/**
 *
 * @author VP
 */
public class validacnpj {
    public int valide(String CNPJ){
        int digito1, digito2, i,b, soma, soma1, soma2;
        char Acnpj[] = new char[14];
        System.out.println("\n Digite o CNPJ com os ., as / e os - : \n");
        CNPJ = CNPJ.replace(".", " ");
        CNPJ = CNPJ.replace("-", " ");
        CNPJ = CNPJ.replace("/", " ");
        CNPJ = CNPJ.replaceAll(" ", "");

        for (i = 0; i < CNPJ.length(); i++) {
            Acnpj[i] = CNPJ.charAt(i);
        }

        int icnpj[] = new int[14];
        for (i = 0; i < 14; i++) {
            icnpj[i] = Character.getNumericValue(Acnpj[i]);
        }
        
        b=5;
        soma=0;
        soma1=0;
        for (i=0; i<4; i++){
            soma = soma + (icnpj[i]*b);
            b = b-1;
            soma1 = soma;
        }
        
        b=9;
        soma=0;
        soma2=0;
        for (i=4; i<12; i++){
            soma = soma + (icnpj[i]*b);
            soma2 = soma; 
            b = b-1;
        }
        
        int digs = (soma1+soma2)%11;
        if (digs < 2){
            digito1 = 0;
        }else{
            digito1 = (11-digs);
        }
        System.out.println("O Primeiro digito verificador : " + digito1);
        
        //Calculo do segundo digito verificador
        b=6;
        soma=0;
        soma1=0;
        for (i=0; i<5; i++){
            soma = soma + (icnpj[i]*b);
            soma1 = soma;
            b = b-1;
        }
        
        b=9;
        soma=0;
        soma2=0;
        for (i=5; i<13; i++){
            soma = soma + (icnpj[i]*b);
            soma2 = soma;
            b = b-1;
        }
        
        digs = (soma1+soma2)%11;
        if (digs < 2){
            digito2 = 0;
        }else{
            digito2 = (11-digs);
        }
        System.out.println("O Segundo digito verificador : " + digito2);
        
        if ((digito1 == icnpj[12]) && (digito2 == icnpj[13])){
            System.out.println("CNPJ Valido !");
            return 1;
        }else{
            System.out.println("CNPJ invalido!");
            System.out.println("Verifique se digitou corretamente.");
            return 0;
        }
    }
}
