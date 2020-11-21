package com.example.datajpademo.repo;

import com.example.datajpademo.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Long> {
}
