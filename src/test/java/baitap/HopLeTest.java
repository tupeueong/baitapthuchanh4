package baitap;

import static baitap.Bai.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Issue 1: luong xu ly hop le. */
class HopLeTest {
    @Test void chuVi() { assertEquals(14, Bai.chuVi(3, 4)); }
    @Test void dienTich() { assertEquals(12, Bai.dienTich(3, 4)); }
    @Test void ptHaiNghiem() { assertArrayEquals(new double[]{1, 2}, giaiPTBac2(1, -3, 2)); }
    @Test void ptNghiemKep() { assertArrayEquals(new double[]{-1}, giaiPTBac2(1, 2, 1)); }
    @Test void ptVoNghiem() { assertEquals(0, giaiPTBac2(1, 0, 1).length); }
    @Test void ptBacNhat() { assertArrayEquals(new double[]{2}, giaiPTBac2(0, 2, -4)); }
    @Test void ngay31() { assertEquals(31, soNgayTrongThang(1, 2023)); }
    @Test void ngay30() { assertEquals(30, soNgayTrongThang(4, 2023)); }
    @Test void thang2NamThuong() { assertEquals(28, soNgayTrongThang(2, 2023)); }
    @Test void thang2NamNhuan() { assertEquals(29, soNgayTrongThang(2, 2024)); }
    @Test void nguyenTo() { assertTrue(laSoNguyenTo(7)); }
    @Test void khongNguyenTo() { assertFalse(laSoNguyenTo(9)); }
    @Test void tong() { assertEquals(15, tongDenN(5)); }
    @Test void ucln() { assertEquals(6, Bai.ucln(12, 18)); }
    @Test void giaiThua() { assertEquals(120, Bai.giaiThua(5)); }
    @Test void tongGiaiThua() { assertEquals(33, Bai.tongGiaiThua(4)); }
}
