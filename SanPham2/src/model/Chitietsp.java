/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author c
 */
public class Chitietsp {

    private String id;
    private String idnxb;
    private String idmausac;
    private String iddongsp;
    private String nambh;
    private String mota;
    private String soluongton;
    private String gianhap;
    private String giaban;

    public Chitietsp() {
    }

    public Chitietsp(String id, String idnxb, String idmausac, String iddongsp, String nambh, String mota, String soluongton, String gianhap, String giaban) {
        this.id = id;
        this.idnxb = idnxb;
        this.idmausac = idmausac;
        this.iddongsp = iddongsp;
        this.nambh = nambh;
        this.mota = mota;
        this.soluongton = soluongton;
        this.gianhap = gianhap;
        this.giaban = giaban;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdnxb() {
        return idnxb;
    }

    public void setIdnxb(String idnxb) {
        this.idnxb = idnxb;
    }

    public String getIdmausac() {
        return idmausac;
    }

    public void setIdmausac(String idmausac) {
        this.idmausac = idmausac;
    }

    public String getIddongsp() {
        return iddongsp;
    }

    public void setIddongsp(String iddongsp) {
        this.iddongsp = iddongsp;
    }

    public String getNambh() {
        return nambh;
    }

    public void setNambh(String nambh) {
        this.nambh = nambh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(String soluongton) {
        this.soluongton = soluongton;
    }

    public String getGianhap() {
        return gianhap;
    }

    public void setGianhap(String gianhap) {
        this.gianhap = gianhap;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    @Override
    public String toString() {
        return "Chitietsp{" + "id=" + id + ", idnxb=" + idnxb + ", idmausac=" + idmausac + ", iddongsp=" + iddongsp + ", nambh=" + nambh + ", mota=" + mota + ", soluongton=" + soluongton + ", gianhap=" + gianhap + ", giaban=" + giaban + '}';
    }

    public Object[] todatatable() {
        return new Object[]{id, idnxb, idmausac, iddongsp, nambh, mota, soluongton, gianhap, giaban};
    }
}
