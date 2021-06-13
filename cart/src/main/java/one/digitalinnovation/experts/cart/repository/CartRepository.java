package one.digitalinnovation.experts.cart.repository;

import one.digitalinnovation.experts.cart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
