/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Connection.DBcontext;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Chitietsp;

/**
 *
 * @author c
 */
public class Chitietsprepository {

    String sql = "SELECT [Id]\n"
            + "      ,[IdSP]\n"
            + "      ,[IdSize]\n"
            + "      ,[IdMauSac]\n"
            + "      ,[IdDongSP]\n"
            + "      ,[IdAnh]\n"
            + "      ,[MaDanhMuc]\n"
            + "      ,[ThoiGianBH]\n"
            + "      ,[Gia]\n"
            + "      ,[TrangThai]\n"
            + "  FROM [dbo].[ChiTietSP]";

    public List<Chitietsp> getall() {
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<Chitietsp> chitietsp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                chitietsp.add(new Chitietsp(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            rs.close();
            return chitietsp;
        } catch (Exception e) {
        }
        return null;
    }

    public String delete(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean add(Chitietsp ct) {
        String sql = "INSERT INTO [dbo].[ChiTietSP]\n"
                +"           ([IdSP]\n"
                + "           ,[IdSize]\n"
                + "           ,[IdMauSac]\n"
                + "           ,[IdDongSP]\n"
                + "           ,[MaDanhMuc]\n"
                + "           ,[ThoiGianBH]\n"
                + "           ,[Gia]\n"
                + "           ,[TrangThai])"
                + "     VALUES\n"
                + "           (?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ct.getIddongsp());
            ps.setObject(2, ct.getIdmausac());
            ps.setObject(3, ct.getIdnxb());
            ps.setObject(4, ct.getNambh());
            ps.setObject(5, ct.getMota());
            ps.setObject(6, ct.getSoluongton());
            ps.setObject(7, ct.getGianhap());
            ps.setObject(8, ct.getGiaban());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean update(Chitietsp ct, String ma) {
        String sql = "UPDATE [dbo].[ChiTietSP]\n"
                + "      set [IdSP] = ?"
                + "      ,[IdNsx] = ?"
                + "      ,[IdMauSac] = ?"
                + "      ,[IdDongSP] = ?"
                + "      ,[NamBH] = ?"
                + "      ,[MoTa] = ?"
                + "      ,[SoLuongTon] = ?"
                + "      ,[GiaNhap] = ?"
                + "      ,[GiaBan] = ?"
                + " WHERE ma=?";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ct.getIddongsp());
            ps.setObject(2, ct.getIdmausac());
            ps.setObject(3, ct.getIdnxb());
            ps.setObject(4, ct.getMota());
            ps.setObject(5, ct.getNambh());
            ps.setObject(6, ct.getSoluongton());
            ps.setObject(7, ct.getGiaban());
            ps.setObject(8, ct.getGianhap());
            ps.setObject(9, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
}
