package com.mycompany.myapp.dto;

public class Drama {
    private int dphoto;
    private String dtitle;
    private int dstar;
    private String dcomment;

    public void setDphoto(int dphoto) {
        this.dphoto = dphoto;
    }

    public void setDtitle(String dtitle) {
        this.dtitle = dtitle;
    }

    public void setDstar(int dstar) {
        this.dstar = dstar;
    }

    public void setDcomment(String dcomment) {
        this.dcomment = dcomment;
    }

    public int getDphoto() {
        return dphoto;
    }

    public String getDtitle() {
        return dtitle;
    }

    public int getDstar() {
        return dstar;
    }

    public String getDcomment() {
        return dcomment;
    }
}