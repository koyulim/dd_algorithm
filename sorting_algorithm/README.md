07 정렬
# Integer vs int 배열

<br>

| 배열 타입 | Comparator 사용 가능 여부 | 해결 방법 |
|---|---|---|
| int[][] (2차원 배열) | 가능 Comparator<int[]> | Arrays.sort(int[][], Comparator<int[]>) |
| Integer[] (객체 배열) | 가능 (Comparator<Integer>) | Arrays.sort(Integer[], Comparator<Integer>) |
| int[]` (기본 타입 배열) | 불가능 | Integer[]로 변환 |

따라서, 기본 타입 배열(int[])는 오름차순 정렬만 가능하고고 Comparator 사용 할 시 Integer[]로 변환해야함