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
                    "Exit: Stop programmet");
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("add")) {
                System.out.println("Type information of movie as follows. Remember commas (,): Title, Director, Genre, Year, Length in Minutes, Movie in color? (Type true if in color. Type false if black and white)");

                String movieString = scanner.nextLine().trim();
                String[] movieAttributes = movieString.replaceAll("\\s*,\\s*", ",").split(",");

                movieCollection.addMovie(movieAttributes[0],movieAttributes[1],movieAttributes[2],Integer.parseInt(movieAttributes[3]),Integer.parseInt(movieAttributes[4]),Boolean.parseBoolean(movieAttributes[5]));
            }
            if(input.equalsIgnoreCase("list")) {
                System.out.println(movieCollection.getList());;
            }
        }while(!input.equalsIgnoreCase(SENTINAL));


    }


}
