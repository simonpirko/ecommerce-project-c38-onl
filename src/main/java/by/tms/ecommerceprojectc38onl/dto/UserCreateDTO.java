package by.tms.ecommerceprojectc38onl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {
    @NotBlank
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "The password cannot be blank")
    @Size(min = 8, message = "The password must contain at least 8 characters")
    private String password;

    private String confirmPassword;

    @NotBlank(message = "The phone cannot be blank")
    private String phone;

}
