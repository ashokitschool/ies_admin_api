package in.ashokit.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="IES_USERS")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String fullName;
    private String email;
    private String pwd;
    private Long mobileNo;
    private String gender;
    private LocalDate dob;
    private Long ssn;

    private String accStatus;
    private String activeSw;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<PlanEntity> plans;
}
