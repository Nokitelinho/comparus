package com.comparus.common.mapper;

import com.comparus.model.UserModel;
import com.comparus.primary.models.PrimaryUserDetail;
import com.comparus.secondary.models.SecondaryUserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    UserModel toDto(PrimaryUserDetail primaryUserDetail);

    UserModel toDto(SecondaryUserDetail secondaryUserDetail);
}
