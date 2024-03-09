package com.comparus.primary.specification;

import com.comparus.primary.models.PrimaryUserDetail;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class PrimaryUserSpecification {
    private PrimaryUserSpecification() {
    }

    public static Specification<PrimaryUserDetail> uuidEqual(UUID uuid) {
        return (root, query, builder) -> builder.equal(root.get("id"), uuid);
    }

    public static Specification<PrimaryUserDetail> usernameLike(String username) {
        return (root, query, builder) -> builder.like(root.get("username"), "%" + username + "%");
    }

    public static Specification<PrimaryUserDetail> nameLike(String name) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<PrimaryUserDetail> surnameLike(String surname) {
        return (root, query, builder) -> builder.like(root.get("surname"), "%" + surname + "%");
    }
}
