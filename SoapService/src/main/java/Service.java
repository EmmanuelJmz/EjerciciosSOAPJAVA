import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;
import java.util.Scanner;

@WebService(name = "Service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Service {
    @WebMethod (operationName = "random")
    public int random(@WebParam(name = "random") int numero){

        Random random = new Random();

        if (random.nextInt(3) == numero){
            return 1;
        }else {
            return 0;
        }
    }

    @WebMethod (operationName = "word")
    public String word(@WebParam(name = "word") String palabra){

        String consonantes = palabra.replaceAll("[aeiouAEIOU]", "");
        return consonantes;
    }

    @WebMethod (operationName = "rfc")
    public String rfc(@WebParam(name = "rfc") String nombre, String apellidoP, String apellidoM, String anio, String mes, String dia){

        char primerCaracter = apellidoP.charAt(0);
        char segundoCaracter = apellidoP.charAt(1);
        char tercerCaracter = apellidoM.charAt(0);
        char cuartoCaracter = nombre.charAt(0);

        String anio1 = "" + anio.charAt(2) + anio.charAt(3);
        String date = "" + anio1 + mes + dia;

        String homo="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
         int aleatorio = random.nextInt(35);
         int alea1 = random.nextInt(35);
         int alea2 = random.nextInt(35);
         char aleatorio1 = homo.charAt(aleatorio);
         char aleatorio2 = homo.charAt(alea1);
         char aleatorio3 = homo.charAt(alea2);
         String curp = "" + Character.toUpperCase(primerCaracter) + Character.toUpperCase(segundoCaracter)
         + Character.toUpperCase(tercerCaracter) + Character.toUpperCase(cuartoCaracter);

         String rfc;
         rfc = "" + curp + date + aleatorio1 + aleatorio2 +aleatorio3;

        return "" + rfc;
    }

    public static void main(String[] args) {
        System.out.println("Starting server . . .");
        Endpoint.publish("http://localhost:8082/Service", new Service());
        System.out.printf("Waiting request . . .");
    }
}