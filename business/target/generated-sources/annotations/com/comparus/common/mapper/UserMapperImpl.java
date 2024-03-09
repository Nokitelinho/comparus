package com.comparus.common.mapper;

import com.comparus.model.UserModel;
import com.comparus.primary.models.PrimaryUserDetail;
import com.comparus.secondary.models.SecondaryUserDetail;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-09T18:37:47+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel toDto(PrimaryUserDetail primaryUserDetail) {
        if ( primaryUserDetail == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( primaryUserDetail.getId() );
        userModel.setUsername( primaryUserDetail.getUsername() );
        userModel.setName( primaryUserDetail.getName() );
        userModel.setSurname( primaryUserDetail.getSurname() );

        return userModel;
    }

    @Override
    public UserModel toDto(SecondaryUserDetail secondaryUserDetail) {
        if ( secondaryUserDetail == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( secondaryUserDetail.getId() );
        userModel.setUsername( secondaryUserDetail.getUsername() );
        userModel.setName( secondaryUserDetail.getName() );
        userModel.setSurname( secondaryUserDetail.getSurname() );

        return userModel;
    }
}
