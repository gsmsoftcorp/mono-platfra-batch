package com.gsm.platfra.api.data.account.otp;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountOTPDto {

  private Long otpSeq;

  @NotBlank(message = "아이디를 입력해 주세요.")
  private String userId;

  @NotBlank(message = "이메일을 입력해 주세요.")
  private String email;

  private String otp;

  private Boolean active;

}
