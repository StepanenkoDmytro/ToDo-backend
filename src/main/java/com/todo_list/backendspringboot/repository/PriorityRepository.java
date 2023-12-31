package com.todo_list.backendspringboot.repository;

import com.todo_list.backendspringboot.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    @Query("SELECT c FROM Priority c where " +
            "(:title is null or :title='' or lower(c.title) like lower (concat('%', :title, '%'))) " +
            "order by c.title asc")
    List<Priority> findByTitle(@Param("title") String title);
    List<Priority> findAllByOrderByIdAsc();
}
