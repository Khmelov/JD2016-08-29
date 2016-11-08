package by.it.sukora.JD02_10.TaskA;

/**
 * Created by Sukora Stas.
 */

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
class Author {

    private int id = 0;
    private String name;
    private List books = new ArrayList<String>();

    public Author() {};

    public Author(String name, String[] books) {
        this.id = ++id;
        this.name = name;
        setNames(books);
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return name;
    }

    public List getBooks() {
        return books;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String name) {
        this.name = name;
    }

    public void setNames(String[] books) {
        for (String book: books)
            this.books.add(name);
    }

    public void setNames(List books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return new String().format("Author POJO: {\nid = %s,\nname = %s,\nbooks = %s\n}", id, name, books);
    }

}
