package ttsw.filopl.cleanjavaarchitecture.auth;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

class AuthenticationRequestDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
