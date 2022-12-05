package anbulko.getservice.domain;

public enum Permission {
    USER_WRITE("user:write"),
    USER_NOTING("user:noting");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
