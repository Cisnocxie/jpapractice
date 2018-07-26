package com.oocl.jpapractice.onetoone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Table(name = "klass")
@Entity
public class Klass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "klass", fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private Leader leader;

    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now();

    public Klass(String name) {
        this.name = name;
    }

    public Klass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createDate) {
        this.createdDate = createDate;
    }
}
