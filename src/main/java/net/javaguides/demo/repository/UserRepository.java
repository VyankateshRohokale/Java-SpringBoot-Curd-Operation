package net.javaguides.demo.repository;

import net.javaguides.demo.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long>
{

}
