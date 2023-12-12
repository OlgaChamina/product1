package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(3, "Платье", 3_500);
    Product product2 = new Product(45, "Костюм", 9_800);
    Product product3 = new Product(28, "Пиджак", 7_200);

    @Test
    public void shouldDeleteRelevantId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(45);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteIrreledantId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(33);
        });
    }

}
