package views;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import services.GuiQLDoanhThu;
import services.QLDoanhThuService;

/**
 *
 * @author Ngọc Thanh
 */
public class FrmHienThiDoanhThu extends javax.swing.JFrame {

    private GuiQLDoanhThu guiDoanhThu;
    private List<String> lstNgay;

    public FrmHienThiDoanhThu() {
        initComponents();
        this.guiDoanhThu = new QLDoanhThuService();
        this.HienThiDoanhThuTrongTuan(7);
        //this.DoanhThuMotThang();
    }

    private void HienThiDoanhThuTrongTuan(int soNgay) {
        DefaultCategoryDataset dataset = themDuLieu(soNgay);
        String title = "Doanh Thu Trong Ngày";
        if (soNgay == 7) {
            title = "Doanh Thu Trong Tuần";
        }
        JFreeChart chart = ChartFactory.createLineChart(
                title, // Chart title  
                "Thời gian", // X-Axis Label  
                "Triệu", // Y-Axis Label  
                dataset, PlotOrientation.VERTICAL, true, false, false
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private DefaultCategoryDataset themDuLieu(int soNgay) {
        String series1 = "Doanh thu";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (soNgay == 1) {
            dataset.addValue(this.guiDoanhThu.GetDoanhThuBuoiSang(), series1, "7h - 11h59p");
            dataset.addValue(this.guiDoanhThu.GetDoanhThuBuoiTrua(), series1, "12h - 17h59p");
            dataset.addValue(this.guiDoanhThu.GetDoanhThuBuoiToi(), series1, "18h - 21h59p");
        } else if (soNgay == 7) {
            this.lstNgay = this.guiDoanhThu.Lay7NgayTruocDo();
            for (String s : lstNgay) {
                double tongTien = this.guiDoanhThu.GetDoanhThu1Ngay(s);
                dataset.addValue(tongTien, series1, s);
            }
        } else {
            dataset.addValue(6800000, "VNĐ", "Tuần 1");
            dataset.addValue(8000000, "VNĐ", "Tuần 2");
            dataset.addValue(8800000, "VNĐ", "Tuần 3");
            dataset.addValue(9500000, "VNĐ", "Tuần 4");
        }
        return dataset;
    }

    public void DoanhThuMotThang() {
        DefaultCategoryDataset dataset = themDuLieu(30);
        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh Thu Trong Một Tháng",
                "Tháng 12", "Triệu",
                dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel panel = new ChartPanel(barChart);
        setContentPane(panel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHienThiDoanhThu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
