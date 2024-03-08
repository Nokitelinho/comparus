package dive.dev.primary.component;

import dive.dev.common.dto.UserDTO;
import dive.dev.common.mapper.UserMapper;
import dive.dev.primary.models.PrimaryUserDetail;
import dive.dev.primary.repo.PrimaryUserRepository;
import dive.dev.primary.specification.PrimaryUserSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PrimaryUserComponent {
    private final PrimaryUserRepository primaryUserRepository;
    private final UserMapper userMapper;

    public List<UserDTO> findAll() {
        return primaryUserRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public List<UserDTO> findUser(UUID uuid, String username, String name, String surname) {
        Specification<PrimaryUserDetail> specification = Specification.where(Objects.nonNull(uuid) ? null : PrimaryUserSpecification.uuidEqual(uuid))
                .or(StringUtils.isBlank(username) ? null : PrimaryUserSpecification.usernameLike(username))
                .or(StringUtils.isBlank(name) ? null : PrimaryUserSpecification.nameLike(name))
                .or(StringUtils.isBlank(surname) ? null : PrimaryUserSpecification.surnameLike(surname));

        return primaryUserRepository.findAll(specification)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
