# newSnack 서버 백엔드 개발
## 이슈 생성 컨벤션
### 제목
- **기능 추가**: `[feat] 간결한 설명`, 예: `[feat] 사용자 프로필 업데이트 기능 추가`.
- **버그**: `[fix] 간결한 설명`, 예: `[fix] 로그인 오류 수정`.
### 내용
- 만들어둔 템플릿 참고


## Pull Request 컨벤션
### 제목
- **기능 추가**: `feat: 간략한 설명`, 예: `feat: 사용자 프로필 업데이트 API 구현`.
- **버그 수정**: `fix: 간략한 설명`, 예: `fix: 로그인 오류 수정`.
- **리팩토링**: `refactor: 간략한 설명`, 예: `refactor: 사용자 서비스 코드 정리`.
### 내용
- 변경 사항과 이유, 영향을 받는 기능에 대한 설명을 포함한다

## Commit 메시지 컨벤션
### 제목
- **새 기능 추가**: `#이슈번호 feat: 간결한 설명`, 예: `#1 feat: 이메일 인증 기능 추가`.
- **버그 수정**: `#이슈번호 fix: 간결한 설명`, 예: `#1 fix: 로그인 오류 해결`.
- **문서 작업**: `#이슈번호 docs: 간결한 설명`, 예: `#1 docs: README 업데이트`.
- **스타일 변경**: `#이슈번호 style: 간결한 설명 (로직 변경 없음)`, 예: `#1 style: 코드 포맷팅 수정`.
- **리팩토링**: `#이슈번호 refactor: 간결한 설명`, 예: `#1 refactor: 로그인 서비스 코드 개선`.
- **테스트 추가/수정**: `#이슈번호 test: 간결한 설명`, 예: `#1 test: 사용자 등록 API 테스트 추가`.
- **기타 변경사항**: `#이슈번호 chore: 간결한 설명`, 예: `#1 chore: 라이브러리 업데이트`.
### 내용
- 변경의 동기, 주요 변경 사항, 참고 사항을 간략하게 기술한다

## Branch 명명 규칙
### 이름
- **기능 개발**: `feature/기능명`, 예: `feature/user-profile-update`.
- **버그 수정**: `fix/버그명`, 예: `fix/login-error`.
- **리팩토링**: `refactor/대상`, 예: `refactor/user-service`.
- **문서 작업**: `docs/주제`, 예: `docs/api-documentation`.
- **기타**: `chore/작업명`, 예: `chore/library-upgrade`.