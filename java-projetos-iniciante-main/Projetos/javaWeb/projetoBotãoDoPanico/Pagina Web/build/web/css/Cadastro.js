var a,i,at;
a=0;
i=0;
at=0;

function atualize(){
    if(a===0){
       document.getElementById('atualizar').style.display="block";
       document.getElementById('inativar').style.display="none";
       document.getElementById('ativar').style.display="none";   
       a=1;
    }else{
       document.getElementById('atualizar').style.display="none";
       document.getElementById('inativar').style.display="none";
       document.getElementById('ativar').style.display="none"; 
       a=0;      
    }
}
function inative(){
    if(i===0){
       document.getElementById('atualizar').style.display="none";
       document.getElementById('inativar').style.display="block";
       document.getElementById('ativar').style.display="none";   
       i=1;
    }else{
       document.getElementById('atualizar').style.display="none";
       document.getElementById('inativar').style.display="none";
       document.getElementById('ativar').style.display="none"; 
       i=0;      
    }
}
function ative(){
    if(at===0){
       document.getElementById('atualizar').style.display="none";
       document.getElementById('inativar').style.display="none";
       document.getElementById('ativar').style.display="block";   
       at=1;
    }else{
       document.getElementById('atualizar').style.display="none";
       document.getElementById('inativar').style.display="none";
       document.getElementById('ativar').style.display="none"; 
       at=0;      
    }
}
