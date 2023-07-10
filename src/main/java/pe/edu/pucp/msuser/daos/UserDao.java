package pe.edu.pucp.msuser.daos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.pucp.msuser.entity.Rol;
import pe.edu.pucp.msuser.entity.User;

@Data
@Component
public class UserDao {

    private User user;
    private Rol rol;
}
