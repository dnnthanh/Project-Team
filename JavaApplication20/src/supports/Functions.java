package supports;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Functions {

    public static String LoaiBoDau(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
        return temp;
    }

    public static String ChuanHoaChuoi(String s) {
        s = s.replaceAll("\\s{1,}", " ").trim().toLowerCase();
        String str[] = s.split("\\s");
        String kq = "";
        for (String st : str) {
            kq += st.substring(0, 1).toUpperCase() + st.substring(1) + " ";
        }
        return kq;
    }

    public static List<String> ThongTinNhanVien(String s) {
        s = s.replace("||", "|");

        List<String> lst = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, "|");
        while (st.hasMoreTokens()) {
            lst.add(st.nextToken());
        }
        return lst;
    }

    public static String ngayGioHienTai() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = current.format(formatter);

        return formatted;
    }

    public static Date getDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }
}
