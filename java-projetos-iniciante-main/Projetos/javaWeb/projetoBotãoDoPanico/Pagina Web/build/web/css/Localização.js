        var x;
        if (navigator.geolocation){
            navigator.geolocation.getCurrentPosition(showPosition,showError);
        }else{
           window.alert("O seu navegador não suporta Geolocalização.");
        }
        function altoridade(){
            document.getElementById('toque').play();
            window.alert("AS AUTORIDADES ESTÃO A CAMINHO!");
            document.getElementById('toque').play();
        }
        function showPosition(position){
            x="Latitude: "+position.coords.latitude +" Longitude: "+ position.coords.longitude; 
            document.getElementById("localize").value = x;
        }
       function showError(error){
            switch(error.code){
                case error.PERMISSION_DENIED:
                window.alert("aceite enviar a localização para continuar");
                window.location.href = "Contatos.jsp";
            break;
            case error.POSITION_UNAVAILABLE:
                window.alert("Localização indisponível.");
                window.location.href = "Contatos.jsp";
            break;
            case error.TIMEOUT:
                window.alert("O tempo da requisição expirou.");
                window.location.href = "Contatos.jsp";
            break;
            case error.UNKNOWN_ERROR:
                window.alert("Algum erro desconhecido aconteceu.");
                window.location.href = "Contatos.jsp";
            break;
            }
        }


