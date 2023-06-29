package pe.edu.pucp.msuser.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer userId;
    private String firstname;
    private String lastname;
    private String email;
}
