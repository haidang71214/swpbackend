package com.example.swpbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.swpbackend.dto.request.UserRequest;
import com.example.swpbackend.dto.response.UserResponse;
import com.example.swpbackend.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
   @Mapping(target = "roles",ignore = true)
   @Mapping(target = "id",ignore = true)
   @Mapping(target = "imageUrl",ignore = true)
   @Mapping(target = "facebookId",ignore = true)
   @Mapping(target = "refreshtoken",ignore = true)
   @Mapping(target = "resetToken",ignore = true)
   User toUser(UserRequest userRequestDto);
   UserResponse toUserResponseDto(User user);
}
