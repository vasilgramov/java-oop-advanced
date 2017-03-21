package p01_book;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Library<Book> implements Iterable<Book> {
    private List<Book> bookList;

    public Library(Book... books) {
        this.setBookList(Arrays.asList(books));
    }

    public List<Book> getBookList() {
        return this.bookList;
    }

    private void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book> {
        private int index;

        private LibIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < bookList.size();
        }

        @Override
        public Book next() {
            return bookList.get(index++);
        }
    }
}
