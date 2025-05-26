package com.fts.studenttracker.service;

import com.fts.studenttracker.entity.Admin;
import com.fts.studenttracker.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> getAdminById(int id) {
        return adminRepository.findById(id);
    }

    public Optional<Admin> updateAdmin(int id, Admin updatedAdmin) {
        return adminRepository.findById(id).map(admin -> {
            admin.setUsername(updatedAdmin.getUsername());
            admin.setPassword(updatedAdmin.getPassword());
            // Add other fields if any
            return adminRepository.save(admin);
        });
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return adminRepository.existsById(id);
    }

    // New method to validate login credentials
    public boolean validateAdmin(String username, String password) {
        Optional<Admin> admin = adminRepository.findByUsername(username);
        return admin.map(a -> a.getPassword().equals(password)).orElse(false);
    }
}
