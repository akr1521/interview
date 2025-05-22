package app.repo;

import app.entity.CartItem;
import app.entity.Product;
import app.entity.ShoppingCart;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import  app.entity.CartItem;

import java.util.List;


public class ShoppingCartDao {

    private final SessionFactory sessionFactory;

    public ShoppingCartDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ShoppingCart createShoppingCart() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        ShoppingCart cart = new ShoppingCart();
        try {
            transaction = session.beginTransaction();
            session.save(cart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cart;
    }

    public Product findProductById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ShoppingCart getShoppingCartById(Long id) {
        Session session = sessionFactory.openSession();
        ShoppingCart cart = null;
        try {
            cart = session.get(ShoppingCart.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cart;
    }


    public void addItemToCart(ShoppingCart cart, Product product, int quantity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cart.addItem(cartItem);
            session.save(cartItem);
            session.update(cart); // Update the cart to reflect the new item
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void removeItemFromCart(ShoppingCart cart, Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            // Use HQL (Hibernate Query Language) to find the CartItem
            Query<CartItem> query = session.createQuery(
                    "FROM CartItem ci WHERE ci.cart = :cart AND ci.product = :product",
                    CartItem.class
            );
            query.setParameter("cart", cart);
            query.setParameter("product", product);
            CartItem itemToRemove = query.uniqueResult();

            if (itemToRemove != null) {
                cart.removeItem(itemToRemove);
                session.remove(itemToRemove);
                session.merge(cart); // Update the detached cart
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<CartItem> getItemsInCart(ShoppingCart cart) {
        try (Session session = sessionFactory.openSession()) {
            Query<CartItem> query = session.createQuery(
                    "FROM CartItem ci WHERE ci.cart = :cart",
                    CartItem.class
            );
            query.setParameter("cart", cart);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

        public Product findProductByName(String ename) {
            try (Session session = sessionFactory.openSession()) {
                Query<Product> query = session.createQuery(
                        "FROM Product p WHERE p.name = :name",
                        Product.class
                );
                query.setParameter("name", ename);
                return query.uniqueResult();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    public void createProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
