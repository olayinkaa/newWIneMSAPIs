package newWine.API.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@ApiModel(description="This model is for cell fellowship")
@Entity
@Table(name="cell")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;


    @NotBlank(message = "Cell location address is required")
    @Column(name="cell_location", nullable = false)
    private String cellLocation;


    @Column(name="cell_zone", nullable = false)
    private Integer cellZone;

    @NotBlank(message = "Cell Leader name is required")
    @Column(name = "cell_leader", nullable = false)
    private String cellLeader;

    @Column(name="email", unique = true, nullable = false)
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Cell Leader phone number is required")
    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cell")
//    @JsonIgnore
//    private TeamMember teamMember;








}
