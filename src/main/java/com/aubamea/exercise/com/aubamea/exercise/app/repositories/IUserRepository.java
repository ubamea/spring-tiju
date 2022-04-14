package com.aubamea.exercise.com.aubamea.exercise.app.repositories;


import com.aubamea.exercise.com.aubamea.exercise.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
