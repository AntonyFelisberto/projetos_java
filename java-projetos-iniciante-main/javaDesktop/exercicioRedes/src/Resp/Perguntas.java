package Resp;


public class Perguntas {
    public int resp[]={1,2,1,,,,,,,,,,,,,,,};
    
    public boolean verifiqueResposta(int resposta,int posicao){
        boolean retornoValidado=false;
        if(resp[posicao]==resposta){
            retornoValidado=true;
        }else{
            retornoValidado=false;
        }
        return retornoValidado;
    }
}
