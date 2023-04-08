/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Connection.DBcontext;
import domainmodel.ChiTietSP;
import java.sql.SQLException;
import model.SanPham;
import model.SanPham2;

/**
 *
 * @author c
 */
public class SanPhamRepository {

    public List<SanPham> getall() {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.ChiTietSP.Gia, dbo.SanPham.soluongton, dbo.DongSP.Ten AS Expr1, dbo.Size.SoSize, dbo.ChiTietSP.TrangThai, dbo.MauSac.Ten AS Expr2, dbo.ChiTietSP.Id\n"
                + "FROM     dbo.ChiTietSP INNER JOIN\n"
                + "                  dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id INNER JOIN\n"
                + "                  dbo.Size ON dbo.ChiTietSP.IdSize = dbo.Size.Id";
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<SanPham> nv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.add(new SanPham(rs.getString(9), null, null, rs.getString(1), rs.getString(2), rs.getDouble(3), null, null, null, null, 0, rs.getInt(4), rs.getString(7), rs.getString(5), rs.getString(6), rs.getString(6), rs.getString(8)));
            }
            rs.close();
            return nv;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean add(String size, String tensp, String mausac, String dongsp, ChiTietSP sp) {
        String sql = "DECLARE @idsize UNIQUEIDENTIFIER\n"
                + "SET @idsize = (SELECT id FROM size WHERE sosize = ?)\n"
                + "\n"
                + "DECLARE @idsanpham UNIQUEIDENTIFIER\n"
                + "SET @idsanpham = (SELECT id FROM sanpham WHERE ten = ?)\n"
                + "\n"
                + "DECLARE @idmausac UNIQUEIDENTIFIER\n"
                + "SET @idmausac = (SELECT id FROM mausac WHERE ten = ?)\n"
                + "\n"
                + "DECLARE @iddongsp UNIQUEIDENTIFIER\n"
                + "SET @iddongsp = (SELECT id FROM dongsp WHERE ten = ?)\n"
                + "\n"
                + "INSERT INTO [dbo].[ChiTietSP]\n"
                + "    ([IdSP]\n"
                + "    ,[IdSize]\n"
                + "    ,[IdMauSac]\n"
                + "    ,[IdDongSP]\n"
                + "    ,[ThoiGianBH]\n"
                + "    ,[Gia]\n"
                + "    ,[TrangThai])\n"
                + "VALUES\n"
                + "    (@idsanpham\n"
                + "    ,@idsize\n"
                + "    ,@idmausac\n"
                + "    ,@iddongsp\n"
                + "    ,?\n"
                + "    ,?\n"
                + "    ,?)";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, size);
            ps.setObject(2, tensp);
            ps.setObject(3, mausac);
            ps.setObject(4, dongsp);
            ps.setObject(5, sp.getThoiGianBH());
            ps.setObject(6, sp.getGia());
            ps.setObject(7, sp.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean addrow(ChiTietSP sp) {
        String sql = "INSERT INTO [dbo].[ChiTietSP]\n"
                + "           ([IdSP]\n"
                + "           ,[IdSize]\n"
                + "           ,[IdMauSac]\n"
                + "           ,[IdDongSP]\n"
                + "           ,[MaDanhMuc]\n"
                + "           ,[ThoiGianBH]\n"
                + "           ,[Gia]\n"
                + "           ,[TrangThai]\n)"
                + "     VALUES\n"
                + "           ( ?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sp.getIdSP());
            ps.setObject(2, sp.getIdSize());
            ps.setObject(3, sp.getIdMauSac());
            ps.setObject(4, sp.getMaDanhMuc());
            ps.setObject(5, sp.getThoiGianBH());
            ps.setObject(6, sp.getGia());
            ps.setObject(7, sp.getIdAnh());
            ps.setObject(8, sp.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public List<SanPham2> getallsp() {
        String sql = "SELECT [Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[soluongton]\n"
                + "      ,[trangthai]\n"
                + "  FROM [dbo].[SanPham]";
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<SanPham2> nv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.add(new SanPham2(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            rs.close();
            return nv;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean addsanpham(SanPham2 nv) {
        String sql = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[soluongton])\n"
                + "     VALUES\n"
                + "           (?"
                + "           ,?"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getSoluong());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[SanPham]\n"
                + "      WHERE ma=?";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean deletechitiet(String id) {
        String query = "DELETE FROM [dbo].[ChiTietSP]\n"
                + "      WHERE id=?";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(String size, String tensp, String mausac, String dongsp, ChiTietSP sp, String id) {
        String sql = "DECLARE @idsize UNIQUEIDENTIFIER\n"
                + "SET @idsize = (SELECT id FROM size WHERE sosize = ?)\n"
                + "\n"
                + "DECLARE @idsanpham UNIQUEIDENTIFIER\n"
                + "SET @idsanpham = (SELECT id FROM sanpham WHERE ten = ?)\n"
                + "\n"
                + "DECLARE @idmausac UNIQUEIDENTIFIER\n"
                + "SET @idmausac = (SELECT id FROM mausac WHERE ten = ?)\n"
                + "\n"
                + "DECLARE @iddongsp UNIQUEIDENTIFIER\n"
                + "SET @iddongsp = (SELECT id FROM dongsp WHERE ten = ?)\n"
                + "\n"
                + " UPDATE [dbo].[ChiTietSP]\n"
                + "      SET [IdSP] = @idsanpham"
                + "      ,[IdSize] = @idsize"
                + "      ,[IdMauSac] = @idmausac"
                + "      ,[IdDongSP] = @iddongsp"
                + "      ,[ThoiGianBH] = ?"
                + "      ,[Gia] = ?"
                + "      ,[TrangThai] = ?"
                + " WHERE id=?";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, size);
            ps.setObject(2, tensp);
            ps.setObject(3, mausac);
            ps.setObject(4, dongsp);
            ps.setObject(5, sp.getThoiGianBH());
            ps.setObject(6, sp.getGia());
            ps.setObject(7, sp.getTrangThai());
            ps.setObject(8, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean update(SanPham2 nv, String manv) {
        String sql = "UPDATE [dbo].[SanPham]\n"
                + "   SET [Ma] = ?"
                + "      ,[Ten] = ?"
                + "      ,[soluongton] = ?"
                + " WHERE ma=?";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getSoluong());
            ps.setObject(4, manv);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public static void main(String[] args) {
        for (SanPham arg : new SanPhamRepository().getall()) {

            System.out.println(arg.getMausac());
        }
        SanPhamRepository sv = new SanPhamRepository();
        sv.addrow(new ChiTietSP("1", "2", "3", "4", "4", "5", "4", 1, 2.1, 3));
    }
}
