public class Controller {
    MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    public void addMovie(String str) {
        movieCollection.addMovie(str);
    }

    public String getList() {
        return movieCollection.getList();
    }

    public String search(String searchElement, String searchString) {
        return movieCollection.search(searchElement,searchString);
    }

    public String removeMovie(String searchElement, String searchString) {
        return movieCollection.removeMovie(searchElement,searchString);
    }

    public String editMovie(String searchElement, String searchString) {
        return movieCollection.editMovie(searchElement,searchString);
    }



}
