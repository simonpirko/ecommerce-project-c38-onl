package by.tms.ecommerceprojectc38onl.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @NotNull
    Product product;

    @NotNull
    User user;

    @NotNull
    @Min(value = 1, message = "Quantity must be at least 1")
    int quantity;
}
