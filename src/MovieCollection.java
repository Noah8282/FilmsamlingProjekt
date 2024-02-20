import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MovieCollection {
    private StringBuilder list = new StringBuilder();

    private List<Movie> movieCollection;


    public MovieCollection() {
        movieCollection = new CopyOnWriteArrayList<>();
    }



    public void addMovie(String title, String director, String genre, int yearCreated, int lengthInMinutes, boolean isInColor) {
        movieCollection.add(new Movie(title, director, genre, yearCreated, lengthInMinutes, isInColor));
    }

    public String getList() {

        movieCollection.forEach(m -> {
            list.append(
                    "################\n" +
                    "Title: "+m.getTitle()+"\n"+
                    "Director: "+m.getDirector()+"\n"+
                    "Genre: "+m.getGenre()+"\n"+
                    "Year: "+ m.getYearCreated()+"\n"+
                    "Length: "+m.getLengthInMinutes()+" min\n"+
                    "Color: "+((m.isInColor()) ? "Colored" : "Black/White")+"\n"+
                    "################\n");
        });

        return list.toString();
    }

    public String search(int index) {

    }

}
