package ru.netology.Repository;

import org.junit.jupiter.api.Test;
import ru.netology.Domain.Book;
import ru.netology.Domain.NotFoundException;
import ru.netology.Domain.Product;
import ru.netology.Domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositoryTest {

    private final ProductRepository repository = new ProductRepository();
    Product product1 = new Product(1, "Name1", 100);
    Product product2 = new Product(2, "Name2", 200);
    Product product3 = new Product(3, "Name3", 300);
    Product book1 = new Book(4, "Name4", 400, "Author1");
    Product book2 = new Book(5, "Name5", 500, "Author2");
    Product book3 = new Book(6, "Name6", 600, "Author3");
    Product smart1 = new Smartphone(7, "Name7", 700, "manufacturer1");
    Product smart2 = new Smartphone(8, "Name8", 800, "manufacturer2");
    Product smart3 = new Smartphone(9, "Name9", 900, "manufacturer3");


    @Test
    void shouldSave() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smart1);
        repository.save(smart2);
        repository.save(smart3);

        Product[] expected = {product1, product2, product3, book1, book2, book3, smart1, smart2, smart3};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveByIdOneNull() {
        repository.save(product1);

        repository.removeById(1);

        Product[] expected = {};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void shouldRemoveByIdException() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(8);
        });
    }

    @Test
    void shouldRemoveByIdOne() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smart1);
        repository.save(smart2);
        repository.save(smart3);

        repository.removeById(2);

        Product[] expected = {product1, product3, book1, book2, book3, smart1, smart2, smart3};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveById2Two() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smart1);
        repository.save(smart2);
        repository.save(smart3);

        repository.removeById(2);
        repository.removeById(8);

        Product[] expected = {product1, product3, book1, book2, book3, smart1, smart3};
        assertArrayEquals(expected, repository.findAll());
    }
}
