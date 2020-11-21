package com.example.datajpademo.service;

import com.example.datajpademo.model.User;
import com.example.datajpademo.repo.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void process() {
        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findByEmailAddress("m@g.com"));
        System.out.println(userRepository.findByAge(12));
        System.out.println("findByEmailAddressAndAge: "+userRepository.findByEmailAddressAndAge("m@g.com",12));
        System.out.println("findByEmailAddressOrAge: "+userRepository.findByEmailAddressOrAge("m@g.com",12));
        System.out.println("findByLastnameStartingWith: "+userRepository.findByLastnameStartingWith("test"));
        //System.out.println("findByLastnameLikeOrderByFirstnameDesc: "+userRepository.findByLastnameLikeOrderByFirstnameDesc("tes%"));

        Pageable pageable=PageRequest.of(0,2);
        System.out.println("findByLastnameContainingOrderByFirstnameDesc: "+userRepository.findByLastnameContainingOrderByFirstnameDesc("tes",pageable));
     //   System.out.println("findByLastnameOrderByFirstnameDescContaining: "+userRepository.findByLastnameOrderByFirstnameDescContaining("tes"));
        System.out.println("findname: "+userRepository.findname("Sharmila"));
        System.out.println("findfirstnameNative: "+userRepository.findfirstnameNative("Sharmila"));
 User u =User.builder().emailAddress("demo123@g.com").firstname("demo1").build();
 User u1=User.builder().emailAddress("demo225@gm.com").firstname("demo2").age(10).manager(u).build();
userRepository.save(u);
userRepository.save(u1);
        List<Object[]> list=userRepository.getByManger();
        System.out.println(list);
        for(Object[] objects: list){
            System.out.println(objects);
            System.out.println(objects[0]);
            System.out.println(objects[1]);
        }
    }
}
