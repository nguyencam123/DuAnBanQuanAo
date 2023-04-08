/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author c
 */
public class SanPham {
    private String id;
    private String idSp;
    private String idanh;
    private String masp;
    private String tensp;
    private Double gia;
    private String idSize;
    private String idMausac;
    private String idDongsp;
    private String maDanhmuc;
    private int thoiGianBH;
    private int soluong;
    private String trangThai;
    private String dongsp;
    private String size;
    private String danhmuc;
    private String mausac;

    public SanPham() {
    }

    public SanPham(String id, String idSp, String idanh, String masp, String tensp, Double gia, String idSize, String idMausac, String idDongsp, String maDanhmuc, int thoiGianBH, int soluong, String trangThai, String dongsp, String size, String danhmuc, String mausac) {
        this.id = id;
        this.idSp = idSp;
        this.idanh = idanh;
        this.masp = masp;
        this.tensp = tensp;
        this.gia = gia;
        this.idSize = idSize;
        this.idMausac = idMausac;
        this.idDongsp = idDongsp;
        this.maDanhmuc = maDanhmuc;
        this.thoiGianBH = thoiGianBH;
        this.soluong = soluong;
        this.trangThai = trangThai;
        this.dongsp = dongsp;
        this.size = size;
        this.danhmuc = danhmuc;
        this.mausac = mausac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getIdanh() {
        return idanh;
    }

    public void setIdanh(String idanh) {
        this.idanh = idanh;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getIdMausac() {
        return idMausac;
    }

    public void setIdMausac(String idMausac) {
        this.idMausac = idMausac;
    }

    public String getIdDongsp() {
        return idDongsp;
    }

    public void setIdDongsp(String idDongsp) {
        this.idDongsp = idDongsp;
    }

    public String getMaDanhmuc() {
        return maDanhmuc;
    }

    public void setMaDanhmuc(String maDanhmuc) {
        this.maDanhmuc = maDanhmuc;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getDongsp() {
        return dongsp;
    }

    public void setDongsp(String dongsp) {
        this.dongsp = dongsp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    

    

    public Object[] showdatatable(){
    return new Object[] {masp,tensp,gia,soluong,dongsp,size,danhmuc,mausac,trangThai};
    }
}
