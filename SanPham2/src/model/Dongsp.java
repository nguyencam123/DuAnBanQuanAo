/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author c
 */
public class Dongsp {

    private String id;
    private String ma;
    private String name;

    public Dongsp(String id, String ma, String name) {
        this.id = id;
        this.ma = ma;
        this.name = name;
    }

    public Dongsp() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public Object[] todatatable(){
        return new Object[] {id,ma,name};
    }
}
