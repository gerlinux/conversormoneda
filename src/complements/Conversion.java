package complements;

import java.util.Map;

public class Conversion {

    public Double caclularConversion(int opcion, Double monto){

        ConsultarCambio consulta = new ConsultarCambio();
        ListadoCodigosMonedas currency_code_search = new ListadoCodigosMonedas();

        String[] currency_code = currency_code_search.codigoMonedas(opcion);

        Moneda cambio = consulta.buscarCambio(currency_code[0], currency_code[1]);

        //System.out.println("conversion rate " + cambio.toString());
        Map<String, Double> current_rate = cambio.conversion_rates();

        //Cargamos cRate y oRate con los valores correspondiente para luego hacer el calculo
        Double cRate = current_rate.get(currency_code[1]);
        Double oRate = current_rate.get(currency_code[0]);

        return ((cRate / oRate) * monto);
    }
}
