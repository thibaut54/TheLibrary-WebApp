//package org.thibaut.thelibrary.webapp.security;
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.thibaut.thelibrary.webapp.client.UserClient;
//import thelibrary.wsdl.RoleDtoJaxb;
//import thelibrary.wsdl.UserDtoJaxb;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	private final UserClient userClient;
//
//
////	private HttpSession httpSession;
//
//	/**
//	 * The authentication method uses the user email, since it is easier to remember for most users
//	 * @param input
//	 * @return a UserDetails object
//	 * @throws UsernameNotFoundException
//	 */
//	@Override
//	public UserDetails loadUserByUsername( String input) throws UsernameNotFoundException {
//
//		UserDtoJaxb userDto = new UserDtoJaxb();
//
//		if( input.contains( "@" )){
//			userDto = userClient.getUserByEmail( input ).getUserDtoJaxb();
//		}
//		else {
//			userDto = userClient.getUserByUsername( input ).getUserDtoJaxb();
//		}
//
//		if (userDto == null) {
//			throw new UsernameNotFoundException( "User with email " + input + " was not found in the database" );
//		}
//
//		// [ROLE_USER, ROLE_ADMIN,..]
//		List< RoleDtoJaxb > roles = userDto.getRoles();
//		List<String> roleNames = new ArrayList<>();
//
//		roles.forEach( role -> roleNames.add( role.getRole() ) );
//
//		List< GrantedAuthority > grantList = new ArrayList< GrantedAuthority >();
//		if (!roleNames.isEmpty()) {
//			for (String role : roleNames) {
//				// ROLE_USER, ROLE_ADMIN,..
//				GrantedAuthority authority = new SimpleGrantedAuthority(role);
//				grantList.add(authority);
//			}
//		}
//
//		return ( UserDetails ) new org.springframework.security.core.userdetails.User(userDto.getUserName(),
//				userDto.getPassword(), grantList);
//
//	}
//}
