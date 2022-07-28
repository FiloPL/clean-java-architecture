package ttsw.filopl.cleanjavaarchitecture.dto;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public class AuthenticationResponseDto {
    private final String token;

    public AuthenticationResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
