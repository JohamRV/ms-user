package pe.edu.pucp.msuser.dto;

import org.springframework.beans.factory.annotation.Value;

public interface UserSummaryDto {

    @Value("#{@mapperUtility.buildUserDto(target.userId, target.firstname, target.lastname, target.email)}")
    UserDto getUserDetail();

    @Value("#{@mapperUtility.buildRolDto(target.rolId, target.rolName)}")
    RolDto getRol();


}
