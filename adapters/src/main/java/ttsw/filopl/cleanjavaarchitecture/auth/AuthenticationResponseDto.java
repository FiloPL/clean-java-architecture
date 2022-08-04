package ttsw.filopl.cleanjavaarchitecture.auth;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

class AuthenticationResponseDto {
    private final String token;

    AuthenticationResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
