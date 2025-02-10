//package com.app.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.app.entity.Vote;
//import com.app.service.VoteService;
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/vote")
//public class VoteController {
//
//    @Autowired
//    private VoteService voteService;
//
//    @PostMapping("/cast")
//    public ResponseEntity<Vote> castVote(@RequestBody Vote vote) {
//        voteService.addVote(vote);
//        return ResponseEntity.ok(vote);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Vote> getVoteById(@PathVariable Long id) {
//        Vote vote = voteService.getVoteById(id);
//        return ResponseEntity.ok(vote);
//    }
//}
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.entity.Vote;
import com.app.service.VoteService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/cast")
    public ResponseEntity<Vote> castVote(@RequestBody Vote vote) {
        voteService.addVote(vote);
        return ResponseEntity.ok(vote);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable Long id) {
        Vote vote = voteService.getVoteById(id);
        return ResponseEntity.ok(vote);
    }
}
