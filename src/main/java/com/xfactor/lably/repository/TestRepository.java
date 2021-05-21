package com.xfactor.lably.repository;

import java.util.List;

import com.xfactor.lably.entity.Test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
    
    Test findByName(String name);

    List<Test> findTop5By();
}
