package ttsw.filopl.cleanjavaarchitecture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ttsw.filopl.cleanjavaarchitecture.dto.AuthenticationRequestDto;
import ttsw.filopl.cleanjavaarchitecture.dto.AuthenticationResponseDto;
import ttsw.filopl.cleanjavaarchitecture.service.TokenService;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@RestController
@RequestMapping("/authenticate")
class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    ResponseEntity<AuthenticationResponseDto> createToken(@RequestBody AuthenticationRequestDto authRequest) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        var user = (UserDetails) auth.getPrincipal();
        return ResponseEntity.ok(new AuthenticationResponseDto(tokenService.generateNewToken(user)));
    }
}
