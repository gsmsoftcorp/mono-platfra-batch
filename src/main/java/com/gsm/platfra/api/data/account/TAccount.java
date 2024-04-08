package com.gsm.platfra.api.data.account;

import com.gsm.platfra.api.data.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "T_ACCOUNT")
public class TAccount extends BaseEntity {
    @Id
    @Size(max = 64)
    @Column(name = "USER_ID", nullable = false, length = 64)
    private String userId;
    
    @Size(max = 64)
    @Column(name = "EMAIL", length = 64)
    private String email;
    
    @Size(max = 11)
    @Column(name = "PHONE", length = 11)
    private String phone;

    @NotNull
    @Column(name = "PASSWORD", nullable = false, length = 64)
    private String password;
    
    @Size(max = 64)
    @Column(name = "USER_NM", length = 64)
    private String userNm;

    @Size(max = 100)
    @Column(name = "NICKNAME", length = 100)
    private String nickname;
    
    @Column(name = "AGE")
    private Integer age;
    
    @Column(name = "GENDER")
    private Character gender;
    
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    
    @Column(name = "BANNED_YN")
    private Boolean bannedYn;

    public void update(String newPassword, PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(newPassword);
    }
    
}