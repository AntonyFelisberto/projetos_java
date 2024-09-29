/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opcoes;

import java.util.Scanner;

class avm {
 String nome_produto,descricao,fornecedor,cnpj; 
 float preco_compra,margem_lucro;
 int índice;
}
public class Opcoes {

    public static void main(String[] args) {
        Scanner ler=new Scanner(System.in);        
         int op,m=0,n=0,f=5,fd=0;
         avm chama[]=new avm[10];          
         rotulo:  
        do{
         System.out.printf("qual sua opção:\n");
         System.out.printf("1-cadastro\n");
         System.out.printf("2-listagem\n");
         System.out.printf("3-consulta\n");
         System.out.printf("4-alteração\n");
          System.out.printf("5-sair\n");
         validacnpj chame=new validacnpj();
         op=ler.nextInt();
         //1-CRIAÇÃO DO MENU
        switch(op){
        case 1:
             //3-INSERÇÃO DOS REGISTROS
             do{
                System.out.printf("digite o nome do produro:");
                ler.nextLine();
                chama[m].nome_produto=ler.nextLine();
               do{
                System.out.printf("digite o cnpj:");
                ler.nextLine(); 
                chama[m].cnpj=ler.nextLine();
                f=chame.valide(chama[m].cnpj);
                 if(f==0){
                      System.out.println("cnpj invalido");
                 }
                }while(f==0);
                System.out.printf("descrição do produto:");
                 ler.nextLine();
                chama[m].descricao=ler.nextLine();
                System.out.printf("digite o fornecedor:");
                 ler.nextLine();
                chama[m].fornecedor=ler.nextLine();
                System.out.printf("preço da compra:");
                chama[m].preco_compra=ler.nextFloat();
                System.out.printf("margem de lucro:");
                chama[m].margem_lucro=ler.nextFloat();
                System.out.printf("digite o indice:");
                chama[m].índice=ler.nextInt(); 
                m=m+1;
                if(m==9){
                     break rotulo;
                 }
                //8-CADASTRAR OUTRO OU SAIR DO PROGRAMA
                System.out.printf("quer cadastrar outro ou sair 1-cadastrar 2-sair?");
                 n=ler.nextInt();
                }while(n!=2);
            break rotulo;
           case 2:
                 //5-CONSULTA POR NOME E FORNECEDOR
                 String forn,prod;
                 System.out.printf("digite o nome do produto");
                  ler.nextLine();
                 prod=ler.nextLine();
                 System.out.printf("digite o nome do fornecedor");
                  ler.nextLine();
                 forn=ler.nextLine();
                 if(m>0){
                   int i;
                   for(i=0;i<=m;i=i+1){
                    if(chama[i].nome_produto.equals(prod)||chama[i].fornecedor.equals(forn)){
                     System.out.printf("---------------------------------------------");
                     System.out.printf("Nome do produto %s\n",chama[i].nome_produto);
                     System.out.printf("Descrição %s\n",chama[i].descricao);
                     System.out.printf("Fornecedor %s\n",chama[i].fornecedor);
                     System.out.printf("CNPJ %s\n",chama[i].cnpj);
                     System.out.printf("Preco de compra %f\n",chama[i].preco_compra);
                     System.out.printf("Margem de Lucro %f\n",chama[i].margem_lucro);
                     System.out.printf("Indice %d\n",chama[i].índice);
                     System.out.printf("---------------------------------------------");
                    }
                   }
                 }else{
                   System.out.printf("valores não encontrados\n");  
                 }
                break rotulo;
           case 3:
                //6-CONSULTA POR INDICE E NOME
                  int indi;
                  String nome;
                  System.out.printf("digite o nome do produto:");
                   ler.nextLine();
                  nome=ler.nextLine();
                  System.out.printf("digite o nome do indice:");
                  indi=ler.nextInt();
                   if(m>0){
                     int i;
                     for(i=0;i<=m;i=i+1){
                      if(chama[i].nome_produto.equals(nome)||chama[i].índice==indi){
                        System.out.printf("---------------------------------------------");
                        System.out.printf("Nome do produto %s\n",chama[i].nome_produto);
                        System.out.printf("Descrição %s\n",chama[i].descricao);
                        System.out.printf("Fornecedor %s\n",chama[i].fornecedor);
                        System.out.printf("CNPJ %s\n",chama[i].cnpj);
                        System.out.printf("Preco de compra %f\n",chama[i].preco_compra);
                        System.out.printf("Margem de Lucro %f\n",chama[i].margem_lucro);
                        System.out.printf("Indice %d\n",chama[i].índice);
                        System.out.printf("---------------------------------------------");
                      }
                     }
                 }else{
                   System.out.printf("valores não encontrados\n");  
                 }
             break rotulo;
             case 4:
                 //7-ALTERAÇÃO
                 int i;
                 float arsd,rs,nsd;
                 System.out.printf("digite o preço de compra que deseja alterar");
                 arsd=ler.nextFloat();
                 if(m>0){
                  for(i=0;i<=m;i=i+1){
                    if(chama[i].preco_compra==arsd){
                         System.out.printf("digite o novo valor do preço");
                         rs=ler.nextFloat();
                         System.out.printf("digite o novo valor da margem");
                         nsd=ler.nextFloat();
                         alterar cj=new alterar();
                         cj.setnovo(nsd,rs);
                         chama[i].preco_compra=cj.getpre();
                         chama[i].margem_lucro=cj.getmar();                         
                         float preco_venda=chama[i].preco_compra+((chama[i].margem_lucro/100)*chama[i].preco_compra);
                         System.out.printf("o preço de venda é %.2f",preco_venda); 
                    }  
                  }
                 }else{
                     System.out.printf("você não inseriu nenhum valor");
                 }
             break rotulo;
             case 5:
                 fd=1;
             break;
             default:
                 System.out.printf("opção invalida");
             break rotulo;
         }
    }while(fd!=1);
    }
}
