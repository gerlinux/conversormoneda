package complements;

public class MenuPrincipal {
    public String menu() {
        String s = """
                Elija la opcion a convertir
                
                1 - USD Dolar a ARS Peso Argentino
                2 - ARS Peso Argentino a USD Dolar
                3 - USD Dolar a BRL Real 
                4 - BRL Real a USD Dolar
                5 - ARS Peso Argentino a BRL Real 
                6 - BRL Real a ARS Peso Argentino
                0 - Salir                        
                
                """;
        return s;
    }
}
