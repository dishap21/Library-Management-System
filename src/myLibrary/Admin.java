package myLibrary;

public class Admin {
    String adminName, adminPass;
    public Admin(String adminName, String adminPass) {
        this.adminName = adminName;
        this.adminPass = adminPass;
    }
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return this.adminName.equals(enteredUsername) && this.adminPass.equals(enteredPassword);
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }
}
