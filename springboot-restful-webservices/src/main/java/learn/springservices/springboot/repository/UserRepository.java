package learn.springservices.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.springservices.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
