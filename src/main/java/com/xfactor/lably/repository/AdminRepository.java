package com.xfactor.lably.repository;

import java.util.List;
import com.xfactor.lably.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>{
    
    Admin findByUsername(String username);

    List<Admin> findTop5By();
}