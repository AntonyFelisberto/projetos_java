/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precos;

import java.util.InputMismatchException;

/**
 *
 * @author VP
 */
public class cadastro {
    private String nome1,nome2,nome3,nome4;
    private int cod1,cod2,cod3,cod4;
    private float preco1,preco2,preco3,preco4,tot;
    
    public cadastro(){
     this.cod1=1;
     this.cod2=2;
     this.cod3=3;
     this.cod4=4;
     this.nome1="salgado";
     this.nome2="doce";
     this.nome3="folhado";
     this.nome4="lanche natural";
     this.preco1= (float) 5.30;
     this.preco2=(float) 6.00;
     this.preco3=(float) 7.20;
     this.preco4=(float) 10.50;
    }
    void getmostrar(int x){
        switch(x){
            case 1:
                    System.out.printf("codigo %d nome %s preço %.2f\n",this.cod1,this.nome1,this.preco1);
                    tot=tot+preco1;
            break;
            case 2:
                   System.out.printf("codigo %d nome %s preço %.2f\n",cod2,nome2,preco2);
                   tot=tot+preco2;
            break;
            case 3:
                 System.out.printf("codigo %d nome %s preço %.2f\n",cod3,nome3,preco3);
                 tot=tot+preco3;
            break;
            case 4:
                 System.out.printf("codigo %d nome %s preço %.2f\n",cod4,nome4,preco4);
                 tot=tot+preco4;
            break;
            
        }  
    } 
    void gettot(){
         System.out.printf("total de preços foi %.2f\n",tot);
    }
    int CPF (String CPF ){
        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
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

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(1);
            else return(0);
                } catch (InputMismatchException erro) {
                return(0);
            }
        }
}

