package complements;

public class ListadoCodigosMonedas {

    String[][] currency_code = {{"USD", "ARS"}, {"ARS", "USD"}, {"USD", "BRL"}, {"BRL", "USD"}, {"ARS", "BRL"}, {"BRL", "ARS"}};

    public String[] codigoMonedas(int eleccion){

        String[] array = {currency_code[eleccion -1][0], currency_code[eleccion -1][1]};

        return array;
    }

    public int currency_list(){
        return  currency_code.length;
    }
}
