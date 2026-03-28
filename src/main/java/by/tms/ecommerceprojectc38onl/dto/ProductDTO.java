package by.tms.ecommerceprojectc38onl.dto;

import by.tms.ecommerceprojectc38onl.validation.OnCreate;
import by.tms.ecommerceprojectc38onl.validation.OnUpdate;
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
public class ProductDTO {
    @NotBlank (groups = { OnCreate.class, OnUpdate.class }, message = "The name mustn't be empty")
    private String name;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class }, message = "The description mustn't be empty")
    private String description;

    @Positive(groups = { OnCreate.class, OnUpdate.class }, message = "The price must be above 0")
    private BigDecimal price;

    @PositiveOrZero(groups = { OnCreate.class, OnUpdate.class }, message = "The quantity cannot be below 0")
    private Integer quantity;

    @NotNull(groups = { OnCreate.class, OnUpdate.class }, message = "СategoryId is required for update")
    @Positive(groups = { OnCreate.class, OnUpdate.class }, message = "СategoryId must be positive")
    private Long categoryId;
}
