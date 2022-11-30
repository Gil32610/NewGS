package Game;

public class Game {
    private String title;
    private ageRating rating;
    private String genre;
    private Integer releaseDate;
    private double price;
    private int sold;

    public Game(String title, ageRating rating, String genre, Integer releaseDate, double price) {
        this.price = price;
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.sold = 0;
    }

    public Game(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ageRating getRating() {
        return this.rating;
    }

    public void setRating(ageRating rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void sale() {
        this.sold++;
    }

    @Override
    public String toString() {
        return "Game [title=" + title + ", rating=" + rating + ", genre=" + genre + ", releaseDate=" + releaseDate
                + ", price=" + price + "sold=" + this.sold + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            Game g = (Game) obj;
            return this.getTitle().equals(g.getTitle());
        }
        return false;
    }

}
