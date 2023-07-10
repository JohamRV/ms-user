package pe.edu.pucp.msuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PSTK_ROL", schema = "pucp_stack")
public class Rol {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ROL_ID")
    private Integer rolId;

    @Basic
    @Column(name = "NAME")
    private String rolName;

    @Basic
    @Column(name = "DESCRIPTION")
    private String description;

}
