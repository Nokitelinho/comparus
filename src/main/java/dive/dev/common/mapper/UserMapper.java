package dive.dev.common.mapper;

import dive.dev.common.dto.UserDTO;
import dive.dev.primary.models.PrimaryUserDetail;
import dive.dev.secondary.models.SecondaryUserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    UserDTO toDto(PrimaryUserDetail primaryUserDetail);

    UserDTO toDto(SecondaryUserDetail secondaryUserDetail);
}
