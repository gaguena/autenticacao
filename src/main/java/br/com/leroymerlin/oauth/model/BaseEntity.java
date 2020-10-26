/**
 * 
 */
package br.com.leroymerlin.oauth.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Gabriel Y. Aguena
 *
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CREATED_AT")
    private LocalDate createdAt;
}
