package zuchowskim.crit.crit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zuchowskim.crit.crit.models.userModel;
import zuchowskim.crit.crit.models.userRepository;

import java.util.Optional;

@Service
public class userDetailService implements UserDetailsService {

    @Autowired
    userRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<userModel> user = userRepository.findByName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not Found" + userName));

        return user.map(userDetails::new).get();
    }

}
