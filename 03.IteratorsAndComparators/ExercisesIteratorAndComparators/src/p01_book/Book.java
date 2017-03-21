package p01_book;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;


    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);

        this.setAuthors(Arrays.asList(authors));
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book o) {
        if (this.getTitle().equals(o.getTitle())) {
            return Integer.compare(this.getYear(), o.getYear());
        }

        return this.getTitle().compareTo(o.getTitle());
    }
}
