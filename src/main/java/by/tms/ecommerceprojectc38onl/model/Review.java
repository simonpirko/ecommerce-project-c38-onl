package by.tms.ecommerceprojectc38onl.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @NotNull
    private Long id;

    @NotNull
    private User user;

    @NotNull
    private Product product;


    private String comment;

    @NotNull(message = "Select a rating")
    private Integer rating;

    @NotNull
    private LocalDateTime createdAt;
}
