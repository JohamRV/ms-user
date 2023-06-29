package pe.edu.pucp.msuser.util;

import org.springframework.stereotype.Component;
import pe.edu.pucp.msuser.dto.CredentialDto;
import pe.edu.pucp.msuser.dto.RolDto;
import pe.edu.pucp.msuser.dto.UserDto;

@Component
public class MapperUtility {

    public UserDto buildUserDto(Integer userId, String firstname, String lastname, String email) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setFirstname(firstname);
        userDto.setLastname(lastname);
        userDto.setEmail(email);
        return userDto;
    }

    public RolDto buildRolDto(Integer rolId, String rolName) {
        RolDto rolDto = new RolDto();
        rolDto.setRolId(rolId);
        rolDto.setRolName(rolName);
        return rolDto;
    }

    public CredentialDto buildCredentialDto(String password) {
        CredentialDto credentialDto = new CredentialDto();
        credentialDto.setPassword(password);
        return credentialDto;
    }

}
