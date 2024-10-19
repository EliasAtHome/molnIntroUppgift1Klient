package EliasAtHome;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private BookService bookService = new BookService();
    private AuthorService authorService = new AuthorService();

    public void showMainMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Välkommen till Elias bok- och författarhantering");
            System.out.println("1. Hantera alla Böcker.");
            System.out.println("2. Hantera Författare.");
            System.out.println("3. Avsluta");
            System.out.print("Välj ett alternativ: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBookMenu();
                    break;
                case 2:
                    showAuthorMenu();
                    break;
                case 3:
                    System.out.println("Avslutar...");
                    return;
                default:
                    System.out.println("Tyvärr ett ogiltigt val, försök igen.");
            }
        }
    }

    private void showBookMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bokmeny:");
        System.out.println("1. Lägg till en ny bok.");
        System.out.println("2. Visa alla böcker som finns i databasen.");
        System.out.println("3. Uppdatera befintlig bok.");
        System.out.println("4. Ta bort bok.");
        System.out.print("Välj ett alternativ: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                bookService.addBook();
                break;
            case 2:
                bookService.getAllBooks();
                break;
            case 3:
                bookService.updateBook();
                break;
            case 4:
                bookService.deleteBook();
                break;
            default:
                System.out.println("Tyvärr ett ogiltigt val.");
        }
    }

    private void showAuthorMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Författarmeny:");
        System.out.println("1. Lägg till en författare.");
        System.out.println("2. Visa alla författare som finns i databasen.");
        System.out.println("3. Uppdatera befintlig författare.");
        System.out.println("4. Ta bort författare.");
        System.out.print("Välj ett alternativ: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                authorService.addAuthor();
                break;
            case 2:
                authorService.getAllAuthors();
                break;
            case 3:
                authorService.updateAuthor();
                break;
            case 4:
                authorService.deleteAuthor();
                break;
            default:
                System.out.println("Tyvärr ett ogiltigt val.");
        }
    }
}