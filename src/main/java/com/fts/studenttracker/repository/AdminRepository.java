package com.fts.studenttracker.repository;

import com.fts.studenttracker.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    // Custom method to find Admin by username for login validation
    Optional<Admin> findByUsername(String username);
}
