package com.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "party")
    private String party;

    @Column(name = "position")
    private String position;

    @Column(name = "photo")
    private String photo;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "vote_count")
    private int voteCount;

    public Candidate() {
        super();
    }

    public Candidate(String name, String party, String position, String photo, String symbol) {
        this.name = name;
        this.party = party;
        this.position = position;
        this.photo = photo;
        this.symbol = symbol;
        this.voteCount = 0;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public void incrementVoteCount() {
        this.voteCount++;
    }
}
