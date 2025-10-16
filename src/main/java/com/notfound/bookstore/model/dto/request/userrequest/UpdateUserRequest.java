package com.notfound.bookstore.model.dto.request.userrequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserRequest {
    String fullName;

    @Email(message = "Invalid email format")
    String email;

    @Pattern(regexp = "^(\\+84|0)[0-9]{9}$", message = "Invalid phone number")
    String phoneNumber;

    @Pattern(regexp = "^(Male|Female|Other)$")
    String gender;
}
