package com.tsv.diz.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 8, max = 20)
	@Column(nullable = false, unique = true)
	private String email;

	@Column(length = 100)
	private String password;

	@Column(nullable = false)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL)
	private List<Option> options;

	@OneToMany(mappedBy="user")
	private List<SavedAd> savedAds;

	@OneToMany(mappedBy = "user")
	private List<SearchHistory> searchHistoryAds;
	
	@OneToOne(mappedBy="user")
	private Result result;
	
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public void addRoles(Set<Role> roles) {
		roles.forEach(this::addRole);
	}

	public User() {

	}
	
	public User(@Size(min = 8, max = 20) String email, String password, boolean enabled, Set<Role> roles) {
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}



	public User(Long id, @Size(min = 8, max = 20) String email, String password, boolean enabled) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public User(@Size(min = 8, max = 20) String email, String password, boolean enabled) {
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}
	
	public void addOption(Option option) {
		if(options == null) {
			options = new ArrayList<>();
		}
		options.add(option);
		option.setUser(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
