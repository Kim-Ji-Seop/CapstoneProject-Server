package Capstone.test1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Users extends BaseTime{
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(length = 45) @NotNull
    private String uid;
    @Column(length = 50) @NotNull
    private String password;
    @Column(length = 50) @NotNull
    private String nickname;
    private int scoreAvg;
    @Column(columnDefinition = "A")
    private String status;

    @OneToMany(mappedBy = "user")
    private List<MatchRoom> rooms = new ArrayList<>();
}
