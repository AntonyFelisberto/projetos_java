package METODOS;

import java.util.regex.Pattern;

public class MatchPhoneNumbers {
  public boolean valide(String telefone) {
     boolean tel=false;
    String[] testStrings = {"antony","43996916631"};
    Pattern p = Pattern.compile("^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$");
    for (String str : testStrings) {
        if (p.matcher(str).matches()) {
            tel=true;
        } else {
            tel=false;    
        }
    }
     return tel;
    }
    
}
