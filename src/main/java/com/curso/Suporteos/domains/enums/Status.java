package com.curso.Suporteos.domains.enums;

public enum Status {
    ADMIN(0, "ROLE_ADMINS"), USERS(1, "ROLE_USERS"), TECHNICIAN(2, "ROLE_TECHNICIAN");

    private Integer id;
    private String StatusType;

    Status(Integer id, String statusType) {
        this.id = id;
        StatusType = statusType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusType() {
        return StatusType;
    }

    public void setStatusType(String statusType) {
        StatusType = statusType;
    }

    public static Status toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (Status x : Status.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status INVALIDO");

    }
}
