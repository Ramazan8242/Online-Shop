package edu.attractor.onlineshop.DoMain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ClientRegistrationForm {
    @NotBlank
    @Email
    private String email = "";

    @Size(min=4, max=24, message = "Length must be >= 4 and <= 24")
    @Pattern(regexp = "^[^\\d\\s]+$", message = "Should contain only letters")
    private String name = "";

    @NotBlank
    private String password = "";
}
