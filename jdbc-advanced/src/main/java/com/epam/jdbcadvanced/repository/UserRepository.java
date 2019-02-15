package com.epam.jdbcadvanced.repository;

import com.epam.jdbcadvanced.model.SUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<SUser, Integer> {
    SUser findByname(String name);

    String TOP_MARCH_USERS_WITH_MULTIPLE_LIKES_QUERY = "select u.name from SUser u " +
            "where (Select count(l) from Like l where l.sUser = u and l.likeTime>:dateFrom and l.likeTime<:dateTo) >1 " +
            "and (Select count(p) from Post p where p.sUser = u) >1 " +
            "and (select count(f) from Friendship f where f.firstSUser = u)<50";


    @Query(TOP_MARCH_USERS_WITH_MULTIPLE_LIKES_QUERY)
    List<SUser> distinctUsers(@Param("dateFrom") LocalDate before, @Param("dateTo") LocalDate after);
}
