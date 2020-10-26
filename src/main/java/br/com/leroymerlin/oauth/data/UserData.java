/**
 * 
 */
package br.com.leroymerlin.oauth.data;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Gabriel Y. Aguena
 *
 */
@Getter
@Builder
public class UserData {

    private String userName;
    private String password;
}
