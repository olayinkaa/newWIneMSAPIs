package newWine.API.models.response;


import lombok.Data;

@Data
public class TeamMemberResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String phoneNumber;

    private String gender;

    private String role;

    private String occupation;

    private CellResponse cell;

}
