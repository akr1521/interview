package app.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public List<CartItem> getItems () {
        return items;
    }

    public void setItems (List<CartItem> items) {
        this.items = items;
    }

    public void addItem (CartItem item) {
        item.setCart(this);
        this.items.add(item);
    }

    public void removeItem (CartItem item) {
        this.items.remove(item);
        item.setCart(null); // Maintain bidirectional relationship
    }

    public double getTotalCost () {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public String toString () {
        return "ShoppingCart{" +
                "id=" + id +
                ", items=" + items +
                ", totalCost=" + getTotalCost() +
                '}';
    }


}