package com.example.swpbackend.mapper;

import org.mapstruct.Mapper;

import com.example.swpbackend.dto.request.PermissionRequest;
import com.example.swpbackend.dto.response.PermissionResponse;
import com.example.swpbackend.entity.Permission;
@Mapper(componentModel = "spring")
public interface PermissionMapper {
   Permission  toPermission(PermissionRequest permissionRequest);
   PermissionResponse toPermissionResponse(Permission permission);
}
