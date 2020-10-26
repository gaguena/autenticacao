/**
 * 
 */
package br.com.leroymerlin.oauth.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.leroymerlin.oauth.data.TokenData;
import br.com.leroymerlin.oauth.data.UserData;
import br.com.leroymerlin.oauth.repository.TokenRepository;
import br.com.leroymerlin.oauth.util.LocalDateUtil;

/**
 * @author Gabriel Y. Aguena
 *
 */
@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private Algorithm algorithm;

    public Optional<TokenData> findBy(final String token) {
        return tokenRepository.findByValue(token).map(TokenData::new);
    }

    public TokenData login(final UserData data) {
        final TokenData tokenData = createToken(data);
        this.tokenRepository.save(tokenData.to());
        return tokenData;
    }

    public TokenData createToken(final UserData data) {
        final LocalDateTime expiredAt = LocalDateUtil.expiredAt();
        return TokenData.builder()
                .expiredAt(expiredAt)
                .value(this.jwtCreate(data.getUserName(), expiredAt))
                .build();
    }

    private String jwtCreate(final String userName, final LocalDateTime expiredAt) {
       return JWT.create()
        .withJWTId(userName)
        .withExpiresAt(LocalDateUtil.localDAteTimeTo(expiredAt))
        .sign(algorithm);
    }
}
