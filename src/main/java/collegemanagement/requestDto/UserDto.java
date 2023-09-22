package collegemanagement.requestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private int  UserId;
    private int  roleId;
    private String username;
    private String password;


}
