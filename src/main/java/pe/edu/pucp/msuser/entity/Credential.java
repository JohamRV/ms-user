package pe.edu.pucp.msuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pstk_credential", schema = "pucp_stack")
public class Credential {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CREDENTIAL_ID")
    private Integer credentialId;

    @Basic
    @Column(name = "PASSWORD")
    private String password;

}
