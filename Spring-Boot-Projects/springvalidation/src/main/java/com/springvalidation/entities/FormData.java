package com.springvalidation.entities;
 
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FormData {

    @NotBlank(message = "User name con't be empty")
    @Size(min = 3, max = 10, message = "User name must be between 3 and 10 characters")
    private String userName;

    @Email(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    private String email;

    @AssertTrue(message = "You must accept the terms and conditions")
    private boolean agreed;

    // Getters and setters
    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", agreed=" + agreed +
                '}';
    }
}



