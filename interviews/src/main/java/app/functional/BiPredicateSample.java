package app.functional;

import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateSample {

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", 1200.00, true),
                new Product("Mouse", 25.00, true),
                new Product("Keyboard", 75.00, false),
                new Product("Monitor", 300.00, true),
                new Product("Webcam", 50.00, false)
        );

        BiPredicate<Product,Double>  isStockBelowPrice = ( product, minPrice) -> product.isInStock() &&  product.getPrice() <minPrice;
        boolean  isProdcutInRange = isStockBelowPrice.test( products.get(1), 500.00);
        System.out.println( " Is product in Range: "   +  isProdcutInRange);


    }





    private static class Product{
        String name;
        double price;
        boolean inStock;

        public Product(String name, double price, boolean inStock) {
            this.name = name;
            this.price = price;
            this.inStock = inStock;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public boolean isInStock() {
            return inStock;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", inStock=" + inStock +
                    '}';
        }
    }
}
