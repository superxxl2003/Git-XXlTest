package com.xxlspringboot.usermanage.repository;

import com.xxlspringboot.usermanage.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public Address findById(long id);

}
