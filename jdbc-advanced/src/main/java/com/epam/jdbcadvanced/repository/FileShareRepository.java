package com.epam.jdbcadvanced.repository;

import com.epam.jdbcadvanced.model.FileShare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileShareRepository extends JpaRepository<FileShare, Integer> {
}
