package com.eministerios.www.business.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eministerios.www.business.entity.domain.Worker;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by alexandre on 09/03/16.
 */

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {

    @Query("SELECT w FROM Worker w WHERE LOWER(w.profession) = LOWER(:profession)")
    public List<Worker> findByProfession(@Param("profession") String profession);
}
