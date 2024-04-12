package datn.goodboy.service.serviceinterface;

import datn.goodboy.model.DTO.CartDto;

public interface CartService {
    CartDto updateCart(CartDto cart, Integer productId, Integer quantity, boolean isReplace);

    Integer getTotalQuantity(CartDto cart);

    Double getTotalPrice(CartDto cart);

    CartDto save(CartDto cart);
}
