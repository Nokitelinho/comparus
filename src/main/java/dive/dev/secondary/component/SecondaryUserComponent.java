package dive.dev.secondary.component;

import dive.dev.common.dto.UserDTO;
import dive.dev.common.mapper.UserMapper;
import dive.dev.secondary.models.SecondaryUserDetail;
import dive.dev.secondary.repo.SecondaryUserRepository;
import dive.dev.secondary.specification.SecondaryUserSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SecondaryUserComponent {
    private final SecondaryUserRepository secondaryUserRepository;
    private final UserMapper userMapper;

    public List<UserDTO> findAll() {
        return secondaryUserRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();

    }

    public List<UserDTO> findUser(UUID uuid, String username, String name, String surname) {
        Specification<SecondaryUserDetail> specification = Specification.where(Objects.nonNull(uuid) ? null : SecondaryUserSpecification.uuidEqual(uuid))
                .or(StringUtils.isBlank(username) ? null : SecondaryUserSpecification.usernameLike(username))
                .or(StringUtils.isBlank(name) ? null : SecondaryUserSpecification.nameLike(name))
                .or(StringUtils.isBlank(surname) ? null : SecondaryUserSpecification.surnameLike(surname));

        return secondaryUserRepository.findAll(specification)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
