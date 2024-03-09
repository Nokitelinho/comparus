package com.comparus.primary.component;

import com.comparus.common.mapper.UserMapper;
import com.comparus.model.UserModel;
import com.comparus.primary.models.PrimaryUserDetail;
import com.comparus.primary.repo.PrimaryUserRepository;
import com.comparus.primary.specification.PrimaryUserSpecification;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PrimaryUserComponent {
    private final PrimaryUserRepository primaryUserRepository;
    private final UserMapper userMapper;

    public List<UserModel> findAll() {
        return primaryUserRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public List<UserModel> findUser(UUID uuid, String username, String name, String surname) {
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
