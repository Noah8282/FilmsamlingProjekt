import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class MovieCollection {

    private List<Movie> movieCollection;


    public MovieCollection() {
        movieCollection = new CopyOnWriteArrayList<>();
    }


    public void addMovie(String str) {

        String[] movieAttributes = str.trim().replaceAll("\\s*,\\s*", ",").split(",");

        if(movieAttributes.length == 6) {
            movieCollection.add(new Movie(movieAttributes[0],movieAttributes[1],movieAttributes[2],Integer.parseInt(movieAttributes[3]),Integer.parseInt(movieAttributes[4]),Boolean.parseBoolean(movieAttributes[5])));
        } else {
            System.out.println("All requested inputs was not entered correctly.");
        }
    }

    public String getList() {
        StringBuilder list = new StringBuilder();
        movieCollection.forEach(m -> {
            list.append(
                    "################\n" +
                            "Title: " + m.getTitle() + "\n" +
                            "Director: " + m.getDirector() + "\n" +
                            "Genre: " + m.getGenre() + "\n" +
                            "Year: " + m.getYearCreated() + "\n" +
                            "Length: " + m.getLengthInMinutes() + " min\n" +
                            "Color: " + ((m.isInColor()) ? "Colored" : "Black/White") + "\n" +
                            "################\n");
        });

        return list.toString();
    }

    public String search(String searchElement, String searchString) {

        List<Movie> matchingElements = searchHelper(searchElement, searchString);

        if (!matchingElements.isEmpty()) {
            String returnString = "##### Search results #####\n";
            returnString += convertToMovieList(matchingElements);
            return returnString;
        }
        return "##### No matching search results #####";
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

        List<Movie> matchingElements = movieCollection.stream()
                .filter(movie -> getter.apply(movie).toLowerCase().trim().contains(searchString.toLowerCase()))
                .toList();

        return matchingElements;
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


