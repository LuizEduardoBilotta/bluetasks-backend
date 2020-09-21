package br.com.bilotta.bluetasks.infrastructure.web.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.bilotta.bluetasks.domain.user.AppUser;

@SuppressWarnings("serial")
public class UserDetailsImpl implements UserDetails{

	private String username;
	private String password;
	private String displayName;
	
	public UserDetailsImpl(AppUser appuser) {
		this.username = appuser.getUsername();
		this.password = appuser.getPassword();
		this.displayName = appuser.getDisplayName();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.NO_AUTHORITIES;
	}

	@Override
	public String getPassword() {
	return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
