package app.controller;


import app.entity.ShoppingCart;
import app.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingCartController {


    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @PostMapping("/carts")
    public ResponseEntity<ShoppingCart> createCart() {
        ShoppingCart newCart = shoppingCartService.createNewShoppingCart();
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<ShoppingCart> getCart(@PathVariable Long id) {
        ShoppingCart cart = shoppingCartService.getShoppingCart(id);
        if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
