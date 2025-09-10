package com.example.swpbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.swpbackend.dto.request.RoleRequest;
import com.example.swpbackend.dto.response.RoleResponse;
import com.example.swpbackend.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions",ignore = true)
    Role toRole(RoleRequest roleRequest);
    RoleResponse toRoleResponse(Role role);
}
