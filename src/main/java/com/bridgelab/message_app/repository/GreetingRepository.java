package com.bridgelab.message_app.repository;

import com.bridgelab.message_app.model.Greeting;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  GreetingRepository extends JpaRepository<Greeting, Long> {

}
