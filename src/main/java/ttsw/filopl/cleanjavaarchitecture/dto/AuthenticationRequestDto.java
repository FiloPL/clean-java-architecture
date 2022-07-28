package ttsw.filopl.cleanjavaarchitecture.dto;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public class AuthenticationRequestDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
