package newWine.API.models;


import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@ApiModel(description="This model is for New Wine Members")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "team_member")
public class TeamMember {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id", nullable = false)
        private Long id;

        @NotBlank(message = "First Name is required")
        @Size(min=2, message="First Name should have atleast 2 characters")
        @Column(name="first_name",length = 20)
        private String firstName;

        @NotBlank(message = "Last Name is required")
        @Column(name="last_name", length = 20)
        private String lastName;

        @Column(name="middle_name", length = 20)
        private String middleName;

        @NotBlank(message = "Email is required")
        @Email(message = "Please enter a valid email address")
        @Column(name="email", nullable = false, unique = true)
        private String email;

        @Column(name="phone_number")
        private String phoneNumber;

        @NotBlank(message = "Gender is required")
        @Column(name="gender", length = 10)
        private String gender;

        @NotBlank(message = "Unit Role is Required")
        @Column(name="role", length = 10)
        private String role;

        @Column(name="occupation")
        private String occupation;



}
