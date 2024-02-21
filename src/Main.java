import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String SENTINAL = "exit";
        MovieCollection movieCollection = new MovieCollection();
        String input = "";
        do {
            System.out.println("Velkommen til filmsamling!: Tryk følgende:\n" +
                    "Add: Tilføj film\n" +
                    "List: Se liste over film\n" +
                    "Search: Søg på en film\n" +
                    "Exit: Stop programmet");
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("add")) {
                System.out.println("Type information of movie as follows. Remember commas (,): Title, Director, Genre, Year, Length in Minutes, Movie in color? (Type true if in color. Type false if black and white)");

                movieCollection.addMovie(scanner.nextLine());
            }
            if(input.equalsIgnoreCase("list")) {
                System.out.println(movieCollection.getList());;
            }
            if(input.equalsIgnoreCase("search")) {
                System.out.println("Which category do you want to search in? (Title, Director, Genre, Year, Minutes (length in minutes), Colored");
                String searchElement = scanner.next();
                scanner.nextLine();
                System.out.println("Write what you want to search for:");
                String searchString = scanner.next();
                scanner.nextLine();

                try {
                    System.out.println(movieCollection.search(searchElement, searchString));
                } catch (Exception e) {
                    System.out.println("Invalid search element: " + searchElement);
                }
            }
            System.out.println("\n\n\n");
        }while(!input.equalsIgnoreCase(SENTINAL));


    }


}
