package sogang.capstoneDesign2.newSnack.auth.info;

import sogang.capstoneDesign2.newSnack.user.Provider;

import java.util.Map;

public class OAuth2UserInfoFactory {

  public static OAuth2UserInfo getOAuth2UserInfo(Provider provider,
      Map<String, Object> attributes) {
    switch (provider) {
      case GOOGLE:
        return new GoogleOAuth2UserInfo(attributes);
      case KAKAO:
        return new KakaoOAuth2UserInfo(attributes);
      default:
        throw new IllegalArgumentException("Invalid Provider.");
    }
  }
}
