package sogang.capstoneDesign2.newSnack.auth.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenRefreshVO {

  private String accessToken;
  private String refreshToken;
}
