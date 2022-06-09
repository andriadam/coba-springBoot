package com.investree.demo.repository;

import com.investree.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        PagingAndSortingRepository<User, Long> {

    @Query("select c from User c WHERE c.id = :id")
    public User getbyID(@Param("id") Long id);

    @Query("select c from User c WHERE c.username = :username")// nama class
    Page<User> getbyUsername(String username, Pageable pageable);

    @Query("select c from User c")// nama class
    Page<User> getAllData(Pageable pageable);
}
