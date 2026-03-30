package by.tms.ecommerceprojectc38onl.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    @NotBlank
    private String comment;

    @NotNull(message = "Select a rating")
    @Min(1)
    @Max(5)
    private Integer rating;
}
