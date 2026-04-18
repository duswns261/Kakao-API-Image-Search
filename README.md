# 📱 Kakao API Image Search

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Retrofit2](https://img.shields.io/badge/Retrofit2-FF0000?style=for-the-badge)
![Glide](https://img.shields.io/badge/Glide-009688?style=for-the-badge)

카카오 이미지 검색 API를 활용하여 이미지를 검색하고, 마음에 드는 이미지를 보관함에 저장할 수 있는 안드로이드 학습용 프로젝트입니다. 🚀

## 📝 프로젝트 소개

안드로이드 앱 개발의 핵심 구성 요소들을 실습하기 위해 제작된 미니 프로젝트입니다. 
네트워크 통신부터 데이터 파싱, UI 구성 및 상태 관리, 그리고 API 키의 안전한 관리 방법까지 전반적인 안드로이드 개발 흐름을 익히는 데 목적을 두고 있습니다.

### ✨ 주요 기능
- **이미지 검색 (`SearchFragment`)**: 카카오 REST API를 연동하여 키워드로 이미지를 검색합니다.
- **이미지 보관함 (`BookmarkFragment`)**: 검색된 이미지 중 원하는 항목을 북마크하여 따로 모아볼 수 있습니다.
- **탭 네비게이션**: `ViewPager2`와 `TabLayout`을 활용하여 검색 화면과 보관함 화면을 스와이프하여 부드럽게 전환합니다.

## 🛠 Tech Stack

- **Language**: Kotlin
- **Architecture & UI**:
  - `ViewBinding`: 뷰 참조를 안전하게 처리
  - `ViewPager2` & `TabLayout`: 화면 페이징 처리
  - `RecyclerView`: 대량의 이미지 데이터 리스트 렌더링
- **Network & Media**:
  - `Retrofit2` & `Gson`: REST API 통신 및 JSON 데이터 파싱
  - `Glide`: 빠르고 부드러운 이미지 로딩 및 캐싱
- **Security**: 
  - `local.properties` / `apikey.properties`를 활용한 API Key 숨김 처리 (보안)

## 🗂 프로젝트 구조

```text
com.cret.kakaoimagesearch
 ┣ 📂 api               # Retrofit 인스턴스 및 API 인터페이스 정의
 ┣ 📂 model             # API 응답 데이터 모델 (Data Class)
 ┣ 📜 MainActivity.kt   # 메인 호스트 액티비티 (ViewPager2 설정)
 ┣ 📜 SearchFragment.kt # 이미지 검색 화면
 ┣ 📜 BookmarkFragment.kt # 보관함 화면
 ┣ 📜 SearchItemAdapter.kt # RecyclerView 어댑터 (검색 결과 및 보관함 아이템)
 ┗ 📜 Constants.kt      # 상수 관리
```

## 🚀 시작하기 (How to Run)

이 프로젝트를 로컬 환경에서 실행하려면 **카카오 REST API 키**가 필요합니다.

1. [Kakao Developers](https://developers.kakao.com/)에 접속하여 애플리케이션을 생성하고 `REST API 키`를 발급받습니다.
2. 프로젝트 최상단(root) 디렉토리에 `apikey.properties` 파일을 생성합니다.
3. 생성한 파일에 아래와 같이 발급받은 키를 입력합니다 (양쪽 따옴표 포함).
   ```properties
   kakao_api_key="KakaoAK 여기에_발급받은_REST_API_키를_입력하세요"
   ```
4. 안드로이드 스튜디오에서 프로젝트를 Sync(동기화)한 후 실행합니다.

> ⚠️ **주의:** `apikey.properties` 파일은 `.gitignore`에 등록되어 있어야 하며, 절대 Github에 커밋하여 퍼블릭으로 노출시키지 마세요!

## 🌱 학습 및 개선 포인트

- **성능 최적화**: Paging3 라이브러리를 도입하여 무한 스크롤(Pagination) 구현해보기
- **아키텍처 개선**: 현재의 기본 구조에서 MVVM 패턴으로 리팩토링 및 `LiveData`/`StateFlow` 적용해보기
- **의존성 주입**: Hilt를 적용하여 객체 생성 및 관리를 효율적으로 개선해보기
- **데이터 영속성**: Room Database를 적용하여 앱을 종료해도 보관함(Bookmark) 데이터가 유지되도록 구현해보기

---
*본 프로젝트는 안드로이드 개발 학습 목적으로 작성되었습니다.*
