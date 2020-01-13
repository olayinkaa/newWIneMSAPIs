package newWine.API.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberDtos implements Serializable {

    private static final long serialVersionUID = 6376062362813985833L;

    private Long id;

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
