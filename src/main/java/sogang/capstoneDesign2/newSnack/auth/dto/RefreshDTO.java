package sogang.capstoneDesign2.newSnack.auth.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshDTO {

  private String refreshToken;
}
