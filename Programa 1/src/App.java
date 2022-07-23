
import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    


    public static void main(String[] args) throws Exception {
      
       String url= "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
       URI endereco = URI.create (url);
       var client = HttpClient.newHttpClient();
       var request = HttpRequest.newBuilder(endereco).GET().build();
       HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
       String body = response.body();
       System.out.println(body);

       var parser = new JsonParser();
       List<Map<String, String>> ListaDeFilmes = parser.parse (body);

      // System.out.println(ListaDeFilmes.size()); Para imprimir o tamanho da lista consumida
      // System.out.println(ListaDeFilmes.get(0));
       
      for (Map<String, String> filme : ListaDeFilmes) {
       System.out.println(filme.get("title"));
       System.out.println(filme.get("image"));
       System.out.println(filme.get("imDbRating"));
       System.out.println(); 
      }
    }

}
