package idv.owen.Application.dao;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import idv.owen.Application.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	@Query("select s from User s where s.user_name=?1")
	public User findByUsername(String user_name);
}
