//package com.app.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.app.entity.Candidate;
//import com.app.service.CandidateService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/candidate")
//public class CandidateController {
//
//    @Autowired
//    private CandidateService candidateService;
//
//    @PostMapping("/add")
//    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
//        candidateService.addCandidate(candidate);
//        return ResponseEntity.ok(candidate);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
//        Candidate candidate = candidateService.getCandidateById(id);
//        return ResponseEntity.ok(candidate);
//    }
//}

package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.entity.Candidate;
import com.app.service.CandidateService;
import com.app.service.VoteService;
import com.app.entity.Vote;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin(origins = "http://localhost:3000") // Adjust based on frontend URL
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private VoteService voteService;

    // ✅ Add a new candidate
    @PostMapping("/add")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        candidateService.addCandidate(candidate);
        return ResponseEntity.ok(candidate);
    }

    // ✅ Get a candidate by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        Candidate candidate = candidateService.getCandidateById(id);
        return candidate != null ? ResponseEntity.ok(candidate) : ResponseEntity.notFound().build();
    }

    // ✅ Get all candidates
    @GetMapping("/all")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }

    // ✅ Cast a vote for a candidate
    @PostMapping("/vote/cast/{candidateId}")
    public ResponseEntity<String> castVote(@PathVariable Long candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        if (candidate == null) {
            return ResponseEntity.badRequest().body("Candidate not found");
        }

        Vote vote = new Vote();
        vote.setCandidate(candidate);
        voteService.addVote(vote);

        return ResponseEntity.ok("Vote successfully cast for " + candidate.getName());
    }
}
