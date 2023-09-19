import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class App {
    public static void main(String[] args) throws Exception {


        System.out.println("Hello, World!");
        try{
        //URL
        URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");

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
        }

        scanner.close();

         System.out.println(informacionString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
