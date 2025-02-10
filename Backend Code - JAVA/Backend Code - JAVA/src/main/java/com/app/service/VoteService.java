//package com.app.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.app.entity.Vote;
//import com.app.entity.Candidate;
//import com.app.dao.VoteRepository;
//import com.app.dao.CandidateRepository;
//import jakarta.transaction.Transactional;
//import java.util.Date;
//
//@Service
//public class VoteService {
//
//    @Autowired
//    private VoteRepository voteRepository;
//
//    @Autowired
//    private CandidateService candidateService;
//
//    @Autowired
//    private CandidateRepository candidateRepository;
//
//    @Transactional
//    public void addVote(Vote vote) {
//        // Fetch the candidate from the database to ensure the reference is correct
//        Candidate candidate = candidateRepository.findById(vote.getCandidate().getId()).orElse(null);
//        if (candidate == null) {
//            throw new IllegalArgumentException("Candidate not found");
//        }
//
//        // Set the correct candidate reference in the vote
//        vote.setCandidate(candidate);
//        vote.setVoteDate(new Date()); // Set the current date and time
//        voteRepository.save(vote);
//        candidateService.incrementVoteCount(candidate);
//    }
//
//    @Transactional
//    public Vote getVoteById(Long id) {
//        return voteRepository.findById(id).orElse(null);
//    }
//}
package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.Vote;
import com.app.entity.Candidate;
import com.app.dao.VoteRepository;
import com.app.dao.CandidateRepository;
import jakarta.transaction.Transactional;
import java.util.Date;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateRepository candidateRepository;

    @Transactional
    public void addVote(Vote vote) {
        // Fetch the candidate from the database
        Candidate candidate = candidateRepository.findById(vote.getCandidate().getId()).orElse(null);
        if (candidate == null) {
            throw new IllegalArgumentException("Candidate not found");
        }

        // Set the correct candidate reference in the vote
        vote.setCandidate(candidate);
        vote.setVoteDate(new Date()); // Set the current date and time
        voteRepository.save(vote);

        // ✅ Updated: Pass candidateId instead of Candidate object
        candidateService.incrementVoteCount(candidate.getId());
    }

    @Transactional
    public Vote getVoteById(Long id) {
        return voteRepository.findById(id).orElse(null);
    }
}