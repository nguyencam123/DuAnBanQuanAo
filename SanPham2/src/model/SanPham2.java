/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author c
 */
public class SanPham2 {
    private String ma;
    private String ten;
    private String soluong;

    public SanPham2() {
    }

    public SanPham2(String ma, String ten, String soluong) {
        this.ma = ma;
        this.ten = ten;
        this.soluong = soluong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
    
    
    public Object[] getdatatble(){
        return new Object[]{ma,ten,soluong};
    }
}
