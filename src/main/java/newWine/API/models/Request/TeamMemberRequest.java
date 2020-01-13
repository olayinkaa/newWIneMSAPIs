package newWine.API.models.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import newWine.API.models.Cell;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamMemberRequest {


    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String phoneNumber;

    private String gender;

    private String role;

    private String occupation;


    private Long cell_id;

}
