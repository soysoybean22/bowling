# TDD Plan — 거터 게임 (Gutter Game)

## 이번 사이클에서 검증할 동작
20번 모두 0핀을 쓰러뜨리면 총점은 0이다.

## 테스트 시나리오
- Given: 새 Game 인스턴스
- When: roll(0)을 20번 호출
- Then: score() == 0

## API 설계 (예상)
```java
public class Game {
    public void roll(int pins) { ... }
    public int score() { ... }
}
```

## 엣지 케이스 (이번 사이클 범위 외)
- 모든 핀 1개씩 (일반 게임)
- 스페어
- 스트라이크
- 퍼펙트 게임
