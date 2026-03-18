package by.tms.ecommerceprojectc38onl.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private Long sellerId;
    private Long categoryId;

    @NotEmpty
    @NotBlank
    private String name;

    @NotEmpty
    @NotBlank
    private String description;

    @NotEmpty
    @NotBlank
    private BigDecimal price;

    @NotEmpty
    @NotBlank
    private Integer quantity;
}
