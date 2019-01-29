package com.epam.jdbcadvanced.repository;

import com.epam.jdbcadvanced.model.SUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<SUser, Integer> {
    SUser findByname(String name);

    /*String TOP_MARCH_USERS_WITH_MULTIPLE_LIKES_QUERY = "select distinct(s.name) from suser s";

    @Query(value = TOP_MARCH_USERS_WITH_MULTIPLE_LIKES_QUERY, nativeQuery = true)
    List<SUser> distinctUsers(@Param("dateFrom") LocalDate before, @Param("dateTo") LocalDate after);*/
}
