package com.xxlspringboot.usermanage.entity;

import com.xxlspringboot.usermanage.request.CreateUserRequest;
import com.xxlspringboot.usermanage.request.UpdateUserRequest;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
		
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "user")
	private List<Ability> abilities;

	public User(CreateUserRequest createUserRequest) {
		this.name = createUserRequest.getName();
		this.username = createUserRequest.getUsername();
		this.email = createUserRequest.getEmail();
		this.createTime = LocalDateTime.now();
	}

	public User(UpdateUserRequest updateUserRequest){
		this.name = updateUserRequest.getName();
		this.username = updateUserRequest.getUsername();
		this.email = updateUserRequest.getEmail();
	}

}
