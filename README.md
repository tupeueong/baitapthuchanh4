# Bài thực hành 04 – Kiểm thử hộp trắng (Java + JUnit 5)

Mã nguồn: [`Bai.java`](src/main/java/baitap/Bai.java) – 8 chương trình, mỗi chương trình là một phương thức.
Test: [`HopLeTest`](src/test/java/baitap/HopLeTest.java) (Issue 1), [`LoiBienTest`](src/test/java/baitap/LoiBienTest.java) (Issue 2).
Log chạy JUnit: [`test-log.txt`](test-log.txt) – 27 test, 0 lỗi.

Chạy: `mvn test` (hoặc biên dịch bằng `javac` và chạy `junit-platform-console-standalone`).

## Phân tích mã nguồn & test case

| # | Phương thức | Nhánh điều kiện | Vòng lặp | Đường đi logic → test case |
|---|---|---|---|---|
| 1 | `chuVi(d, r)` | d≤0 hoặc r≤0 | – | (a) hợp lệ: (3,4)=14; (b) lỗi: (0,1), (1,-1) → `IllegalArgumentException` |
| 2 | `dienTich(d, r)` | d≤0 hoặc r≤0 | – | (3,4)=12; (-1,1), (1,0) → exception |
| 3 | `giaiPTBac2(a,b,c)` | a=0 / b=0 / c=0; delta <0, =0, >0 | – | (0,0,0) → `ArithmeticException`; (0,0,5) → rỗng; (0,2,-4) → {2}; (1,0,1) → rỗng; (1,2,1) → {-1}; (1,-3,2) → {1,2} |
| 4 | `soNgayTrongThang(t, n)` | t∉[1,12]; switch 30/28-29/31; năm nhuận | – | t=0,13 → exception; t=1 → 31; t=4 → 30; 2/2023 → 28; 2/2024 → 29; 2/2000 → 29; 2/1900 → 28 |
| 5 | `laSoNguyenTo(n)` | n<2; n%i==0 | `for i*i≤n` | -5,0,1 → false; 2 → true (không vào vòng lặp); 9 → false (thoát sớm); 7, MAX_INT → true (lặp hết) |
| 6 | `tongDenN(n)` | n<1 | `for 1..n` | n=0 → exception; n=1 (lặp 1 lần) → 1; n=5 → 15 |
| 7 | `ucln(a,b)` | a=b=0 | `while b≠0` | (0,0) → exception; (0,5) → 5 (lặp 1 lần); (12,18) → 6; (-8,12) → 4 |
| 8 | `giaiThua(n)`, `tongGiaiThua(n)` | n<0 hoặc n>20; n<1 hoặc n>20 | `for 2..n`; `for 1..n` | giaiThua: -1, 21 → exception; 0 → 1 (không lặp); 5 → 120; 20 → 2432902008176640000. tongGiaiThua: 0, 21 → exception; 1 → 1; 4 → 33 |

Các test bao phủ 100% câu lệnh và 100% nhánh của `Bai.java` (đã đối chiếu thủ công theo bảng trên; chưa đo bằng JaCoCo).

## Issue
- Issue 1: Viết test JUnit kiểm thử hộp trắng cho các luồng xử lý hợp lệ → `HopLeTest`
- Issue 2: Viết test JUnit kiểm thử hộp trắng cho nhánh lỗi, điều kiện biên, vòng lặp, ngoại lệ → `LoiBienTest`
