package sogang.capstoneDesign2.newSnack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseMsgList {
  INVALID_ACCESS_TOKEN("유효하지 않은 액세스 토큰입니다."),
  NOT_EXPIRED("액세스 토큰이 아직 만료되지 않았습니다."),
  INVALID_REFRESH_TOKEN("유효하지 않은 리프레시 토큰입니다."),
  USER_ALREADY_EXISTS("중복된 아이디입니다."),
  NO_SUCH_USERID_AND_PASSWORD("아이디가 존재하지 않거나 비밀번호가 잘못 입력되었습니다."),
  NO_SUCH_USER_IN_DB("해당 유저의 정보가 DB에 존재하지 않습니다.");
  private final String msg;
}
