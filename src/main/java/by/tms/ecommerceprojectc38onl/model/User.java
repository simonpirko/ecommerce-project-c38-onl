package by.tms.ecommerceprojectc38onl.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "The password cannot be blank")
    @Size(min = 8, message = "The password must contain at least 8 characters")
    private String password;

    @NotBlank(message = "The phone cannot be blank")
    private String phone;

    @NotNull
    private boolean isSeller;
}
