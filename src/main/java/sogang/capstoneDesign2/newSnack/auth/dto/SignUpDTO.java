package sogang.capstoneDesign2.newSnack.auth.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

  private String userId;
  private String password;
  private String name;
}
