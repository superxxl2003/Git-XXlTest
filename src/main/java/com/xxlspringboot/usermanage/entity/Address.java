package com.xxlspringboot.usermanage.entity;

import com.xxlspringboot.usermanage.request.CreateUserRequest;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(CreateUserRequest createUserRequest) {
        this.street = createUserRequest.getStreet();;
        this.city = createUserRequest.getCity();
    }
}
