/**
 * Created by branden on 2/10/16 at 12:22.
 */
public class Book {

    public String title, author, shortDescription;
    public int isbn, year;
    public char rating;

    private final char[] RATINGS = {'A', 'B', 'C', 'D'};  //we don't keep no F books here dawg

    public Book() {

    }


    public Book(String title, String author, String shortDescription, int isbn, int year, char rating) {
        this.title = title;
        this.author = author;
        this.shortDescription = shortDescription;
        this.isbn = isbn;
        this.year = year;
        this.rating = rating;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription() {
        System.out.println("Enter a short description of the book");
        this.shortDescription = BookStore.scanner.nextLine();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        System.out.println("Enter the Authors name");
        this.author = BookStore.scanner.nextLine();
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn() {
        System.out.println("Enter the books ISBN");
        this.isbn = Integer.parseInt(BookStore.scanner.nextLine());
    }

    public int getYear() {
        return year;
    }

    public void setYear() {
        System.out.println("Enter the year published");
        this.year = Integer.parseInt(BookStore.scanner.nextLine());
    }

    public char getRating() {
        return rating;
    }

    public void setRating() {
        System.out.println("Enter the books rating");
        // display the ratings real quick-like
        for (int i = 0; i < RATINGS.length; i++) {
            System.out.printf("%d.) %s%n", (i + 1), RATINGS[i]);
        }
        this.rating = RATINGS[(Integer.parseInt(BookStore.scanner.nextLine()) -1)];
    }


    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", isbn=" + isbn +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}