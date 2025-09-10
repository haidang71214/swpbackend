package com.example.swpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swpbackend.entity.Permission;


public interface PermissionRepository extends JpaRepository<Permission, String> {
   
}
