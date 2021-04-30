package com.kj.springdatataskManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface taskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t where t.status = :status ORDER BY t.deadline ASC")
    List<Task> findByStatus(Status status);

    List<Task> findByOrderByDeadlineAsc();

    @Transactional
    @Modifying
    @Query("update Task t set t.status = 'DONE' where t.id = :id")
    void markAsComplete(@Param(value = "id") Long id);
}
