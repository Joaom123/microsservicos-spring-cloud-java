package one.digitalinnovation.experts.cart.controller;

import one.digitalinnovation.experts.cart.model.Cart;
import one.digitalinnovation.experts.cart.model.Item;
import one.digitalinnovation.experts.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartRepository  cartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;

        if (savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        } else {
            cart = savedCart.get();
        }

        List<Item> itemList = cart.getItems();
        itemList.add(item);

        System.out.println(cart.getItems());
        System.out.println(itemList);
        cart.setItems(itemList);
        System.out.println(cart.getItems());
        return cartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") Integer id) {
        cartRepository.deleteById(id);
    }
}
