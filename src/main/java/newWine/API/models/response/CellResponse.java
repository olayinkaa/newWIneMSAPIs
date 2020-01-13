package newWine.API.models.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CellResponse {

    private  Long id;
    private String cellLocation;

    private Integer cellZone;

    private String cellLeader;

    private String email;

    private String phoneNumber;

}
