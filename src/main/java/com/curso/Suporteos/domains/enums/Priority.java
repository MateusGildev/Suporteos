package com.curso.Suporteos.domains.enums;

public enum Priority {
    ADMIN(0, "ROLE_ADMINS"), USERS(1, "ROLE_USERS"), TECHNICIAN(2, "ROLE_TECHNICIAN");

    private Integer id;
    private String priorityType;

    Priority(Integer id, String priorityType) {
        this.id = id;
        this.priorityType = priorityType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(String priorityType) {
        this.priorityType = priorityType;
    }

    public static Priority toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (Priority x : Priority.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Priority INVALIDO");

    }
}
