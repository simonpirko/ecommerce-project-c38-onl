package by.tms.ecommerceprojectc38onl.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO {
    @NotBlank(message = "The name mustn't be empty")
    private String name;

    @NotBlank(message = "The description mustn't be empty")
    private String description;

    @Positive(message = "The price must be above 0")
    private BigDecimal price;

    @PositiveOrZero(message = "The quantity cannot be below 0")
    private Integer quantity;

    @NotNull(message = "СategoryId is required for update")
    @Positive(message = "СategoryId must be positive")
    private Long categoryId;
}
