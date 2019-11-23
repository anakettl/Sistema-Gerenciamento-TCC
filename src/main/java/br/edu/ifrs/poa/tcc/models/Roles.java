package br.edu.ifrs.poa.tcc.models;

public enum Roles {
    ADMIN("ROLE-ADMIN");

    private String role;

    Roles(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
