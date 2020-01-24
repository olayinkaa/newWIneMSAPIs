package newWine.API.models.Request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamMemberRequest {


    @NotBlank(message = "First Name is required")
    @Size(min = 2, message = "First Name should have atleast 2 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    private String middleName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    @Size(min = 11, message = "Phone number should be atleast 11 digits")
    private String phoneNumber;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Unit Role is Required")
    private String role;

    private String occupation;

    private Long cellId;

}
