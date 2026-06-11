# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Test Commands

```bash
# 빌드
./gradlew build          # Windows: gradlew.bat build

# 테스트 전체 실행
./gradlew test

# 특정 테스트 클래스 실행
./gradlew test --tests "org.example.BowlingGameTest"

# 특정 메서드 하나만 실행
./gradlew test --tests "org.example.BowlingGameTest.testStrike"

# 빌드 캐시 초기화
./gradlew clean
```

## Project Structure

- **언어/빌드:** Java + Gradle 9.3.0 (Kotlin DSL)
- **테스트 프레임워크:** JUnit 5 (Jupiter, BOM 6.0.0)
- **그룹:** `org.example`, **버전:** `1.0-SNAPSHOT`

소스 코드는 `src/main/java/`, 테스트는 `src/test/java/` 아래에 위치합니다.

## Architecture

볼링 게임 도메인 프로젝트입니다. 현재 소스 코드 구현이 없는 초기 스켈레톤 상태이며, 볼링 점수 계산 로직을 Java로 구현하는 것이 목적입니다.

핵심 도메인 개념:
- **Frame:** 프레임당 최대 2번 투구 (10번째 프레임은 최대 3번)
- **Strike:** 1투구에 10핀 전부 넘어뜨림 → 다음 2투구 점수 보너스
- **Spare:** 2투구에 10핀 전부 넘어뜨림 → 다음 1투구 점수 보너스
- **Game:** 10프레임, 최고 점수 300점
