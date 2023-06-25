package pe.edu.pucp.msuser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "pstk_user", schema = "pucp_stack")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_ID")
    private Integer userId;

    @Basic
    @Column(name = "NAME")
    @NotNull(message = "The name must not be null.")
    @NotBlank(message = "The name must not be empty.")
    @Size(max = 45, message = "The name must not be more than 45 characters.")
    private String name;

    @Basic
    @Column(name = "LASTNAME")
    @NotNull(message = "The lastname must not be null.")
    @NotBlank(message = "The lastname must not be empty.")
    @Size(max = 45, message = "The lastname must not be more than 45 characters.")
    private String lastname;

    @Basic
    @Column(name = "EMAIL")
    @NotNull(message = "The email must not be null.")
    @NotBlank(message = "The email must not be empty.")
    @Size(max = 45, message = "The email must not be more than 45 characters.")
    private String email;

    @Basic
    @Column(name = "DESCRIPTION")
    @Size(max = 255, message = "The description must not be more than 255 characters.")
    private String description;

    @Basic
    @Column(name = "FK_ROL_ID")
    @JsonIgnore
    private Integer rolId;

    @Basic
    @Column(name = "FK_SLICE_ID")
    @JsonIgnore
    private Integer sliceId;

    @Basic
    @Column(name = "FK_CREDENTIAL_ID")
    @JsonIgnore
    private Integer credentialId;

}
