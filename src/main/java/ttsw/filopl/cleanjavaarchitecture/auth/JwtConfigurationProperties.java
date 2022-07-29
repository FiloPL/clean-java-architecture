package ttsw.filopl.cleanjavaarchitecture.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@Configuration
@ConfigurationProperties("jwt")
class JwtConfigurationProperties {
    private String secret;
    private long validity;

    String getSecret() {
        return secret;
    }

    void setSecret(String secret) {
        this.secret = secret;
    }

    long getValidity() {
        return validity;
    }

    void setValidity(long validity) {
        this.validity = validity;
    }
}
