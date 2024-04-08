package com.gsm.platfra.api.data.account.otp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TAccountOTPRepository extends JpaRepository<TAccountOTP, Long> {
  Optional<TAccountOTP> findByUserId(String userId);
}
