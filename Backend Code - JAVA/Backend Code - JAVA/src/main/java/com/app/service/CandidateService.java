//package com.app.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.app.entity.Candidate;
//import com.app.dao.CandidateRepository;
//
//@Service
//public class CandidateService {
//
//    @Autowired
//    private CandidateRepository candidateRepository;
//
//    public void addCandidate(Candidate candidate) {
//        candidateRepository.save(candidate);
//    }
//
//    public Candidate getCandidateById(Long id) {
//        return candidateRepository.findById(id).orElse(null);
//    }
//
//    public Candidate getCandidateByName(String name) {
//        return candidateRepository.findByName(name);
//    }
//
//    public void incrementVoteCount(Candidate candidate) {
//        candidate.incrementVoteCount();
//        candidateRepository.save(candidate); // Ensure this method saves the updated candidate
//    }
//}
package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.Candidate;
import com.app.dao.CandidateRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    // ✅ Add a new candidate
    public void addCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    // ✅ Get a candidate by ID
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    // ✅ Get all candidates
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // ✅ Get candidate by name
    public Candidate getCandidateByName(String name) {
        return candidateRepository.findByName(name);
    }

    // ✅ Increment vote count (now takes candidateId as argument)
    @Transactional
    public void incrementVoteCount(Long candidateId) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(candidateId);
        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();
            candidate.setVoteCount(candidate.getVoteCount() + 1);
            candidateRepository.save(candidate);
        } else {
            throw new IllegalArgumentException("Candidate not found");
        }
    }
}