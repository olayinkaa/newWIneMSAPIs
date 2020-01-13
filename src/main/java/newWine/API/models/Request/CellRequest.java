package newWine.API.models.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CellRequest {


        private String cellLocation;

        private Integer cellZone;

        private String cellLeader;

        private String email;

        private String phoneNumber;

}
