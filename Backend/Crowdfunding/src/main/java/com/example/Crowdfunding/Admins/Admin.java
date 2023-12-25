package com.example.Crowdfunding.Admins;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCE_ADMINS")
    @SequenceGenerator(name = "SEQUENCE_ADMINS", sequenceName = "admins_admin_id_seq", allocationSize = 1)
    private int admin_id;

    private String email;
    private String password;

}
