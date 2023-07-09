package supports;

/**
 *
 * @author Ngọc Thanh
 */
public class DocSoThanhChuoi {

    private int DemSoChuSo(double n) {
        return (int) (Math.log10(n) + 1);
    }

    private int DemDauPhay(double n) {
        int dem = 0;
        int demsoluongchuso = DemSoChuSo(n);
        while (demsoluongchuso > 3) {
            if (demsoluongchuso % 3 == 1) {
                dem++;
                demsoluongchuso--;
            }
            if (demsoluongchuso % 3 == 2) {
                dem++;
                demsoluongchuso -= 2;
            }
            if (demsoluongchuso % 3 == 0 && demsoluongchuso > 3) {
                dem++;
                demsoluongchuso -= 3;
            }
        }
        return dem;
    }

    private String DocSoCoMotChuSo(double n) {
        if (n == 1) {
            return "Một ";
        } else if (n == 2) {
            return "Hai ";
        } else if (n == 3) {
            return "Ba ";
        } else if (n == 4) {
            return "Bốn ";
        } else if (n == 5) {
            return "Năm ";
        } else if (n == 6) {
            return "Sáu ";
        } else if (n == 7) {
            return "Bảy ";
        } else if (n == 8) {
            return "Tám ";
        } else if (n == 9) {
            return "Chín ";
        }
        return "không ";
    }

    private String DocSoCoHaiChuSo(double n) {
        int HangChuc = (int) (n / 10);
        int HangDonVi = (int) (n % 10);

        String res = "";
        if (HangChuc == 1) {
            res += "Mười ";
        } else {
            res += DocSoCoMotChuSo(HangChuc) + "Mươi ";
        }
        if (HangDonVi == 0) {
            res += "";
        } else if (HangDonVi == 5) {
            res += "Lăm ";
        } else if (HangDonVi == 1) {
            if (HangChuc != 1) {
                res += "Mốt ";
            } else {
                res += "Một ";
            }
        } else {
            res += DocSoCoMotChuSo(HangDonVi);
        }
        return res;
    }

    private String DocSoCoBaChuSo(double n) {
        String res = "";
        int HangTram = (int) (n / 100);
        int du = (int) (n % 100);
        int HangChuc = du / 10;
        int HangDonVi = du % 10;

        res += DocSoCoMotChuSo(HangTram);
        res += " Trăm ";

        if (HangChuc == 0) {
            if (HangDonVi == 0) {
                res += "";
            } else {
                res += " Linh " + DocSoCoMotChuSo(HangDonVi);
            }
        } else {
            res += DocSoCoHaiChuSo(du);
        }
        return res;
    }

    private String DocPhuAm(double n) {
        if (n == 1 || n == 4) {
            return " Nghìn ";
        } else if (n == 2 || n == 5) {
            return " Triệu ";
        } else if (n == 3 || n == 6) {
            return " Tỷ ";
        }
        return "";
    }

    public String DocSoHoanThien(double n) {
        if(n == 0){
            return "Không";
        }
        String res = "";
        int sodauphay = DemDauPhay(n);
        int SoMu = (int) Math.pow(10.0, 3 * sodauphay);

        int ChuSo = (int) (n / SoMu);
        int demsoluongchuso = DemSoChuSo(ChuSo);
        if (demsoluongchuso == 1) {
            res += DocSoCoMotChuSo(ChuSo);
        } else if (demsoluongchuso == 2) {
            res += DocSoCoHaiChuSo(ChuSo);
        } else {
            res += DocSoCoBaChuSo(ChuSo);
        }
        res += DocPhuAm(sodauphay);
        n %= SoMu;
        sodauphay--;

        while (n != 0) {
            SoMu = (int) Math.pow(10.0, 3 * sodauphay);
            ChuSo = (int) (n / SoMu);
            res += DocSoCoBaChuSo(ChuSo);
            res += DocPhuAm(sodauphay);
            n %= SoMu;
            sodauphay--;
        }
        return res.replaceAll("\\s{1,}", " ");
    }
}
