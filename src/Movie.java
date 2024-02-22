public class Movie {
    //String attributes
    private String title;
    private String director;
    private String genre;

    //Integer attributes
    private int yearCreated;
    private int lengthInMinutes;
    private int id;

    //Boolean attributes
    private boolean isInColor;

    public Movie(int id, String title, String director, String genre, int yearCreated, int lengthInMinutes, boolean isInColor) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.yearCreated = yearCreated;
        this.lengthInMinutes = lengthInMinutes;
        this.isInColor = isInColor;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String setTitle(String title) {
        this.title = title;
        return "Has been changed to: "+title;
    }

    public String setDirector(String director) {
        this.director = director;
        return "Has been changed to: "+director;
    }

    public String setGenre(String genre) {
        this.genre = genre;
        return "Has been changed to: "+ genre;
    }

    public String setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
        return "Has been changed to: "+yearCreated;
    }

    public String setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
        return "Has been changed to: "+lengthInMinutes;
    }

    public String setInColor(boolean inColor) {
        isInColor = inColor;
        return "Has been changed to: "+inColor;
    }
}
