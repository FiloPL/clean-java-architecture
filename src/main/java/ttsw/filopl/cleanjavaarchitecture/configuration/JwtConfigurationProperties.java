package ttsw.filopl.cleanjavaarchitecture.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@Configuration
@ConfigurationProperties("jwt")
public class JwtConfigurationProperties {
    private String secret;
    private long validity;

    public String getSecret() {
        return secret;
    }

    void setSecret(String secret) {
        this.secret = secret;
    }

    public long getValidity() {
        return validity;
    }

    void setValidity(long validity) {
        this.validity = validity;
    }
}
