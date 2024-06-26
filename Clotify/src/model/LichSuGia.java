/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Surface
 */
public class LichSuGia {
    int idLS,idSP;
    double giaNhap,giaBan;
    String ngayBatDau,ngayKetThuc,maSP,tenSP,mauSac,chatLieu,thuongHieu,size;

    public LichSuGia() {
    }

    public LichSuGia(int idSP, double giaBan, String ngayBatDau) {
        this.idSP = idSP;
        this.giaBan = giaBan;
        this.ngayBatDau = ngayBatDau;
        
    }

    public LichSuGia(int idLS, int idSP, double giaNhap, double giaBan, String ngayBatDau, String ngayKetThuc, String maSP, String tenSP, String mauSac, String chatLieu, String thuongHieu, String size) {
        this.idLS = idLS;
        this.idSP = idSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
        this.size = size;
    }

    public int getIdLS() {
        return idLS;
    }

    public void setIdLS(int idLS) {
        this.idLS = idLS;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    
    
}
