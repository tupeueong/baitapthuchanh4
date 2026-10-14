package baitap;

public class Bai {

    // 1
    public static double chuVi(double dai, double rong) {
        if (dai <= 0 || rong <= 0) throw new IllegalArgumentException("Canh phai > 0");
        return 2 * (dai + rong);
    }

    // 2
    public static double dienTich(double dai, double rong) {
        if (dai <= 0 || rong <= 0) throw new IllegalArgumentException("Canh phai > 0");
        return dai * rong;
    }

    // 3: tra ve mang nghiem (0, 1 hoac 2 phan tu); a == 0 -> giai pt bac 1; vo so nghiem -> ArithmeticException
    public static double[] giaiPTBac2(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) throw new ArithmeticException("Vo so nghiem");
                return new double[0];
            }
            return new double[]{-c / b};
        }
        double delta = b * b - 4 * a * c;
        if (delta < 0) return new double[0];
        if (delta == 0) return new double[]{-b / (2 * a)};
        double s = Math.sqrt(delta);
        return new double[]{(-b - s) / (2 * a), (-b + s) / (2 * a)};
    }

    // 4
    public static int soNgayTrongThang(int thang, int nam) {
        if (thang < 1 || thang > 12) throw new IllegalArgumentException("Thang khong hop le");
        switch (thang) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (nam % 400 == 0 || (nam % 4 == 0 && nam % 100 != 0)) ? 29 : 28;
            default:
                return 31;
        }
    }

    // 5
    public static boolean laSoNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 6
    public static long tongDenN(int n) {
        if (n < 1) throw new IllegalArgumentException("n phai >= 1");
        long s = 0;
        for (int i = 1; i <= n; i++) s += i;
        return s;
    }

    // 7
    public static int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) throw new IllegalArgumentException("a, b khong dong thoi bang 0");
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // 8a
    public static long giaiThua(int n) {
        if (n < 0 || n > 20) throw new IllegalArgumentException("n phai trong [0, 20]");
        long r = 1;
        for (int i = 2; i <= n; i++) r *= i;
        return r;
    }

    // 8b: n <= 20 de khong tran long (shortcut: dung long, can BigInteger neu n lon hon)
    public static long tongGiaiThua(int n) {
        if (n < 1 || n > 20) throw new IllegalArgumentException("n phai trong [1, 20]");
        long s = 0;
        for (int i = 1; i <= n; i++) s += giaiThua(i);
        return s;
    }
}
