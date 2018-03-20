package com.springtutorial.backend.persistence.repositories;

import com.springtutorial.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by agrewal on 2/23/18.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
