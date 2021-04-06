package com.xxlspringboot.usermanage.service;

import com.xxlspringboot.usermanage.entity.Ability;
import com.xxlspringboot.usermanage.myexception.UserNotFoundException;
import com.xxlspringboot.usermanage.myexception.UsernameInUseException;
import com.xxlspringboot.usermanage.entity.Address;
import com.xxlspringboot.usermanage.entity.User;
import com.xxlspringboot.usermanage.repository.AbilityRepository;
import com.xxlspringboot.usermanage.repository.AddressRepository;
import com.xxlspringboot.usermanage.repository.UserRepository;
import com.xxlspringboot.usermanage.request.CreateAbilityRequest;
import com.xxlspringboot.usermanage.request.CreateUserRequest;
import com.xxlspringboot.usermanage.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AbilityRepository abilityRepository;

    //@Override
    public User createUser(CreateUserRequest createUserRequest){
        if(userRepository.findByUsername(createUserRequest.getUsername()) == null &&
           userRepository.findByEmail(createUserRequest.getEmail()) == null){

            User user = new User(createUserRequest);
            Address address = new Address(createUserRequest);

            user.setAddress(address);

            addressRepository.save(address);

            user = userRepository.save(user);

            List<Ability> abilities = new ArrayList<Ability>();
            if(createUserRequest.getAbilityList() != null){
                for(CreateAbilityRequest createAbilityRequest : createUserRequest.getAbilityList()){
                    Ability ability = new Ability();
                    ability.setAbilityName(createAbilityRequest.getAbilityName());
                    ability.setAbilityValue(createAbilityRequest.getAbilityValue());
                    ability.setUser(user);

                    abilities.add(ability);
                }
                abilityRepository.saveAll(abilities);
                user.setAbilities(abilities);
            }

            return  user;
        }else{
            throw new UsernameInUseException();
        }
    }

    //@Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    //@Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }

    public List<User> findByCity(String city){
        return userRepository.findByAddressCity(city);
    }

    public String deleteUserById(long id){
        try{
            addressRepository.deleteById(userRepository.findById(id).getAddress().getId());
            userRepository.deleteById(id);
            return "User " + id + " deleted";
        }catch (Exception e){
            return "User " + id + " not exist";
        }
    }
    public User updateUser(UpdateUserRequest updateUserRequest){
        User user = userRepository.findById(updateUserRequest.getId());

        if(user==null){
            throw new UserNotFoundException();
        }else{

            user.setName(updateUserRequest.getName());
            user.setUsername(updateUserRequest.getUsername());
            user.setEmail(updateUserRequest.getEmail());

            Address address = user.getAddress();
            address.setStreet(updateUserRequest.getStreet());
            address.setCity(updateUserRequest.getCity());

            user.setAddress(address);

            address = addressRepository.save(address);

            user = userRepository.save(user);

        }
        return user;
    }

    public List<User> getAllUserWithPagination (int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return userRepository.findAll(pageable).getContent();
    }
}
