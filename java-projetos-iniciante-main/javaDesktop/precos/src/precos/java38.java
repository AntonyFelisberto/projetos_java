/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precos;

/**
 *
 * @author VP
 */
public class java38 {
   private String nome1,nome2,nome3,nome4;
    private int cod1,cod2,cod3,cod4;
    private float preco1,preco2,preco3,preco4,tot;
    String vor;
    public java38(){
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
    
     String vormostrar(int x){
         String vor;
      
            if(x==1){
                vor="codigo 1 nome salgado preço 5.30";
                tot=tot+preco1;
                 return vor;
            }else if(x==2){
                 vor="codigo 2 nome doce preço 6.00";
                   tot=tot+preco2;
                   return vor;
            }else if(x==3){
                 vor="codigo 2 nome doce preço 6.00";
                   tot=tot+preco2;
                   return vor;
            }else if(x==4){
                vor="codigo 4 nome lanche natural preço 10.50";
                 tot=tot+preco4;
                 return vor;
                 
            }else{
               return null;
            }
    }
    
}
