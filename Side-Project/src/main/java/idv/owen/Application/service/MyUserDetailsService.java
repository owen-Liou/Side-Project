package idv.owen.Application.service;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import idv.owen.Application.dao.UserRepository;

@Service
public class MyUserDetailsService  implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 	
		    idv.owen.Application.model.User appUser = userRepository.findByUsername(username);
		    if (appUser == null) {
	            throw new UsernameNotFoundException(username + " not found");
	        }
		    if(appUser!=null) {
			    UserDetails userDetails = User.builder()
			    		.username(appUser.getUser_name())
			    		.password(new BCryptPasswordEncoder().encode(appUser.getUser_pwd()))
			    		//.password("{noop}" + appUser.getUser_pwd())
			    		.roles(appUser.getUser_role()).build();
			    return userDetails;
		    }
		    	

		    
	        Collection<GrantedAuthority> authorities = new ArrayList<>();
	        authorities.add(new SimpleGrantedAuthority("ADMIN"));
	        return new User("admin", new BCryptPasswordEncoder().encode("admin"), authorities);
	    }



}
