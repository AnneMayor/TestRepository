package com.mycompany.myapp.dto;

public class Food {
    private int fno;
    private String fname;
    private int fphoto;
    private int fstar;
    private String fdesc;

    public void setFno(int fno) {
        this.fno = fno;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFphoto(int fphoto) {
        this.fphoto = fphoto;
    }

    public void setFstar(int fstar) {
        this.fstar = fstar;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

    public int getFno() {
        return fno;
    }

    public String getFname() {
        return fname;
    }

    public int getFphoto() {
        return fphoto;
    }

    public int getFstar() {
        return fstar;
    }

    public String getFdesc() {
        return fdesc;
    }
}
