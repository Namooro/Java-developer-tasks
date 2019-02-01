package com.epam.jdbcadvanced.repository;

import com.epam.jdbcadvanced.model.SUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<SUser, Integer> {
    SUser findByname(String name);

    String TOP_MARCH_USERS_WITH_MULTIPLE_LIKES_QUERY = "select distinct(u.name) from friendship f " +
            "inner join suser u on f.user_Id = u.user_Id " +
            "inner join post p on p.user_Id = u.user_Id " +
            "inner join likes l on l.post_id = p.post_id " +
            "where count(f.other_User_Id) > 100 " +
            "and count(distinct l.like_Id) > 100 " +
            "and l.like_time<:dateFrom and l.like_time>:dateTo " +
            "group by f.user_Id";


    @Query(value = TOP_MARCH_USERS_WITH_MULTIPLE_LIKES_QUERY, nativeQuery = true)
    List<SUser> distinctUsers(@Param("dateFrom") LocalDate before, @Param("dateTo") LocalDate after);
}
