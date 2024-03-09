package com.comparus.secondary.specification;

import com.comparus.secondary.models.SecondaryUserDetail;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class SecondaryUserSpecification {
    private SecondaryUserSpecification() {
    }

    public static Specification<SecondaryUserDetail> uuidEqual(UUID uuid) {
        return (root, query, builder) -> builder.equal(root.get("id"), uuid);
    }

    public static Specification<SecondaryUserDetail> usernameLike(String username) {
        return (root, query, builder) -> builder.like(root.get("username"), "%" + username + "%");
    }

    public static Specification<SecondaryUserDetail> nameLike(String name) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<SecondaryUserDetail> surnameLike(String surname) {
        return (root, query, builder) -> builder.like(root.get("surname"), "%" + surname + "%");
    }
}
