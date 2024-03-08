package dive.dev.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private UUID id;
    private String username;
    private String name;
    private String surname;
}
