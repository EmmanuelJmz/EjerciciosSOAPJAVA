import utez.Service;
import utez.ServiceService;

import java.util.Scanner;

public class SoapClient {
    public static void main(String[] args) {
            ServiceService service = new ServiceService();
            Service port = service.getServicePort();
            Scanner sc = new Scanner (System.in);


        System.out.println("escoge una opcion: \n 1. random \n 2. palabra \n 3.RFC");
        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.println("Ingresa un numero: ");
                int numero = sc.nextInt();
                String response = String.valueOf(port.random(numero));
                System.out.println( response);

            break;

            case 2:
                System.out.println("Ingresa una palabra");
                String palabra = sc.next();

                String x = String.valueOf(port.word(palabra));
                System.out.println( x);
                break;

            default:
                System.out.println("opcion invalida: ");

            case 3:
                System.out.println("Ingresa tu nombre: ");
                String nombre = sc.next();

                System.out.println("Ingresa tu apellido paterno: ");
                String apellidoP = sc.next();

                System.out.println("Ingresa tu apellido materno: ");
                String apellidoM = sc.next();

                System.out.println("Ingresa tu año de nacimiento: ");
                String anio = sc.next();

                System.out.println("Ingresa tu mes de nacimiento (00): ");
                String mes = sc.next();

                System.out.println("Ingresa tu dia de nacimiento (00): ");
                String dia = sc.next();

                String x1 = String.valueOf(port.rfc(nombre, apellidoP, apellidoM, anio, mes, dia));
                System.out.println(x1);
                break;
        }



    }
}