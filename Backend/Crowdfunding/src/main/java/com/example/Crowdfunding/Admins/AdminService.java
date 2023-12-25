package com.example.Crowdfunding.Admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setEmail(adminDetails.getEmail());
            admin.setPassword(adminDetails.getPassword());
            return adminRepository.save(admin);
        }
        return null;
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

   // public Admin loginAdmin(String email, String password) {
        // Find the admin by email
        //Admin admin = adminRepository.findByEmail(email);

        // Check if admin exists and password matches
        //if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            // Password matches, return the authenticated admin
          //  return admin;
        //}
        // Authentication failed
      //  return null;
    //}
        public boolean authenticateAdmin(String email, String password) {
            Admin admin = adminRepository.findByEmail(email);

            if (admin != null && admin.getPassword().equals(password)) {
                // Passwords match, login successful
                return true;
            } else {
                // Either admin not found or password doesn't match
                return false;
            }
        }
}
