/**
 * 
 */
package br.com.leroymerlin.oauth.data;

import java.time.LocalDateTime;

import br.com.leroymerlin.oauth.model.TokenModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Gabriel Y. Aguena
 *
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenData {

    private String value;
    private LocalDateTime expiredAt;

    public TokenData(TokenModel model) {
        this.value = model.getValue();
        this.expiredAt = model.getExpiredAt();
    }

    public TokenModel to() {
        return TokenModel.builder()
        .expiredAt(expiredAt)
        .value(value)
        .build();
    }
}
