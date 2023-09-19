import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class App {
    public static void main(String[] args) throws Exception {


        System.out.println("Hello, World!");
        try{
        // prueba ex https://jsonplaceholder.typicode.com/todos/1
        //URL http://datos.gob.es/apidata/nti/public-sector error 301 movido permanentemente
        URL url = new URL("https://valencia.opendatasoft.com/api/v2/catalog/datasets/contenidors-vidre-contenedores-vidrio/exports/json");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();

        //nos aseguramos que la url es correcta
        int responseCode = con.getResponseCode();
        if(responseCode != 200) throw new RuntimeException("error" + responseCode);

        System.out.println("200 confirmado");
        StringBuilder informacionString = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        while(scanner.hasNext()){
            informacionString.append(scanner.nextLine());
            informacionString.append("\n");
        }

        scanner.close();

         System.out.println(informacionString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
