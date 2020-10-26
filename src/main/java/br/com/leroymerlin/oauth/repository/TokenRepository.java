/**
 * 
 */
package br.com.leroymerlin.oauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leroymerlin.oauth.model.TokenModel;

/**
 * @author Gabriel Y. Aguena
 *
 */
public interface TokenRepository extends JpaRepository<TokenModel, Long> {

    Optional<TokenModel> findByValue(final String value);
}
