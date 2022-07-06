package Payment.components.test.services;

import Payment.components.test.entities.User;
import Payment.components.test.repositories.UserRepo;
import Payment.components.test.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("----SEARCHING CREDENTIALS ----");
        System.out.println(userName);
        Optional<User> user = userRepo.findByUserName(userName);
        System.out.println(user);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        System.out.println("----CREDENTIALS FOUND----");
        return user.map(JwtUserDetails::new).get();
    }

}

