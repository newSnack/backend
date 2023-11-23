package sogang.capstoneDesign2.newSnack.auth;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

  private String accessToken;
  private String refreshToken;

}
