package ru.netology.Manager;

import org.junit.jupiter.api.Test;
import ru.netology.Domain.Book;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;
import ru.netology.Repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(1, "Name1", 100, "Author1");
    Product book2 = new Book(2, "Name2", 200, "Author2");
    Product book3 = new Book(3, "Name3", 300, "Author3");
    Product book4 = new Book(3, "Unique", 400, "Author4");
    Product smart1 = new Smartphone(4, "Name1", 500, "manufacturer1");
    Product smart2 = new Smartphone(5, "Name2", 600, "manufacturer2");
    Product smart3 = new Smartphone(6, "Name3", 700, "manufacturer3");


    @Test
    void shouldAdd() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        Product[] expected = {book1, book2, book3, book4, smart1, smart2, smart3};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldSearchByUnique() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        Product[] actual = manager.searchBy("que");
        Product[] expected = {book4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTwo() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(smart3);

        Product[] actual = manager.searchBy("me2");
        Product[] expected = {book2, smart2};
        assertArrayEquals(expected, actual);
    }
}