package onlineBank.demo.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import onlineBank.demo.models.BankAccount;
import onlineBank.demo.models.ERole;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET = "123";

    public String generateToken(String name, ERole role, String email, String dni, BankAccount account){
        return JWT.create()
                .withSubject(name)
                .withClaim("email", email)
                .withClaim("role", role.name())
                .withClaim("dni", dni)
                .withClaim("iban", account != null ? account.getIBAN() : "none")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .sign(Algorithm.HMAC256(SECRET));
    }

}
