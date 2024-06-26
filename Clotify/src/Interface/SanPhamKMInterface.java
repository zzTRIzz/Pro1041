/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.util.List;
import model.SanPhamKM;

/**
 *
 * @author Dell
 */
public interface SanPhamKMInterface {
    List<SanPhamKM> getSanPhamKM();
    void addSPKM(int idSP, String maKM, String trangThai,String ngayBatDau);
    SanPhamKM getRow(int row);
    List<SanPhamKM> searchIDSP(String maKM);
    List<SanPhamKM> getSPKM(String maKM, String trangThai);
    void addSPKMKT(int idSP, String maKM, String trangThai,String ngayBatDau);
    void update(int idSPKM,String trangThai);
}
