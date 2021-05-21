package com.xfactor.lably.repository;

import java.util.List;

import com.xfactor.lably.entity.Lab;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LabRepository extends JpaRepository<Lab, Long>{
    
    List<Lab> findTop5By();

    Lab findByName(String name);
}
