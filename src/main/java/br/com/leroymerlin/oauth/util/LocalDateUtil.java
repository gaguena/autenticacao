/**
 * 
 */
package br.com.leroymerlin.oauth.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author Gabriel Y. Aguena
 *
 */
public class LocalDateUtil {

    public static LocalDateTime expiredAt() {
        return LocalDateTime.now();
    }

    public static Date localDAteTimeTo(final LocalDateTime date) {
        return Date.from(date.atZone(ZoneOffset.UTC).toInstant());
    }
}
