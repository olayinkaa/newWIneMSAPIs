package newWine.API.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CellDtos implements Serializable {


    private static final long serialVersionUID = -7661661804868717303L;

    private Long id;

    private String cellLocation;

    private Integer cellZone;

    private String cellLeader;

    private String email;

    private String phoneNumber;

}
