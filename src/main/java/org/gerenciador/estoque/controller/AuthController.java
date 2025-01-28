package org.gerenciador.estoque.controller;

import lombok.RequiredArgsConstructor;
import org.gerenciador.estoque.domain.models.Usuario;
import org.gerenciador.estoque.domain.repository.UsuarioRepository;
import org.gerenciador.estoque.dto.LoginRequestDTO;
import org.gerenciador.estoque.dto.RegisterRequestDTO;
import org.gerenciador.estoque.dto.ResponseDTO;
import org.gerenciador.estoque.infra.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        Usuario user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<Usuario> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()) {
            Usuario newUser = new Usuario();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setUsername(body.name());
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
