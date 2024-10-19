package EliasAtHome;

import java.io.IOException;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import static EliasAtHome.HttpClientHelper.BASE_URL;


public class BookService {

    static CloseableHttpClient httpClient = HttpClients.createDefault();
    private HttpClientHelper httpClientHelper = new HttpClientHelper();

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Författarens namn: ");
        String authorName = scanner.nextLine();

        String jsonBody = "{\"title\": \"" + title + "\", \"isbn\": \"" + isbn + "\", \"authorName\": \"" + authorName + "\"}";

        String response = httpClientHelper.postRequest("books", jsonBody);

        System.out.println("Svar från servern: " + response);
    }

    public void getAllBooks() {
        String response = httpClientHelper.getRequest("books");
        System.out.println("Böcker i systemet:");
        System.out.println(response);
    }

    public void updateBook() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bokens ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Ny titel: ");
        String title = scanner.nextLine();
        System.out.print("Nytt ISBN: ");
        String isbn = scanner.nextLine();


        String jsonBody = "{\"title\": \"" + title + "\", \"isbn\": \"" + isbn + "\"}";

        String response = httpClientHelper.putRequest(BASE_URL + "books/" + bookId, jsonBody);

        System.out.println("Svar från servern: " + response);
    }

    public void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bokens ID att ta bort: ");
        String bookId = scanner.nextLine();

        String response = httpClientHelper.deleteRequest("books/" + bookId);

        System.out.println("Svar från servern: " + response);
    }
}



