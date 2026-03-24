package by.tms.ecommerceprojectc38onl.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    @NotBlank(message = "The name mustn't be empty")
    private String name;

    @NotBlank(message = "The description mustn't be empty")
    private String description;

    @Positive(message = "The price must be above 0")
    private BigDecimal price;

    @PositiveOrZero(message = "The quantity cannot be below 0")
    private Integer quantity;

    @NotBlank(message = "The category name mustn't be empty")
    private Long categoryName;

    @NotBlank(message = "The seller name mustn't be empty")
    private Long sellerName;
}
