package com.tenth.Shopping.Repository;

import com.tenth.Shopping.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< UserDetails , Integer> {

}
