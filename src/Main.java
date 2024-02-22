import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        final String SENTINAL = "exit";
        String input = "";
        do {
            System.out.println("Velkommen til filmsamling!: Tryk følgende:\n" +
                    "Add: Tilføj film\n" +
                    "List: Se liste over film\n" +
                    "Search: Søg på en film\n" +
                    "Remove: Fjern en film fra listen\n" +
                    "Edit: Rediger en film\n" +
                    "Exit: Stop programmet");
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("add")) {
                System.out.println("Type information of movie as follows. Remember commas (,): Title, Director, Genre, Year, Length in Minutes, Movie in color? (Type true if in color. Type false if black and white)");

                controller.addMovie(scanner.nextLine());
            }
            if(input.equalsIgnoreCase("list")) {
                System.out.println(controller.getList());;
            }
            if(input.equalsIgnoreCase("search")) {
                System.out.println(getSearch(controller::search,scanner,controller));

            }
            if(input.equalsIgnoreCase("remove")) {
                System.out.println(getSearch(controller::removeMovie,scanner,controller));
            }
            if(input.equalsIgnoreCase("edit")) {
                System.out.println(getSearch(controller::editMovie,scanner,controller));
            }

            System.out.println();
        }while(!input.equalsIgnoreCase(SENTINAL));


    }

    private static String getSearch(BiFunction<String, String, String> methodRun, Scanner scanner, Controller controller) {
        System.out.println("Which category do you want to search in? (Title, Director, Genre, Year, Minutes (length in minutes), Colored)");
        String searchElement = scanner.next().trim();
        scanner.nextLine();
        System.out.println("Write what you want to search for:");
        String searchString = scanner.next().trim();
        scanner.nextLine();

        return methodRun.apply(searchElement,searchString);
    }


}
