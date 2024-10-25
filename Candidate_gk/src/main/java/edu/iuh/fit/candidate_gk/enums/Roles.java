package edu.iuh.fit.candidate_gk.enums;

public enum Roles {
    ADMINISTRATION(0),
    STAFF(1),
    MANAGER(2),
    EXECUTIVE(3);


    private final int value;

    private Roles(int value) {
        this.value = value;
    }


}
