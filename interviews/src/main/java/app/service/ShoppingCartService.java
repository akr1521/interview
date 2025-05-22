package app.service;

import app.entity.CartItem;
import app.entity.Product;
import app.entity.ShoppingCart;
import app.repo.ShoppingCartDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;

    public ShoppingCartService(final ShoppingCartDao shoppingCartDao){
         this.shoppingCartDao  = shoppingCartDao;
    }


    @Transactional
    public ShoppingCart createNewShoppingCart() {
        return shoppingCartDao.createShoppingCart();
    }



    @Transactional(readOnly = true)
    public ShoppingCart getShoppingCart(Long id) {
        return shoppingCartDao.getShoppingCartById(id);
    }

    @Transactional
    public void addItemToShoppingCart(Long cartId, Long productId, int quantity) {
        ShoppingCart cart = shoppingCartDao.getShoppingCartById(cartId);
        Product product = shoppingCartDao.findProductById(productId); // Assuming you have this method in ProductDao or ShoppingCartDao

        if (cart != null && product != null) {
            shoppingCartDao.addItemToCart(cart, product, quantity);
        } else {
            throw new IllegalArgumentException("Cart with ID " + cartId + " or Product with ID " + productId + " not found.");
        }
    }

    @Transactional
    public void removeItemFromShoppingCart(Long cartId, Long productId) {
        ShoppingCart cart = shoppingCartDao.getShoppingCartById(cartId);
        Product product = shoppingCartDao.findProductById(productId); // Assuming you have this method

        if (cart != null && product != null) {
            shoppingCartDao.removeItemFromCart(cart, product);
        } else {
            throw new IllegalArgumentException("Cart with ID " + cartId + " or Product with ID " + productId + " not found.");
        }
    }

    @Transactional(readOnly = true)
    public List<CartItem> getShoppingCartItems(Long cartId) {
        ShoppingCart cart = shoppingCartDao.getShoppingCartById(cartId);
        if (cart != null) {
            return shoppingCartDao.getItemsInCart(cart);
        }
        return null; // Or throw an exception
    }

    @Transactional(readOnly = true)
    public double calculateTotalCost(Long cartId) {
        ShoppingCart cart = shoppingCartDao.getShoppingCartById(cartId);
        if (cart != null) {
            return cart.getTotalCost();
        }
        return 0.0; // Or throw an exception
    }

    @Transactional(readOnly = true)
    public Product findProductByName(String name) {
        return shoppingCartDao.findProductByName(name);
    }

    @Transactional
    public void addNewProduct(Product product) {
        shoppingCartDao.createProduct(product);
    }

    @Transactional(readOnly = true)
    public Product findProductById(Long productId) {

        return shoppingCartDao.findProductById(productId);
    }




}
