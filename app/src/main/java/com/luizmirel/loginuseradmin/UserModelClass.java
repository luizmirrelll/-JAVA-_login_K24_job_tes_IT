package com.luizmirel.loginuseradmin;

public class UserModelClass {

    Integer id;
    String name;
    String email;
    String pass;
    String username;
    String jk;
    String ttl;
    String alamat;

    public UserModelClass(Integer id, String name, String email, String pass, String username, String jk, String ttl, String alamat) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.username = username;
        this.jk = jk;
        this.ttl = ttl;
        this.alamat = alamat;
    }

    public UserModelClass(String name, String email, String pass, String username, String jk, String ttl, String alamat) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.username = username;
        this.jk = jk;
        this.ttl = ttl;
        this.alamat = alamat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
