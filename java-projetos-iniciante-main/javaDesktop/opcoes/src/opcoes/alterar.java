/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opcoes;

public class alterar {
   private float margem;
   public  float preco;
   private float precovenda;
   
   public void setnovo(float no,float nos){
       this.margem=no;
       this.preco=nos;
   }
   public float getpre(){
       return preco;
   }
   public float getmar(){
       return margem;
   }
}
