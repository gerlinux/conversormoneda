package complements;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultarCambio {

    public Moneda buscarCambio(String monedaBase, String monedaDestino){
        monedaBase = "USD";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1162567b8ae57216a2261ca2/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa pelicula.");
        }
    }
}
