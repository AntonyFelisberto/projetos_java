/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author VP
 */
public class mm {
     public static int leitor(String nome,String nomes,String senha){
            String conteudo="";
            try{
              FileReader arquivo= new FileReader(nome);
              BufferedReader lei= new BufferedReader(arquivo);
              String lore="";
                
               try{
                  lore=lei.readLine();
                   while (lore!=null) {
                       String linha1 = lei.readLine();
                       String linha2 = lei.readLine();
                       if(nomes.equals(linha1) && senha.equals(linha2)){
                           conteudo="certo";
                       }else{
                            conteudo="erro";
                       }
                   }
                   arquivo.close();
               }catch(IOException e){ 
                   conteudo="erro";
               }
            }catch(IOException e){
                conteudo="erro";
            }
            if(conteudo.contains("erro")){
                return 0;
            }else{
                return 1;
            }
     }
     
     public static boolean printar(String camino,String nome,String senha,String email,String cpf,String fone){
         try{
           FileWriter arquivo= new FileWriter(camino);
           PrintWriter grave= new PrintWriter (arquivo);
           grave.printf("%s\n",nome);
           grave.println(senha);
           grave.close();  
           return true;
         }catch(IOException e){
             System.out.println(e.getMessage());
             return false;
         }
     
}
      public int std (String nomo, String dd){
          String gnomo,suricati;
          m chama=new m();
          gnomo=chama.nome;
          suricati=chama.senha;
        if(nomo.equals(gnomo) && dd.equals(suricati)){
            return 0;
        }else{
         return 1;
        }
    }
}
