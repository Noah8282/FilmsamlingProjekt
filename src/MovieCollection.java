import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class MovieCollection {

    private List<Movie> movieCollection;
    private int idCount = 0;
    private Scanner scanner = new Scanner(System.in);


    public MovieCollection() {
        movieCollection = new CopyOnWriteArrayList<>();
        movieCollection.add(new Movie(0,"Unicorn", "Noah", "Action", 2024, 120, true));
    }


    public void addMovie(String str) {

        String[] movieAttributes = str.trim().replaceAll("\\s*,\\s*", ",").split(",");

        if(movieAttributes.length == 6) {
            movieCollection.add(new Movie((idCount++),movieAttributes[0],movieAttributes[1],movieAttributes[2],Integer.parseInt(movieAttributes[3]),Integer.parseInt(movieAttributes[4]),Boolean.parseBoolean(movieAttributes[5])));
            System.out.println(idCount);
        } else {
            System.out.println("All requested inputs was not entered correctly.");
        }
    }

    public String getList() {
        String list = convertToMovieList(movieCollection);
        return (list.isBlank()) ? "No Movies are in the list" : list;
    }

    public String search(String searchElement, String searchString) {
        List<Movie> matchingElements;
        try {
             matchingElements = searchHelper(searchElement, searchString);
        } catch (Exception e) {
            return "Invalid search element: " + searchElement;
        }
        if (!matchingElements.isEmpty()) {
            String returnString = "##### Search results #####\n";
            returnString += convertToMovieList(matchingElements);
            return returnString;
        }
        return "##### No matching search results #####";
    }

    public String removeMovie(String searchElement, String searchString) {
        List<Movie> matchingElements;
        try {
             matchingElements = searchHelper(searchElement, searchString);
        } catch (Exception e) {
            return "Invalid search element: " + searchElement;
        }

        if(matchingElements.isEmpty()) {
            return "##### No matching search results #####";
        }

        System.out.println(convertToMovieList(matchingElements));
        System.out.println("#### This is the movies i found. Enter the number of the movie, you'd like to delete. ###");

        int movieNum = scanner.nextInt();
        if(movieNum < 1 || movieNum > matchingElements.size()) {
            return "Film nummeret du har indtastet eksistere ikke.";
        }

        for (int i = 0; i < movieCollection.size(); i++) {
            if(movieCollection.get(i).getId() == matchingElements.get(movieNum-1).getId()) {
                movieCollection.remove(i);
                return matchingElements.get(movieNum-1).getTitle() + " has been deleted!";
            }
        }

        return "The movie was not deleted successfully.";

    }

    public String editMovie(String searchElement, String searchString) {
        List<Movie> matchingElements;
        try {
            matchingElements = searchHelper(searchElement, searchString);
        } catch (Exception e) {
            return "Invalid search element: " + searchElement;
        }

        if(matchingElements.isEmpty()) {
            return "##### No matching search results #####";
        }

        System.out.println(convertToMovieList(matchingElements));
        System.out.println("#### This is the movies i found. Enter the number of the movie, you'd like to edit. ###");

        int movieNum = scanner.nextInt();
        if(movieNum < 1 || movieNum > matchingElements.size()) {
            return "Film nummeret du har indtastet eksistere ikke.";
        }

        Movie movieToEdit = null;

        for (int i = 0; i < movieCollection.size(); i++) {
            if(movieCollection.get(i).getId() == matchingElements.get(movieNum-1).getId()) {
                movieToEdit = movieCollection.get(i);
            }
        }

        String editFeedback = "0";
        while (!editFeedback.equals("-1")) {
            System.out.println("#### Enter which category you'd like to edit (Title, Director, Genre, Year, Minutes (length in minutes), Colored). Type exit when you are done editing this Movie ###");

            String categoryToEdit = scanner.next().trim().toLowerCase();
            scanner.nextLine();
            if(categoryToEdit.equals("exit")) {
                return "Edit has been exited.";
            }
            System.out.println("#### Enter the value you wish to be replaced. Remember int ###");
            String overwriteStringOnEdit = scanner.nextLine().trim();
            try {
                editFeedback = switch (categoryToEdit) {
                    case "title" -> movieToEdit.setTitle(overwriteStringOnEdit);
                    case "director" -> movieToEdit.setDirector(overwriteStringOnEdit);
                    case "genre" -> movieToEdit.setGenre(overwriteStringOnEdit);
                    case "year" -> movieToEdit.setYearCreated(Integer.parseInt(overwriteStringOnEdit));
                    case "minutes" -> movieToEdit.setLengthInMinutes(Integer.parseInt(overwriteStringOnEdit));
                    case "colored" -> movieToEdit.setInColor(Boolean.parseBoolean(overwriteStringOnEdit));
                    default -> "Not correct category inserted. Please try again.";
                };
            } catch (Exception e) {
                editFeedback = "Not correct value inserted. Please try again. Remember numbers cannot be text";
            }
            System.out.println(editFeedback);



        }








        return "Editing exited";

    }


    //Helper methods
    private List<Movie> searchHelper(String searchElement, String searchString) {


        Function<Movie, String> getter = switch (searchElement.toLowerCase()) {
            case "title" -> Movie::getTitle;
            case "director" -> Movie::getDirector;
            case "genre" -> Movie::getGenre;
            case "year" -> Movie -> String.valueOf(Movie.getYearCreated());
            case "minutes" -> Movie -> String.valueOf(Movie.getLengthInMinutes());
            case "colored" -> Movie -> String.valueOf(Movie.isInColor());
            default -> throw new IllegalArgumentException("Invalid search element: " + searchElement);
        };

        return movieCollection.stream()
                .filter(movie -> getter.apply(movie).toLowerCase().trim().contains(searchString.toLowerCase()))
                .toList();
    }

    private String convertToMovieList(List<Movie> list) {
        StringBuilder returnElements = new StringBuilder();
        int count = 1;
        for(Movie m : list) {
            returnElements.append("##### Movie "+ (count++) +" #######\n" +
                    "Title: " + m.getTitle() + "\n" +
                    "Director: " + m.getDirector() + "\n" +
                    "Genre: " + m.getGenre() + "\n" +
                    "Year: " + m.getYearCreated() + "\n" +
                    "Length: " + m.getLengthInMinutes() + " min\n" +
                    "Color: " + ((m.isInColor()) ? "Colored" : "Black/White") + "\n" +
                    "################\n");
        }

        return returnElements.toString();
    }
}


