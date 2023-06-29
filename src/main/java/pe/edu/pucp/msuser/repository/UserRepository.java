package pe.edu.pucp.msuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.pucp.msuser.entity.User;
import pe.edu.pucp.msuser.dto.UserSummaryDto;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u.USER_ID as 'userId',\n" +
            " u.NAME as 'firstname',\n" +
            " u.LASTNAME as 'lastname',\n" +
            " u.EMAIL as 'email',\n" +
            " r.ROL_ID as 'rolId',\n" +
            " r.NAME as 'rolName',\n" +
            " c.PASSWORD as 'password'\n" +
            "FROM pucp_stack.pstk_user u\n" +
            "INNER JOIN pucp_stack.pstk_credential c ON c.CREDENTIAL_ID = u.FK_CREDENTIAL_ID\n" +
            "INNER JOIN pucp_stack.pstk_rol r ON r.ROL_ID = u.FK_ROL_ID;", nativeQuery = true)
    List<UserSummaryDto> findAllUserSummary();


    // UserDetailDto findUserDetailById();

}
