package by.tms.ecommerceprojectc38onl.dto;

import by.tms.ecommerceprojectc38onl.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemResponseDTO {
    private Long id;
    private Long totalPrice;
    private Product product;
    private int quantity;
}
