package by.tms.ecommerceprojectc38onl.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    @Positive
    private Long productId;

    @Positive
    @Min(value = 0, message = "The quantity must be more than 0")
    private int quantity;
}
