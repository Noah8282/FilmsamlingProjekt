public class Movie {
    //String attributes
    private String title;
    private String director;
    private String genre;

    //Integer attributes
    private int yearCreated;
    private int lengthInMinutes;

    //Boolean attributes
    private boolean isInColor;

    public Movie(String title, String director, String genre, int yearCreated, int lengthInMinutes, boolean isInColor) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.yearCreated = yearCreated;
        this.lengthInMinutes = lengthInMinutes;
        this.isInColor = isInColor;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public boolean isInColor() {
        return isInColor;
    }
}
