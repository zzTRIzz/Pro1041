/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.HoaDonCT;
import model.HoaDonCTAD;

/**
 *
 * @author Surface
 */
public interface HoaDonCTService {
    List<HoaDonCT> getHoaDonCTAll(int idHD);

    void addHoaDonCT(HoaDonCT hdct);
    List<HoaDonCT> getSanPhamTonTai(int idHD,int idSP);
    void gopSanPhamTonTai(int idHDCT,int soLuongMua,double tongTien);
    HoaDonCT getRowHDCT(int row);
    void deleteHDCT(int idHDCT);
    List<HoaDonCTAD> getHoaDonCTAllAdmin(int idHD);
    List<HoaDonCT> getSanPhamTonTaiKoKM(int idHD,int idSP);
    void addHoaDonCTKM(int idHD, int soLuongMua,int idSP,double tongTien);
}
