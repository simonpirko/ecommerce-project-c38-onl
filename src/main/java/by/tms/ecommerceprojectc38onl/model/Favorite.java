package by.tms.ecommerceprojectc38onl.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {

    @NotNull
    private User user;

    @NotNull
    private Product product;
}
