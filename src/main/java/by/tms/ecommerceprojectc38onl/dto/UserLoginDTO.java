package by.tms.ecommerceprojectc38onl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "The password cannot be blank")
    private String password;
}
