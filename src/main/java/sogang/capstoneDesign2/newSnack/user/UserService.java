package sogang.capstoneDesign2.newSnack.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sogang.capstoneDesign2.newSnack.ResponseMsg;
import sogang.capstoneDesign2.newSnack.ResponseMsgList;
import sogang.capstoneDesign2.newSnack.user.dto.SignUpSocialUserDTO;
import sogang.capstoneDesign2.newSnack.user.dto.UpdateDTO;
import sogang.capstoneDesign2.newSnack.user.dto.UserDetailDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public ResponseEntity<?> signUpSocialUser(SignUpSocialUserDTO signUpSocialUserDTO) {
    String userIdStr = SecurityContextHolder.getContext().getAuthentication().getName();
    Long userId = Long.parseLong(userIdStr);
    Optional<User> userOptional = userRepository.findById(userId);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      user.setName(signUpSocialUserDTO.getName());
      userRepository.save(user);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(new ResponseMsg(ResponseMsgList.NO_SUCH_USER_IN_DB.getMsg()));
  }

  public ResponseEntity<?> getUserDetail() {
    String userIdStr = SecurityContextHolder.getContext().getAuthentication().getName();
    Long userId = Long.parseLong(userIdStr);
    Optional<User> userOptional = userRepository.findById(userId);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      return ResponseEntity.ok().body(
          UserDetailDTO.builder().name(user.getName()).userId(user.getUserId()).id(userId).build()
      );
    } else {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body(new ResponseMsg(ResponseMsgList.NO_SUCH_USER_IN_DB.getMsg()));
    }
  }

  public ResponseEntity<?> updateUser(UpdateDTO updateDTO) {
    String userIdStr = SecurityContextHolder.getContext().getAuthentication().getName();
    Long userId = Long.parseLong(userIdStr);
    Optional<User> userOptional = userRepository.findById(userId);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      user.setName(updateDTO.getName());
      userRepository.save(user);
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body(new ResponseMsg(ResponseMsgList.NO_SUCH_USER_IN_DB.getMsg()));
    }
  }

  public ResponseEntity<?> deleteUser() {
    String userIdStr = SecurityContextHolder.getContext().getAuthentication().getName();
    Long userId = Long.parseLong(userIdStr);
    Optional<User> userOptional = userRepository.findById(userId);
    if (userOptional.isPresent()) {
      userRepository.delete(userOptional.get());
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(new ResponseMsg(ResponseMsgList.NO_SUCH_USER_IN_DB.getMsg()));
  }
}
