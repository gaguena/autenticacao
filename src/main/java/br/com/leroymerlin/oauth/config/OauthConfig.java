/**
 * 
 */
package br.com.leroymerlin.oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.auth0.jwt.algorithms.Algorithm;

/**
 * @author Gabriel Y. Aguena
 *
 */
@Configuration
public class OauthConfig {

    @Value("${custom.secret}")
    private String secretKey;

    @Bean
    public Algorithm algorithm() {
        return Algorithm.HMAC256(secretKey);
    }

}
