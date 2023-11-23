package sogang.capstoneDesign2.newSnack.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/* token 인증 필터 */
@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private final AuthTokenProvider authTokenProvider;

  String[] NO_CHECK_URLS = {"/api/auth/signup", "/api/auth/login", "/login", "/oauth2",
      "/favicon.ico"};

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    List<String> noCheckUrlList = new ArrayList<>(Arrays.asList(NO_CHECK_URLS));
    if (noCheckUrlList.contains(request.getRequestURI())) {
      filterChain.doFilter(request, response); // "/login" 요청이 들어오면, 다음 필터 호출
      return; // return으로 이후 현재 필터 진행 막기 (안해주면 아래로 내려가서 계속 필터 진행시킴)
    } else {
      for (String url : noCheckUrlList) {
        if (request.getRequestURI().startsWith(url)) {
          filterChain.doFilter(request, response);
          return;
        }
      }
    }
    String tokenStr = JwtHeaderUtil.getAccessToken(request);
    if (tokenStr != null) {
      AuthToken authToken = authTokenProvider.convertToAuthToken(tokenStr);
      if (authToken.validate()) {
        /* 토큰 유효 시 인증 적용 */
        Authentication authentication = authTokenProvider.getAuthentication(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    filterChain.doFilter(request, response);
  }
}
