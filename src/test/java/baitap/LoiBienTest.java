package baitap;

import static baitap.Bai.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Issue 2: nhanh loi, dieu kien bien, vong lap, ngoai le. */
class LoiBienTest {
    @Test void chuViCanhKhongHopLe() {
        assertThrows(IllegalArgumentException.class, () -> Bai.chuVi(0, 1));
        assertThrows(IllegalArgumentException.class, () -> Bai.chuVi(1, -1));
    }
    @Test void dienTichCanhKhongHopLe() {
        assertThrows(IllegalArgumentException.class, () -> Bai.dienTich(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> Bai.dienTich(1, 0));
    }
    @Test void ptVoSoNghiem() { assertThrows(ArithmeticException.class, () -> giaiPTBac2(0, 0, 0)); }
    @Test void ptBacNhatVoNghiem() { assertEquals(0, giaiPTBac2(0, 0, 5).length); }
    @Test void thangKhongHopLe() {
        assertThrows(IllegalArgumentException.class, () -> soNgayTrongThang(0, 2023));
        assertThrows(IllegalArgumentException.class, () -> soNgayTrongThang(13, 2023));
    }
    @Test void namNhuanBien() {
        assertEquals(29, soNgayTrongThang(2, 2000));
        assertEquals(28, soNgayTrongThang(2, 1900));
    }
    @Test void nguyenToBien() {
        assertFalse(laSoNguyenTo(-5));
        assertFalse(laSoNguyenTo(0));
        assertFalse(laSoNguyenTo(1));
        assertTrue(laSoNguyenTo(2));
        assertTrue(laSoNguyenTo(Integer.MAX_VALUE));
    }
    @Test void tongBien() {
        assertEquals(1, tongDenN(1));
        assertThrows(IllegalArgumentException.class, () -> tongDenN(0));
    }
    @Test void uclnBien() {
        assertEquals(5, Bai.ucln(0, 5));
        assertEquals(4, Bai.ucln(-8, 12));
        assertThrows(IllegalArgumentException.class, () -> Bai.ucln(0, 0));
    }
    @Test void giaiThuaBien() {
        assertEquals(1, Bai.giaiThua(0));
        assertEquals(2432902008176640000L, Bai.giaiThua(20));
        assertThrows(IllegalArgumentException.class, () -> Bai.giaiThua(-1));
        assertThrows(IllegalArgumentException.class, () -> Bai.giaiThua(21));
    }
    @Test void tongGiaiThuaBien() {
        assertEquals(1, Bai.tongGiaiThua(1));
        assertThrows(IllegalArgumentException.class, () -> Bai.tongGiaiThua(0));
        assertThrows(IllegalArgumentException.class, () -> Bai.tongGiaiThua(21));
    }
}
