package com.example.medical_history.repository;

import com.example.medical_history.domain.Disease;
import com.example.medical_history.domain.User;
import com.example.medical_history.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String listName);
    Optional<User> findByUsername(String username);

    List<User> findAllByRoleIsAndUsernameIn(Role role, List<String> username);

    List<User> findAllByRoleIs(Role role);

    @Query(value = "SELECT * FROM users ORDER BY salary DESC", nativeQuery = true)
    List<User> findBySalaryMax();

    @Query(value = "SELECT * FROM users ORDER BY salary ASC", nativeQuery = true)
    List<User> findBySalaryMin();

    @Query(value = "SELECT * FROM users as usr JOIN users_diseases as uds WHERE uds.name in ?1", nativeQuery = true)
    List<User> findAllByDiseases(List<Disease> diseases);
}
