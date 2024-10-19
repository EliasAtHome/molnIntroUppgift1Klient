package EliasAtHome;

import java.io.IOException;
import java.util.Scanner;

import static EliasAtHome.HttpClientHelper.BASE_URL;


public class AuthorService {
    private HttpClientHelper httpClientHelper = new HttpClientHelper();

    public void addAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Författarens namn: ");
        String name = scanner.nextLine();
        System.out.print("Ålder: ");
        int age = scanner.nextInt();

        String jsonBody = "{\"name\": \"" + name + "\", \"age\": " + age + "}";

        String response = httpClientHelper.postRequest("authors", jsonBody);

        System.out.println("Svar från servern: " + response);
    }

    public void getAllAuthors() {
        String response = httpClientHelper.getRequest("authors");
        System.out.println("Författare i systemet:");
        System.out.println(response);
    }


    public void updateAuthor() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Författarens ID: ");
        String authorId = scanner.nextLine();
        System.out.print("Nytt namn: ");
        String name = scanner.nextLine();
        System.out.print("Ny ålder: ");
        int age = scanner.nextInt();

        String jsonBody = "{\"id\": " + authorId + ", \"name\": \"" + name + "\", \"age\": " + age + "}";

        String response = httpClientHelper.putRequest(BASE_URL + "authors/" + authorId, jsonBody);

        System.out.println("Svar från servern: " + response);
    }

    public void deleteAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Författarens ID att ta bort: ");
        String authorId = scanner.nextLine();

        String response = httpClientHelper.deleteRequest("authors/" + authorId);

        System.out.println("Svar från servern: " + response);
    }
}