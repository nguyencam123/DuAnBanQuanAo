/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Connection.DBcontext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author c
 */
public class NhanvVienRepository {

    public List<NhanVien> getall() {
        String sql = "SELECT [MaNV]\n"
                + "      ,[TenNV]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Email]\n"
                + "      ,[QueQuan]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[TaiKhoan]\n"
                + "      ,[MatKhau]\n"
                + "      ,[IdChucVu]\n"
                + "  FROM [dbo].[NhanVien]";
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<NhanVien> nv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            rs.close();
            return nv;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean add(NhanVien nv) {
        String sql = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([MaNV]\n"
                + "           ,[TenNV]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[TrangThai]\n"
                + "           ,[Email]\n"
                + "           ,[QueQuan]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[TaiKhoan]\n"
                + "           ,[MatKhau])\n"
                + "     VALUES\n"
                + "           (?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getManv());
            ps.setObject(2, nv.getTennv());
            ps.setObject(3, nv.isGt());
            ps.setObject(4, nv.getTrangthai());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getQuequan());
            ps.setObject(7, nv.getNgaysinh());
            ps.setObject(8, nv.getTk());
            ps.setObject(9, nv.getMk());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

//    public boolean update(Sanpham nv, String manv) {
//        String sql = "UPDATE [dbo].[sanpham]\n"
//                + "       set [Ma] = ?"
//                + "      ,[Ten] = ?"
//                + " WHERE ma=?";
//        int check = 0;
//        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setObject(1, nv.getMa());
//            ps.setObject(2, nv.getName());
//            ps.setObject(3, manv);
//            check = ps.executeUpdate();
//        } catch (Exception e) {
//        }
//        return check > 0;
//    }
//
//    public boolean delete(String ma) {
//        String query = "DELETE FROM [dbo].[sanpham]\n"
//                + "      WHERE ma=?";
//        int check = 0;
//        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setObject(1, ma);
//            check = ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return check > 0;
//    }
}
