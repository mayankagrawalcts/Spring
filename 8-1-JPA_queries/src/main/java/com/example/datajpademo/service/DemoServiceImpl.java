package com.example.datajpademo.service;

import com.example.datajpademo.model.*;
import com.example.datajpademo.repo.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class DemoServiceImpl implements DemoService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DemoServiceImpl.class);
    final
    Itemrepository itemrepository;

    final PersonRepository personRepository;

    final
    Studentrepository studentrepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    FulltimeEmployeeRepository fulltimeEmployeeRepository;
    @Autowired
    ParttimeEmployeeRepository parttimeEmployeeRepository;

    public DemoServiceImpl(Itemrepository itemrepository, PersonRepository personRepository, Studentrepository studentrepository) {
        this.itemrepository = itemrepository;
        this.personRepository = personRepository;
        this.studentrepository = studentrepository;
    }

    @Transactional
    public void process() {
        /*
        Item item = new Item();
        item.setName("commit false");
        item.setPrice(111);
        itemrepository.save(item);
        Person p = new Person();
        p.setLastName("agrawal");
        p.setFirstName("mayank");
        personRepository.save(p);
         */
        Student s = new Student();
        s.setName("Mayank");
        Passport passport = new Passport();
        passport.setPassportNumber("1231");
        s.setPassport(passport);
        System.out.println(passport.getId() + " studentId:" + s.getId());
        studentrepository.save(s);
        Student student1 = studentrepository.findById(65L).orElse(new Student());
        System.out.println(student1);
        System.out.println("Student passport: " + student1.getPassport());
    }

    @Transactional
    public void CourseProcess() {
        Course c = new Course();
        c.setName("Java");
        List<Review> list = new ArrayList<>();
        Review r1 = new Review();
        r1.setDescription("r1");
        r1.setCourse(c);
        Review r2 = new Review();
        r2.setDescription("r2");
        r2.setCourse(c);
        c.addReview(r1);
        c.addReview(r2);
        courseRepository.save(c);
        reviewRepository.save(r1);
        reviewRepository.save(r2);

        Course getCourse;
        Optional<Course> op = courseRepository.findById(139L);
        if (op.isPresent()) {
            getCourse = op.get();
        } else {
            getCourse = new Course();
        }
        System.out.println(getCourse);
        System.out.println(getCourse.getReviews());
    }

    @Transactional
    public void CourseStudentProcess() {
        Course c = new Course();
        c.setName("Java");
        Course c1 = new Course();
        c1.setName("oracle");

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Student s1 = new Student();
        s1.setName("Mayank");
        s1.addCourse(c);
        s1.addCourse(c1);
        Student s2 = new Student();
        s2.setName("Sharmila");
        c.addStudent(s1);
        c1.addStudent(s2);
        courseRepository.save(c);
        courseRepository.save(c1);
        studentrepository.save(s1);
        studentrepository.save(s2);
    }

    @Transactional
    public void EmployeeService() {
        FulltimeEmployee e = new FulltimeEmployee("Mayank", new BigDecimal(12));
        ParttimeEmployee e1 = new ParttimeEmployee("Nikhil", new BigDecimal(14));
        Address address = Address.builder().line1("123").line2("34").build();
        Address address1 = Address.builder().line1("123").build();
        e.setAddress(address);
        e1.setAddress(address1);
        Set<Address> addresses=new HashSet<>();
        addresses.add(address);
        addresses.add(address1);
        e.setAddresses(addresses);
        employeeRepository.save(e);
        employeeRepository.save(e1);
        System.out.println(parttimeEmployeeRepository.findAll());
        //System.out.println(fulltimeEmployeeRepository.findAll());
        employeeRepository.findById(12L).
                ifPresentOrElse(employeeRepository::delete, () -> {
                    System.out.println("Id not found");
                });

    }
}
