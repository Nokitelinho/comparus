package dive.dev.common.service;

import dive.dev.common.dto.UserDTO;
import dive.dev.primary.component.PrimaryUserComponent;
import dive.dev.secondary.component.SecondaryUserComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PrimaryUserComponent primaryUserComponent;
    private final SecondaryUserComponent secondaryUserComponent;

    public List<UserDTO> findAll() {
        var primaryUserList = primaryUserComponent.findAll();
        var secondaryUserList = secondaryUserComponent.findAll();

        return Stream.concat(primaryUserList.stream(), secondaryUserList.stream()).toList();
    }

    public List<UserDTO> findUser(UUID uuid, String username, String name, String surname) {
        var primaryUserList = primaryUserComponent.findUser(uuid, username, name, surname);
        var secondaryUserList = secondaryUserComponent.findUser(uuid, username, name, surname);

        return Stream.concat(primaryUserList.stream(), secondaryUserList.stream()).toList();
    }
}
