/**
 * 
 */
package br.com.leroymerlin.oauth.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leroymerlin.oauth.data.TokenData;
import br.com.leroymerlin.oauth.data.UserData;
import br.com.leroymerlin.oauth.service.TokenService;

/**
 * @author Gabriel Y. Aguena
 *
 */
@RestController
@RequestMapping("/tokens")
public class TokenRest {

    @Autowired
    private TokenService tokenService;

    @GetMapping(path = "/{token}")
    public ResponseEntity<TokenData> get(@PathVariable final String token) {
        return tokenService.findBy(token)
                .map(v -> ResponseEntity.ok(v))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(path = "/")
    public ResponseEntity<TokenData> login(@RequestBody UserData data) {
        return ResponseEntity.ok(tokenService.token(data));
    }
}
