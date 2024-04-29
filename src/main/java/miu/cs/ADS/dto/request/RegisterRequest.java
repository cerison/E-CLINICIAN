package miu.cs.ADS.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Email is Required")
    private String email;

    @NotBlank(message = "Password is missing")
    private String password;

    @NotBlank(message = "name is Required")
    private String name;
}