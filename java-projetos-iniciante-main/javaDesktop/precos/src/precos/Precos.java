/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package precos;

import java.util.Scanner;

/**
 *
 * @author VP
 */
public class Precos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x,cod,i,posi=1,tamcpf,f;
        String resp,nome,estabe,ender,cpf;
        Scanner ler=new Scanner(System.in);
        char repo[]=new char[1];
        char sd[]=new char[1];
        
        cadastro chamada=new cadastro();
        do{
         System.out.printf("digite seu nome:");
         nome=ler.nextLine();
         sd[0]=nome.charAt(0);
        }while(sd[0]==' ');
        do{
         System.out.printf("digite o nome do estabelecimento:");
         estabe=ler.nextLine();
         sd[0]=estabe.charAt(0);
        }while(sd[0]==' ');
        
        do{
         System.out.printf("digite o endereço do estabelecimento:");
         ender=ler.nextLine();
         sd[0]=ender.charAt(0);
        }while(sd[0]==' ');
        
        do{
          do{
            System.out.printf("digite o seu cpf:");
            cpf=ler.nextLine();
            cpf=cpf.replaceAll("\\.","");
            cpf=cpf.replaceAll("/","");
            cpf=cpf.replaceAll("-","");
            tamcpf=cpf.length();
          }while(tamcpf!=11 || cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") ||  cpf.equals("88888888888") || cpf.equals("99999999999"));
            f=chamada.CPF(cpf);
            if(f!=1){
                System.out.printf("cpf incorreto tente noivamente\n");
            }
        }while(f!=1);
        
        do{
         do{
         System.out.printf("digite o numero do codigo:");
         x=ler.nextInt();
         if(x>4){
             System.out.printf("codigo incorreto digite novamente\n");
         }
         }while(x>4 || x<1);
       
         chamada.getmostrar(x);
         if(posi<4){
             System.out.printf("quer sair agora s ou n?\n");
             ler.nextLine();
             resp=ler.nextLine();
             for(i=0;i<resp.length();i=i+1){
             repo[i]=resp.charAt(i);
             }
         }
         posi=posi+1;
        }while(repo[0]=='n' && posi<=4);
        System.out.printf("nome:%s\n----------------------------------------------------------\n",nome);
        System.out.printf("nome do estabelecimento:%s\n----------------------------------------------------------\n",estabe);
        System.out.printf("endereço %s\n----------------------------------------------------------\n",ender);
        System.out.printf("cpf %s\n----------------------------------------------------------\n",cpf);
        chamada.gettot();
    }
    
}
