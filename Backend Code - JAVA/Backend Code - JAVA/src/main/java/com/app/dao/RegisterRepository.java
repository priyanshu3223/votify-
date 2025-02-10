package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    Register findByUsernameAndPassword(String username, String password);
    boolean existsByVoterIdNumber(String voterIdNumber);
    boolean existsByAadhaar(String aadhaar);

    @Query(value = "SELECT COUNT(*) FROM UserData WHERE voterID = ?1 AND aadhaarNumber = ?2", nativeQuery = true)
    Long countByVoterIdNumberAndAadhaar(String voterID, String aadhaarNumber);
}
