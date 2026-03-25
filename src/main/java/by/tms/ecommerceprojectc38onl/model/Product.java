package by.tms.ecommerceprojectc38onl.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Positive
    private Long id;

    @Positive
    private Long sellerId;

    @Positive
    private Long categoryId;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private BigDecimal price;

    @NotBlank
    private Integer quantity;
}
