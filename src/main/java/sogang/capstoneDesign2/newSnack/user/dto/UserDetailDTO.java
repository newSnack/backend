package sogang.capstoneDesign2.newSnack.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDetailDTO {

  private Long id;
  private String name;
  private String userId;
}
