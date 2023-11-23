package sogang.capstoneDesign2.newSnack.auth;

public class TokenValidFailedException extends RuntimeException {

  public TokenValidFailedException() {
    super("Failed to generate Token.");
  }

  private TokenValidFailedException(String message) {
    super(message);
  }
}
