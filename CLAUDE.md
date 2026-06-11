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

## 볼링 점수 계산 (The Bowling Game Kata)

### 문제 설명

미국식 텐핀 볼링(American Ten-Pin Bowling) 한 게임의 유효한 투구 순서가 주어졌을 때, 해당 게임의 최종 총점을 계산하는 프로그램을 작성하십시오.

가벼운 연습(Kata)을 위해 아래 사항들은 고려하지 않습니다.

- 투구가 유효한지 확인하지 않습니다.
- 투구 횟수나 프레임 수가 정확한지 확인하지 않습니다.
- 중간 프레임의 점수를 제공하지 않습니다.

### 볼링 점수 규칙 요약

볼링 게임은 총 10개 프레임으로 구성됩니다. 각 프레임에서 플레이어는 10개의 핀을 쓰러뜨리기 위해 두 번의 투구(Roll) 기회를 가집니다. 프레임 점수는 쓰러뜨린 총 핀 수에 스트라이크와 스페어에 따른 보너스를 더해 계산합니다.

- **스페어 (Spare):** 두 번의 투구로 10개의 핀을 모두 쓰러뜨린 경우. 해당 프레임의 보너스는 다음번 투구(1회)에서 쓰러뜨린 핀의 수입니다.
- **스트라이크 (Strike):** 첫 번째 투구에서 10개의 핀을 모두 쓰러뜨린 경우. 이 경우 해당 프레임은 한 번의 투구로 종료됩니다. 해당 프레임의 보너스는 이후 두 번의 투구에서 쓰러뜨린 핀 수의 합계입니다.
- **10번 프레임:** 마지막 10번 프레임에서 스페어나 스트라이크를 기록한 플레이어는 프레임을 완수하기 위해 추가 투구를 할 수 있습니다. 단, 10번 프레임에서는 최대 세 번까지 투구할 수 있습니다.

### 요구사항 (Requirements)

다음 두 가지 메서드를 가진 `Game` 클래스를 작성하십시오.

1. `void roll(int pins)` — 플레이어가 공을 던질 때마다 호출됩니다. 인자값(pins)은 쓰러뜨린 핀의 수입니다.
2. `int score()` — 게임의 총점을 계산하여 반환합니다.
