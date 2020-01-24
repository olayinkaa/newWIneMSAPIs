package newWine.API.persistence.entity;


import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;


@ApiModel(description = "This model is for New Wine Members")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "team_members")
public class TeamMember implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(name = "middle_name", length = 20)
    private String middleName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String occupation;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "role", length = 10)
    private String role;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cell_fk")
    private Cell cell;

    private Timestamp dateCreated;

    private Timestamp dateUpdated;

    @PrePersist
    protected void onCreate() {
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        this.dateUpdated = new Timestamp(System.currentTimeMillis());
    }

}
