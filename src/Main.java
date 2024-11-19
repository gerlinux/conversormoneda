import complements.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        Scanner lectura = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal();

        ListadoCodigosMonedas monedaCodes = new ListadoCodigosMonedas();
        Conversion convert = new Conversion();

        String[] currency_codes;

        try{
            while(true){

                System.out.println(menu.menu());
                var opcion = lectura.nextInt();
                lectura.nextLine();

                //En el caso de que el usuario cargue una opcion no valida entramos en un loop hasta que de una
                //opcion correcta o ingrese 0 para salir

                while(((opcion > monedaCodes.currency_list()) || (opcion < 0)) && (opcion != 0)){
                    System.out.println("Ingrese una opcion valida");
                    System.out.println(menu.menu());
                    opcion = lectura.nextInt();
                    lectura.nextLine();
                }
                if(opcion == 0){
                    System.out.println("Gracias por utilizar el conversor");
                    break;
                }
                System.out.println("Ingrese el monto: ");
                var monto = lectura.nextDouble();
                lectura.nextLine();

                //Solamente obtengo los codigos de moneda a modo informativo para el usuario
                currency_codes = monedaCodes.codigoMonedas(opcion);

                DecimalFormat formater = new DecimalFormat("#.###");
                System.out.println(currency_codes[0] + " " + monto + " equivale a " + currency_codes[1] + " " + formater.format(convert.caclularConversion(opcion, monto)));

            }

        }catch (NumberFormatException e){
            System.out.println("Numero no encontrado " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizo la ejecucion del programa");
        }
    }
}