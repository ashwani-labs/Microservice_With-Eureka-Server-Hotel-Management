package com.example.UserPortion.Dao.Repository;

import com.example.UserPortion.Dao.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
