/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author c
 */
public class NhanVien {

    private String manv;
    private String tennv;
    private boolean gt;
    private String trangthai;
    private String email;
    private String quequan;
    private String ngaysinh;
    private String tk;
    private String mk;

    public NhanVien(String manv, String tennv, boolean gt, String trangthai, String email, String quequan, String ngaysinh, String tk, String mk) {
        this.manv = manv;
        this.tennv = tennv;
        this.gt = gt;
        this.trangthai = trangthai;
        this.email = email;
        this.quequan = quequan;
        this.ngaysinh = ngaysinh;
        this.tk = tk;
        this.mk = mk;
    }

    public NhanVien() {
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public Object[] todatarow() {
        return new Object[]{manv, tennv, gt, trangthai, email, quequan, ngaysinh, tk, mk};
    }
}
