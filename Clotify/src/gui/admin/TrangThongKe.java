/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui.admin;

import Service.ThongKeService;
import static Service.ThongKeService.mauList;
import static Service.ThongKeService.muaList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ThongKe;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
 *
 * @author ADMIN
 */
public class TrangThongKe extends javax.swing.JInternalFrame {

    /**
     * Creates new form Trang0
     */
    DefaultTableModel model;
    ThongKeService thongKeService = new ThongKeService();

    public TrangThongKe() {
        initComponents();
        ui_custom.deleteTitle(this);
        loadDataSPBC();

    }

    void loadDataSPBC() {
        int stt = 1;
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ThongKe t : thongKeService.getAllBanChay()) {
            model.addRow(new Object[]{
                stt,
                t.getMa(),
                t.getTen(),
                t.getLoai(),
                t.getSo(),
                t.getGia(),
                t.getChatlieu(),
                t.getMau(),
                t.getSize(),
                t.getThuonghieu(),
                t.getSoluongban()
            });
            stt++;
        }
    }

    void loadDataSPBC1() {
        int stt = 1;
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ThongKe t : thongKeService.getAllBanChayTheoTime(1)) {
            model.addRow(new Object[]{
                stt,
                t.getMa(),
                t.getTen(),
                t.getLoai(),
                t.getSo(),
                t.getGia(),
                t.getChatlieu(),
                t.getMau(),
                t.getSize(),
                t.getThuonghieu(),
                t.getSoluongban()
            });
            stt++;
        }
    }

    void loadDataSPBC30() {
        int stt = 1;
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ThongKe t : thongKeService.getAllBanChayTheoTime(30)) {
            model.addRow(new Object[]{
                stt,
                t.getMa(),
                t.getTen(),
                t.getLoai(),
                t.getSo(),
                t.getGia(),
                t.getChatlieu(),
                t.getMau(),
                t.getSize(),
                t.getThuonghieu(),
                t.getSoluongban()
            });
            stt++;
        }
    }

    void loadDataSPBC7() {
        int stt = 1;
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ThongKe t : thongKeService.getAllBanChayTheoTime(7)) {
            model.addRow(new Object[]{
                stt,
                t.getMa(),
                t.getTen(),
                t.getLoai(),
                t.getSo(),
                t.getGia(),
                t.getChatlieu(),
                t.getMau(),
                t.getSize(),
                t.getThuonghieu(),
                t.getSoluongban()
            });
            stt++;
        }
    }

    void loadDataSPBC365() {
        int stt = 1;
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ThongKe t : thongKeService.getAllBanChayTheoTime(365)) {
            model.addRow(new Object[]{
                stt,
                t.getMa(),
                t.getTen(),
                t.getLoai(),
                t.getSo(),
                t.getGia(),
                t.getChatlieu(),
                t.getMau(),
                t.getSize(),
                t.getThuonghieu(),
                t.getSoluongban()
            });
            stt++;
        }
    }

    public void updateLineChart() {
        PanelThongKe_LineChart.removeAll(); // Xóa tất cả các thành phần trong Panel trước khi vẽ lại
        LineChart_DoanhThu_Day(); // Vẽ lại biểu đồ
        PanelThongKe_LineChart.revalidate(); // Cập nhật giao diện
        PanelThongKe_LineChart.repaint(); // Vẽ lại Panel
    }

    void LineChart_DoanhThu_Day() {
        ThongKeService.layDoanhThu_TheoNgay_LineChart();
        // Định dạng số để không có dấu E
        DecimalFormat formatter = new DecimalFormat("#,###");
        // Tạo biểu đồ Line Chart
        XYChart chart = new XYChartBuilder()
                .width(PanelThongKe_LineChart.getWidth())
                .height(PanelThongKe_LineChart.getHeight())
                .title("Biểu đồ doanh thu")
                .xAxisTitle("Thời gian")
                .yAxisTitle("Doanh thu (VNĐ)")
                .build();
        chart.getStyler().setDecimalPattern("#,###");
        // Dữ liệu của đỉnh
        //chart.getStyler().setYAxisMax(Double.valueOf(lblDoanhThu.getText()));
        // Sử dụng định dạng ngày tháng cho trục X
        chart.getStyler().setDatePattern("yyyy-MM-dd");
        chart.addSeries("Doanh thu", ThongKeService.ngay, ThongKeService.doanhthu); // Sử dụng thang thay vì thangStr
        chart.getStyler().setChartBackgroundColor(new Color(246, 246, 249));
        XChartPanel<XYChart> chartPanel = new XChartPanel<>(chart);

        // Tạo JPanel để chứa biểu đồ
        PanelThongKe_LineChart.setLayout(new GridBagLayout());

        PanelThongKe_LineChart.add(chartPanel);
    }

    void LineChart_DoanhThu_7Day() {

        ThongKeService.layDoanhThu_Theo7Ngay_LineChart();
        // Định dạng số để không có dấu E
        DecimalFormat formatter = new DecimalFormat("#,###");
        // Tạo biểu đồ Line Chart
        XYChart chart = new XYChartBuilder()
                .width(PanelThongKe_LineChart.getWidth())
                .height(PanelThongKe_LineChart.getHeight())
                .title("Biểu đồ doanh thu")
                .xAxisTitle("Thời gian")
                .yAxisTitle("Doanh thu (VNĐ)")
                .build();
        chart.getStyler().setDecimalPattern("#,###");
        // Dữ liệu của đỉnh
        chart.getStyler().setYAxisMax(Double.valueOf(lblDoanhThu.getText()));
        // Sử dụng định dạng ngày tháng cho trục X
        chart.getStyler().setDatePattern("dd-MM-yyyy");

        chart.addSeries("Doanh thu", ThongKeService.ngay7, ThongKeService.doanhthu7);
        chart.getStyler().setChartBackgroundColor(new Color(246, 246, 249));
        XChartPanel<XYChart> chartPanel = new XChartPanel<>(chart);

        // Tạo JPanel để chứa biểu đồ
        PanelThongKe_LineChart.setLayout(new GridBagLayout());
        PanelThongKe_LineChart.add(chartPanel);
    }

    void LineChart_DoanhThu_Thang() {
        ThongKeService.layDoanhThu_TheoThang_LineChart();
        // Định dạng số để không có dấu E
        DecimalFormat formatter = new DecimalFormat("#,###");
        // Tạo biểu đồ Line Chart
        XYChart charts = new XYChartBuilder()
                .width(PanelThongKe_LineChart.getWidth())
                .height(PanelThongKe_LineChart.getHeight())
                .title("Biểu đồ doanh thu")
                .xAxisTitle("Thời gian")
                .yAxisTitle("Doanh thu (VNĐ)")
                .build();
        charts.getStyler().setDecimalPattern("#,###");
        // Dữ liệu của đỉnh
//        charts.getStyler().setYAxisMax(Double.valueOf(lblDoanhThu.getText()));
        charts.getStyler().setDatePattern("yyyy-MM");
        charts.addSeries("Doanh thu", ThongKeService.thang, ThongKeService.doanhthuthang);
        charts.getStyler().setChartBackgroundColor(new Color(246, 246, 249));
        XChartPanel<XYChart> chartPanel = new XChartPanel<>(charts);

        // Tạo JPanel để chứa biểu đồ
        PanelThongKe_LineChart.setLayout(new GridBagLayout());

        PanelThongKe_LineChart.add(chartPanel);
    }

    void LineChart_DoanhThu_Nam() {
        ThongKeService.layDoanhThu_TheoNam_LineChart();
        // Định dạng số để không có dấu E
        DecimalFormat formatter = new DecimalFormat("#,###");
        // Tạo biểu đồ Line Chart
        XYChart chartss = new XYChartBuilder()
                .width(PanelThongKe_LineChart.getWidth())
                .height(PanelThongKe_LineChart.getHeight())
                .title("Biểu đồ doanh thu")
                .xAxisTitle("Thời gian")
                .yAxisTitle("Doanh thu (VNĐ)")
                .build();
        chartss.getStyler().setDecimalPattern("#,###");
        // Dữ liệu của đỉnh
        chartss.getStyler().setYAxisMax(Double.valueOf(lblDoanhThu.getText()));
        chartss.addSeries("Doanh thu", ThongKeService.nam, ThongKeService.doanhthunam);
        chartss.getStyler().setChartBackgroundColor(new Color(246, 246, 249));
        XChartPanel<XYChart> chartPanel = new XChartPanel<>(chartss);

        // Tạo JPanel để chứa biểu đồ
        PanelThongKe_LineChart.setLayout(new GridBagLayout());

        PanelThongKe_LineChart.add(chartPanel);
    }

    void pie_mausac() {
        // Create Pie Chart
        PieChart chart = new PieChartBuilder().width(panelMauSac.getWidth()).height(panelMauSac.getHeight()).title("Màu sắc được ưa chuộng").build();

        for (int i = 0; i < mauList.size(); i++) {
            String mau = mauList.get(i);
            Integer mua = muaList.get(i);
            chart.addSeries(mau, mua);
        }

        chart.getStyler().setChartBackgroundColor(new Color(246, 246, 249));
        // Tạo XChartPanel từ biểu đồ
        XChartPanel<PieChart> chartPanel = new XChartPanel<>(chart);

        // Đặt layout của JPanel là GridBagLayout
        panelMauSac.setLayout(new GridBagLayout());
        // Đặt cấu hình của GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        panelMauSac.add(chartPanel,gbc);
        revalidate();
        repaint();
    }
    void pie_size() {
        // Create Pie Chart
        PieChart chart = new PieChartBuilder().width(panelSize.getWidth()).height(panelSize.getHeight()).title("Size được ưa chuộng").build();

        for (int i = 0; i < ThongKeService.sizeList.size(); i++) {
            String mau = ThongKeService.sizeList.get(i);
            Integer mua = ThongKeService.muasizeList.get(i);
            chart.addSeries(mau, mua);
        }

        chart.getStyler().setChartBackgroundColor(new Color(246, 246, 249));
        // Tạo XChartPanel từ biểu đồ
        XChartPanel<PieChart> chartPanel = new XChartPanel<>(chart);

        // Đặt layout của JPanel là GridBagLayout
        panelSize.setLayout(new GridBagLayout());
        // Đặt cấu hình của GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        panelSize.add(chartPanel,gbc);
        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblKieuDoanhThu = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblDoanhThu = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblLoiNhuan = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cboThoiGian = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        PanelThongKe_LineChart = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        panelMauSac = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        panelSize = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(null);
        setForeground(java.awt.Color.white);
        setResizable(true);
        setTitle("Trang 3");
        setMaximumSize(new java.awt.Dimension(1140, 700));
        setMinimumSize(new java.awt.Dimension(1140, 700));
        setPreferredSize(new java.awt.Dimension(1140, 700));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 246, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 700));

        jPanel3.setBackground(new java.awt.Color(246, 246, 249));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 60, 10));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 115));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblKieuDoanhThu.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblKieuDoanhThu.setForeground(new java.awt.Color(186, 186, 190));
        lblKieuDoanhThu.setText("Tổng doanh thu");
        jPanel8.add(lblKieuDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel21.setFont(new java.awt.Font("Roboto Slab ExtraBold", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(67, 68, 79));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Wallet.png"))); // NOI18N
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 40, 30));

        lblDoanhThu.setFont(new java.awt.Font("Roboto Slab ExtraBold", 0, 18)); // NOI18N
        lblDoanhThu.setForeground(new java.awt.Color(67, 68, 79));
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Cash.png"))); // NOI18N
        lblDoanhThu.setText(" 450.000.000");
        jPanel8.add(lblDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 49));

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("   +1% Tăng trưởng");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, -1));

        jPanel3.add(jPanel8);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 115));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(186, 186, 190));
        jLabel5.setText("Khách hàng đã thêm vào hệ thống");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Slab ExtraBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(67, 68, 79));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/People.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 40, 30));

        lblKhachHang.setFont(new java.awt.Font("Roboto Slab ExtraBold", 0, 18)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(67, 68, 79));
        lblKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhachHang.setText(" 450.000.000");
        jPanel4.add(lblKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 49));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("   +1% Tăng trưởng");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, -1));

        jPanel3.add(jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 115));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(186, 186, 190));
        jLabel9.setText("Hóa đơn");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Slab ExtraBold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(67, 68, 79));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8-billing-machine-32.png"))); // NOI18N
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 50, 50));

        lblHoaDon.setFont(new java.awt.Font("Roboto Slab ExtraBold", 0, 18)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(67, 68, 79));
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDon.setText(" 450.000.000");
        jPanel6.add(lblHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 49));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("   +1% Tăng trưởng");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, -1));

        jPanel3.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 115));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(186, 186, 190));
        jLabel16.setText("Lợi nhuận");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel17.setFont(new java.awt.Font("Roboto Slab ExtraBold", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(67, 68, 79));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8-clothes-32.png"))); // NOI18N
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 50, 30));

        lblLoiNhuan.setFont(new java.awt.Font("Roboto Slab ExtraBold", 0, 18)); // NOI18N
        lblLoiNhuan.setForeground(new java.awt.Color(67, 68, 79));
        lblLoiNhuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoiNhuan.setText(" 450.000.000");
        jPanel7.add(lblLoiNhuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 49));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("   +1% Tăng trưởng");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, -1));

        jPanel3.add(jPanel7);

        cboThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Theo năm", "Theo tháng", "Theo 7 ngày gần nhất", "Theo ngày" }));
        cboThoiGian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboThoiGianMouseClicked(evt);
            }
        });
        cboThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThoiGianActionPerformed(evt);
            }
        });

        PanelThongKe_LineChart.setBackground(new java.awt.Color(246, 246, 249));

        javax.swing.GroupLayout PanelThongKe_LineChartLayout = new javax.swing.GroupLayout(PanelThongKe_LineChart);
        PanelThongKe_LineChart.setLayout(PanelThongKe_LineChartLayout);
        PanelThongKe_LineChartLayout.setHorizontalGroup(
            PanelThongKe_LineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1099, Short.MAX_VALUE)
        );
        PanelThongKe_LineChartLayout.setVerticalGroup(
            PanelThongKe_LineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(PanelThongKe_LineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(PanelThongKe_LineChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê doanh thu", jPanel2);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        tblSanPham.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên ", "Loại", "Số lượng", "Giá nhập", "Chất liệu", "Màu sắc", "Size", "Thương hiệu", "Số lượng đã bán"
            }
        ));
        tblSanPham.setSelectionBackground(new java.awt.Color(51, 153, 0));
        jScrollPane1.setViewportView(tblSanPham);

        jPanel5.add(jScrollPane1);

        jTabbedPane1.addTab("Sản phẩm bán chạy", jPanel5);

        panelMauSac.setMaximumSize(new java.awt.Dimension(1105, 510));
        panelMauSac.setMinimumSize(new java.awt.Dimension(1105, 510));

        javax.swing.GroupLayout panelMauSacLayout = new javax.swing.GroupLayout(panelMauSac);
        panelMauSac.setLayout(panelMauSacLayout);
        panelMauSacLayout.setHorizontalGroup(
            panelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMauSacLayout.setVerticalGroup(
            panelMauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(panelMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(panelMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Màu sắc được ưa chuộng", jPanel9);

        panelSize.setMaximumSize(new java.awt.Dimension(1105, 510));
        panelSize.setMinimumSize(new java.awt.Dimension(1105, 510));

        javax.swing.GroupLayout panelSizeLayout = new javax.swing.GroupLayout(panelSize);
        panelSize.setLayout(panelSizeLayout);
        panelSizeLayout.setHorizontalGroup(
            panelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelSizeLayout.setVerticalGroup(
            panelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(panelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(panelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Size được ưa chuộng", jPanel10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(cboThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHoaDon1MouseClicked

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        cboThoiGian.setSelectedIndex(0);
//        thongKeService.mauSacChuong();
//        pie_mausac();
    }//GEN-LAST:event_formInternalFrameOpened

    private void cboThoiGianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboThoiGianMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboThoiGianMouseClicked
    DecimalFormat formatter = new DecimalFormat("#,###");

    void ThongKe_TatCa() {
        lblDoanhThu.setText(ThongKeService.doanhThu_TatCa().toString());
        lblKhachHang.setText(ThongKeService.TongKhachHang_Theo(36500).toString());
        lblHoaDon.setText(ThongKeService.TongHoaDon_Theo(36500).toString());
        lblLoiNhuan.setText(formatter.format(thongKeService.loinhuan_all()));
        PanelThongKe_LineChart.removeAll(); // Xóa tất cả các thành phần trong Panel trước khi vẽ lại
        LineChart_DoanhThu_Nam();
        PanelThongKe_LineChart.revalidate(); // Cập nhật giao diện
        PanelThongKe_LineChart.repaint(); // Vẽ lại Panel
        thongKeService.getAllBanChay();
        loadDataSPBC();

        panelMauSac.removeAll();
        thongKeService.mauSacChuong();
        pie_mausac();
        
        panelSize.removeAll();
        thongKeService.sizeChuong();
        pie_size();
    }

    void ThongKe_TheoNam() {
        lblDoanhThu.setText(ThongKeService.doanhThu_TheoNam().toString());
        lblKhachHang.setText(ThongKeService.TongKhachHang_Theo(365).toString());
        lblHoaDon.setText(ThongKeService.TongHoaDon_Theo(365).toString());
        lblLoiNhuan.setText(formatter.format(thongKeService.loinhuan_nam()));
        PanelThongKe_LineChart.removeAll(); // Xóa tất cả các thành phần trong Panel trước khi vẽ lại
        LineChart_DoanhThu_Nam();
        PanelThongKe_LineChart.revalidate(); // Cập nhật giao diện
        PanelThongKe_LineChart.repaint(); // Vẽ lại Panel

        loadDataSPBC365();
        
        panelMauSac.removeAll();
        thongKeService.mauSacChuong365();
        pie_mausac();
        
        panelSize.removeAll();
        thongKeService.sizeChuong365();
        pie_size();
    }

    void ThongKe_TheoThang() {
        System.out.println(ThongKeService.doanhThu_TheoThang().toString());
        lblDoanhThu.setText(ThongKeService.doanhThu_TheoThang().toString());
        lblKhachHang.setText(ThongKeService.TongKhachHang_Theo(30).toString());
        lblHoaDon.setText(ThongKeService.TongHoaDon_Theo(30).toString());
        lblLoiNhuan.setText(formatter.format(thongKeService.loinhuan_thang()));
        PanelThongKe_LineChart.removeAll(); // Xóa tất cả các thành phần trong Panel trước khi vẽ lại
        LineChart_DoanhThu_Thang();
        PanelThongKe_LineChart.revalidate(); // Cập nhật giao diện
        PanelThongKe_LineChart.repaint(); // Vẽ lại Panel

        loadDataSPBC30();
        
        panelMauSac.removeAll();
        thongKeService.mauSacChuong30();
        pie_mausac();
        
        panelSize.removeAll();
        thongKeService.sizeChuong30();
        pie_size();
    }

    void ThongKe_Theo7ngay() {
        lblDoanhThu.setText(ThongKeService.doanhThu_Theo7ngay().toString());
        lblKhachHang.setText(ThongKeService.TongKhachHang_Theo(7).toString());
        lblHoaDon.setText(ThongKeService.TongHoaDon_Theo(7).toString());
        lblLoiNhuan.setText(formatter.format(thongKeService.loinhuan_7ngay()));
        PanelThongKe_LineChart.removeAll(); // Xóa tất cả các thành phần trong Panel trước khi vẽ lại
        LineChart_DoanhThu_7Day();

        loadDataSPBC7();
        
        panelMauSac.removeAll();
        thongKeService.mauSacChuong7();
        pie_mausac();
        
        panelSize.removeAll();
        thongKeService.sizeChuong7();
        pie_size();
    }

    void ThongKe_theoNgay() {
        lblDoanhThu.setText(ThongKeService.doanhThu_TheoNgay().toString());
        lblKhachHang.setText(ThongKeService.TongKhachHang_Theo(1).toString());
        lblHoaDon.setText(ThongKeService.TongHoaDon_Theo(1).toString());
        lblLoiNhuan.setText(formatter.format(thongKeService.loinhuan_ngay()));
        PanelThongKe_LineChart.removeAll(); // Xóa tất cả các thành phần trong Panel trước khi vẽ lại
        LineChart_DoanhThu_Day();

        loadDataSPBC1();
        
        panelMauSac.removeAll();
        thongKeService.mauSacChuong1();
        pie_mausac();
        
        panelSize.removeAll();
        thongKeService.sizeChuong1();
        pie_size();
    }
    private void cboThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThoiGianActionPerformed
        // TODO add your handling code here:
        DecimalFormat formatter = new DecimalFormat("#,###");
        String choice = (String) cboThoiGian.getSelectedItem();
        if (choice.equals("Tất cả")) {
            lblKieuDoanhThu.setText("Tổng doanh thu");
            ThongKe_TatCa();
            lblDoanhThu.setText(formatter.format(Double.parseDouble(lblDoanhThu.getText())));

        } else if (choice.equals("Theo năm")) {
            lblKieuDoanhThu.setText("Tổng doanh thu trong năm");
            ThongKe_TheoNam();
            lblDoanhThu.setText(formatter.format(Double.parseDouble(lblDoanhThu.getText())));

        } else if (choice.equals("Theo tháng")) {
            lblKieuDoanhThu.setText("Tổng doanh thu trong tháng này");
            ThongKe_TheoThang();
            lblDoanhThu.setText(formatter.format(Double.parseDouble(lblDoanhThu.getText())));

        } else if (choice.equals("Theo 7 ngày gần nhất")) {
            lblKieuDoanhThu.setText("Tổng doanh thu trong 7 ngày nay");
            ThongKe_Theo7ngay();
            lblDoanhThu.setText(formatter.format(Double.parseDouble(lblDoanhThu.getText())));

        } else if (choice.equals("Theo ngày")) {
            lblKieuDoanhThu.setText("Tổng doanh thu trong hôm nay");
            ThongKe_theoNgay();
            lblDoanhThu.setText(formatter.format(Double.parseDouble(lblDoanhThu.getText())));

        } else {
            return;
        }
    }//GEN-LAST:event_cboThoiGianActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelThongKe_LineChart;
    private javax.swing.JComboBox<String> cboThoiGian;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblKieuDoanhThu;
    private javax.swing.JLabel lblLoiNhuan;
    private javax.swing.JPanel panelMauSac;
    private javax.swing.JPanel panelSize;
    private javax.swing.JTable tblSanPham;
    // End of variables declaration//GEN-END:variables
}
