package org.thibaut.thelibrary.webapp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.webapp.client.UserClient;
import thelibrary.wsdl.Role;
import thelibrary.wsdl.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserClient userClient;


//	private HttpSession httpSession;

	/**
	 * The authentication method uses the user email, since it is easier to remember for most users
	 * @param input
	 * @return a UserDetails object
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername( String input) throws UsernameNotFoundException {

		User user = new User();

		if( input.contains( "@" )){
			user = userClient.getUserByEmail( input ).getUser();
		}
		else {
			user = userClient.getUserByUsername( input ).getUser();
		}

		if (user == null) {
			throw new UsernameNotFoundException( "User with email " + input + " was not found in the database" );
		}

		// [ROLE_USER, ROLE_ADMIN,..]
		List< Role > roles = user.getRoles();
		List<String> roleNames = new ArrayList<>();

		roles.forEach( role -> roleNames.add( role.getRole() ) );

		List< GrantedAuthority > grantList = new ArrayList< GrantedAuthority >();
		if (!roleNames.isEmpty()) {
			for (String role : roleNames) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}

		return ( UserDetails ) new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), grantList);

	}
}
