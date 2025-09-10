package com.example.swpbackend.configuration;
import java.util.HashSet;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.swpbackend.entity.Role;
import com.example.swpbackend.entity.User;
import com.example.swpbackend.enums.UserRole;
import com.example.swpbackend.repository.PermissionRepository;
import com.example.swpbackend.repository.RoleRepository;
import com.example.swpbackend.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@Configuration
@RequiredArgsConstructor 
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationInitConfig {
   final PasswordEncoder passwordEncoder;
   @Bean
   ApplicationRunner applicationRunner(UserRepository userRepository,RoleRepository roleRepository,PermissionRepository permissionRepository){ // nó luôn chạy khi app khởi động
      return _ ->{
       if (userRepository.findByUsername("admin").isEmpty()) {
    // Kiểm tra nếu role ADMIN chưa có thì tạo mới
Role roleAdmin = roleRepository.findByName("ADMIN")
        .orElseGet(() -> {
            Role newRole = Role.builder()
                    .name(UserRole.ADMIN.name())
                    .build();
            return roleRepository.save(newRole);
        });


    HashSet<Role> roles = new HashSet<>();
    roles.add(roleAdmin);

    User user = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("123456789"))
            .email("admin@gmail.com")
            .roles(roles)
            .build();

    userRepository.save(user);
}  


      };
   }   
}
