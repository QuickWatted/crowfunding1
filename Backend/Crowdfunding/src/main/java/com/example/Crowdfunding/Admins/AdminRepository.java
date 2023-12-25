package com.example.Crowdfunding.Admins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);

    Admin findByEmailAndPassword(String email, String password);
}
