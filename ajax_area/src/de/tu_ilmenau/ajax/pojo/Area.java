package de.tu_ilmenau.ajax.pojo;

/**
 * Author : Binbin Luo
 * Date : 13.04.2023
 */
public class Area {
    private String code;
    private String name;
    private String pcode;

    public Area() {
    }

    public Area(String code, String name, String pcode) {
        this.code = code;
        this.name = name;
        this.pcode = pcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    @Override
    public String toString() {
        return "Area{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", pcode='" + pcode + '\'' +
                '}';
    }
}
