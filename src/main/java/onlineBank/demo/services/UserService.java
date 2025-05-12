package onlineBank.demo.services;


import onlineBank.demo.models.User;
import onlineBank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        user.setDni(passwordEncoder.encode(user.getDni()));
        return userRepository.save(user);
    }
}
