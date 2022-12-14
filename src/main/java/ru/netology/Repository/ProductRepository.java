package ru.netology.Repository;

import ru.netology.Domain.NotFoundException;
import ru.netology.Domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product newItem) {
        Product[] tmp = new Product[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = newItem;
        items = tmp;
    }

    public Product findById(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }

        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : items) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        items = tmp;
        return null;
    }

    public Product[] findAll() {
        return items;
    }
}
