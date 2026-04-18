# KakaoImageSearch

> Kakao REST API를 활용한 이미지 검색 앱 — Android 학습 프로젝트

---

## Overview

Kakao 이미지 검색 API를 호출하고, 결과를 RecyclerView로 표시하는 Android 앱입니다.
Retrofit을 통한 REST API 통신, Glide를 활용한 이미지 로딩, Fragment 기반 탭 네비게이션 구현을 목표로 제작했습니다.

---

## Tech Stack

| Category | Stack |
|---|---|
| Language | Kotlin |
| Min SDK | 26 (Android 8.0) |
| Architecture | (학습 진행 중) |
| Network | Retrofit 3.0.0 + Gson |
| Image Loading | Glide 5.0.5 |
| UI | Material Design 3, ViewPager2, TabLayout |
| API | [Kakao Developers - 이미지 검색](https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-image) |

---

## Features

- [x] Kakao 이미지 검색 API 연동
- [x] 검색 결과 RecyclerView 표시 (ListAdapter + DiffUtil)
- [x] Glide 이미지 썸네일 로드
- [x] TabLayout + ViewPager2 탭 네비게이션
- [ ] 검색어 입력 → API 호출 연동
- [ ] 즐겨찾기 기능 (BookmarkFragment)
- [ ] 페이지네이션

---

## Project Structure

```
app/src/main/java/com/cret/kakaoimagesearch/
├── MainActivity.kt              # TabLayout + ViewPager2 진입점
├── SearchFragment.kt            # 검색 화면
├── BookmarkFragment.kt          # 즐겨찾기 화면 (미구현)
├── SearchItemAdapter.kt         # 검색 결과 ListAdapter
├── ViewPageAdapter.kt           # ViewPager2 어댑터
├── api/
│   └── ImageSearchRequestApi.kt # Retrofit 인터페이스
└── model/
    ├── Document.kt              # 이미지 데이터 모델
    ├── Meta.kt                  # 검색 메타 정보
    └── SearchNetworkResponse.kt # API 응답 래퍼
```

---

## Getting Started

### 1. Kakao API 키 발급

[Kakao Developers](https://developers.kakao.com/) 에서 앱을 생성하고 REST API 키를 발급받습니다.

### 2. API 키 설정

프로젝트 루트에 `apikey.properties` 파일을 생성합니다.

```properties
kakao_api_key="YOUR_KAKAO_REST_API_KEY"
```

> `apikey.properties`는 `.gitignore`에 등록되어 있습니다. 절대 커밋하지 마세요.

### 3. 빌드 및 실행

```bash
./gradlew assembleDebug
```

또는 Android Studio에서 `Run` 버튼으로 실행합니다.

---

## Key Learnings

- **Retrofit** 인터페이스 정의 및 `BuildConfig`를 통한 API 키 주입
- **Glide** 이미지 로딩 및 캐싱 옵션
- **ListAdapter + DiffUtil** 을 활용한 RecyclerView 성능 최적화
- **ViewPager2 + TabLayout** 탭 네비게이션 구조
- **apikey.properties** + `.gitignore` 를 통한 API 키 보안 관리

---

## License

학습 목적으로 제작된 프로젝트입니다.
