package sogang.capstoneDesign2.newSnack.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRefreshTokenRepository extends JpaRepository<UserRefreshToken, Long> {

  Optional<UserRefreshToken> findByUserId(String userId);

  Optional<UserRefreshToken> findByUserIdAndRefreshToken(String userId, String refreshToken);
}
