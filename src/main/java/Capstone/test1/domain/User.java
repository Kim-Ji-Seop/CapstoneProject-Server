package Capstone.test1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseTime{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 45) @NotNull
    private String uid;

    @Column(length = 50) @NotNull
    private String password;

    @Column(length = 50) @NotNull
    private String nickname;

    private int scoreAvg;

    @Column(length = 10)
    @ColumnDefault("'A'")
    private String status;

    @OneToMany(mappedBy = "userIdx")
    private List<MatchRoom> rooms = new ArrayList<>();
}
