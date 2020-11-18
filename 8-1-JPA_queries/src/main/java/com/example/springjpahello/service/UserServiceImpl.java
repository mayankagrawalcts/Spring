package com.example.springjpahello.service;

import com.example.springjpahello.entity.User;
import com.example.springjpahello.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void process() {
        User user = new User();
        user.setAge(19);
        user.setEmailAddress(new Random().nextInt(100) +"demo6@gmail.com");
        user.setFirstname("demo");
        user.setLastname("impl");

        //userRepository.save(user);

        log.info("findByEmailAddress: " + userRepository.findByEmailAddress("m@g.com"));
        User u = userRepository.findById(10001L).get();
        u.setManager(userRepository.findById(10002L).get());
        log.info("updated: " + userRepository.save(u));
        log.info("findByEmailAddressAndLastname: " +
                userRepository.findByEmailAddressAndLastname("ma@gmail.com", "test5"));
        log.info("findByLastnameOrFirstname: " +
                userRepository.findByLastnameOrFirstname("agrawal", "sasi"));
        log.info("findByLastnameNot: " +
                userRepository.findByLastnameNot("test1"));
        log.info("findByLastnameNotNull: " +
                userRepository.findByLastnameNotNull());
        log.info("findByLastnameNotLike: " +
                userRepository.findByLastnameNotLike("test%"));
        log.info("findByAgeGreaterThanEqual: " +
                userRepository.findByAgeGreaterThanEqual(13));
        log.info("findByLastnameLikeOrderByFirstnameDesc: " +
                userRepository.findByLastnameLikeOrderByFirstnameDesc("test%"));
        log.info("findByAnnotatedQuery: " +
                userRepository.findByAnnotatedQuery("ma@gmail.com"));
        log.info("findByLastnameContainingIgnoreCase: " +
                userRepository.findByLastnameContainingIgnoreCase("TEST"));
        log.info("findByLastnameContaining: " +
                userRepository.findByLastnameContaining("test"));
        log.info("findByFirstnameLikeNamed: " +
                userRepository.findByFirstnameLikeNamed("Thir"));

        log.info("countWithFirstname: " +
                userRepository.countWithFirstname("Thiru"));
        String[] arr={"Thir","mayank"};
        log.info("findByFirstnameNotIn: " +
                userRepository.findByFirstnameNotIn(Arrays.asList(arr)));

        log.info("findNativeByLastname: " +
                userRepository.findNativeByLastname("test2"));

        log.info("findByNameLikeUsingNamedParameter: " +
                userRepository.findByNameLikeUsingNamedParameter("Thir"));
        Sort sort=Sort.by(new Sort.Order[]{new Sort.Order( Sort.Direction.DESC,"firstname"),
                new Sort.Order( Sort.Direction.ASC,"lastname")});
        Pageable pageable=PageRequest.of(0,2,sort);
        log.info("findByLastnameStartingWith: " +
                userRepository.findByLastnameStartingWith("test",pageable));
        log.info("secondPage: " +
                userRepository.findByLastnameStartingWith("test",PageRequest.of(2,2,sort)));
       // log.info("findByLastnameGrouped: " +
         //       userRepository.findByLastnameGrouped(pageable));

        log.info("findByFirstNameAndLastName: " +
                userRepository.findByFirstNameAndLastName("Thiru","test3"));

        log.info("findByFirstName: " +
                userRepository.findByFirstName("Thiru"));
      //  userRepository.addColumn();
        List<Object[]> lst = userRepository.getMultipleEntities();
        System.out.println("data: "+lst);
        for (Object o[] : lst) {
            System.out.println("User: "+o[0]+" :"+((User)o[0]).getManager());
            System.out.println("Manager: "+o[1]);
        }
    }
}
