package tabuleiro;

import java.util.Scanner;

public class Tabuleiro {

    public static String tabuleiro[][]=new String[3][3];
    public static int jogador=0;
    
    public static void main(String[] args) {
         Scanner leitor=new Scanner(System.in); 
         int linha;
         zerar();  
         System.out.println("escolha uma posição abaixo");
         System.out.println("");
         System.out.println("");
         String vitoria="";
         while(vitoria.isEmpty()){
            imprimir();
            System.out.println("");
            System.out.println("");
            do{
              linha=leitor.nextInt();
              if(linha<=0||linha>=10){
                System.out.println("isso não é permitido");
              }
            }while(linha<=0||linha>=10);
            System.out.println("");
            System.out.println("");
            alocar(linha);
            jogoFinalizado();
            tabuleiroCheio();
         }     
    }
    public static void zerar(){
        int linha,coluna,m=1;
        for(linha=0;linha<3;linha++){
            for(coluna=0;coluna<3;coluna++){
                tabuleiro[linha][coluna]=String.valueOf(m);
                m=m+1;
            }
        }
    }
    public static void alocar(int linhaArmazenada){
        int linha,coluna;
        for(linha=0;linha<3;linha++){
            for(coluna=0;coluna<3;coluna++){
               if(tabuleiro[linha][coluna].contains(String.valueOf(linhaArmazenada))){
                   if(jogador==1){
                       tabuleiro[linha][coluna]="X";
                       jogadores(1);
                   }else{
                       tabuleiro[linha][coluna]="O";
                       jogadores(2);
                   }
               }
            }
        }
    }
    
    public static boolean verificar(){
        int linha,coluna;
        boolean verdades=false;
        for(linha=0;linha<3;linha++){
            for(coluna=0;coluna<3;coluna++){
               if(tabuleiro[linha][coluna]!="X" && tabuleiro[linha][coluna]!="O" ){
                 verdades=true;
               }
               
            }
        }
        return verdades;
    }
    
    public static void tabuleiroCheio(){
        if(!verificar()){
            imprimir();
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("zerando o jogo");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            zerar(); 
        }
    }
    
    public static void declaraCampeao(String valor){
          if(valor.equals("X")){
              System.out.println("parabens você ganhou jogador X"); 
          }else{
              System.out.println("parabens você ganhou jogador O"); 
          }
    }
    public static void jogoFinalizado(){
        String valor;
        if(jogador==1){
            valor="X";
        }else{
            valor="O";
        }
        if(tabuleiro[0][0].contains(valor)&& tabuleiro[0][1].contains(valor)&& tabuleiro[0][2].contains(valor)){
              declaraCampeao(valor);
              zerar();
        }else if(tabuleiro[1][0].contains(valor)&& tabuleiro[1][1].contains(valor)&& tabuleiro[1][2].contains(valor)){
              declaraCampeao(valor);
              zerar();
        }else if(tabuleiro[2][0].contains(valor)&& tabuleiro[2][1].contains(valor)&& tabuleiro[2][2].contains(valor)){
              declaraCampeao(valor);
              zerar();
        }else if(tabuleiro[0][0].contains(valor)&& tabuleiro[1][1].contains(valor)&& tabuleiro[2][2].contains(valor)){
              declaraCampeao(valor);
              zerar();
        }else if(tabuleiro[0][2].contains(valor)&& tabuleiro[1][1].contains(valor)&& tabuleiro[2][0].contains(valor)){
              declaraCampeao(valor);
              zerar();
        }else if(tabuleiro[0][0].contains(valor)&& tabuleiro[1][0].contains(valor)&& tabuleiro[2][0].contains(valor)){
              declaraCampeao(valor);
              zerar();
        }else if(tabuleiro[0][1].contains(valor)&& tabuleiro[1][1].contains(valor)&& tabuleiro[2][1].contains(valor)){
              declaraCampeao(valor);
              zerar();
        }else if(tabuleiro[0][2].contains(valor)&& tabuleiro[1][2].contains(valor)&& tabuleiro[2][2].contains(valor)){
              declaraCampeao(valor);
              zerar();
        }        
       
    }
    
    public static void imprimir(){
        int linha,coluna;
        for(linha=0;linha<3;linha++){
            System.out.printf(tabuleiro[linha][0]);
            System.out.printf(" | ");
            System.out.printf(tabuleiro[linha][1]);
            System.out.printf(" | ");
            System.out.printf(tabuleiro[linha][2]);
            System.out.println("");   
        }        
    }
    public static void jogadores(int id){
        if(id==1){
            jogador=2; 
        }else{
            jogador=1;
        }
    }
}
