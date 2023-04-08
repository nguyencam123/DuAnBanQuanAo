/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Connection.DBcontext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import model.Dongsp;

/**
 *
 * @author c
 */
public class Dongspreposytory {

    public List<Dongsp> getall() {
        String sql = "select id,ma,ten from Dongsp";
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<Dongsp> nv = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.add(new Dongsp(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            rs.close();
            return nv;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean add(Dongsp nv) {
        String sql = "INSERT INTO [dbo].[Dongsp]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n)"
                + "     VALUES\n"
                + "          ( ?"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getName());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean update(Dongsp nv, String manv) {
        String sql = "UPDATE [dbo].[Dongsp]\n"
                + "       set [Ma] = ?"
                + "      ,[Ten] = ?"
                + " WHERE ma=?";
        int check = 0;
        try ( Connection con = DBcontext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getName());
            ps.setObject(3, manv);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[Dongsp]\n"
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
}
