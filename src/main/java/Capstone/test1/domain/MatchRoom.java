package Capstone.test1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class MatchRoom extends BaseTime {
    @Id @GeneratedValue
    private Long id;
    @Column(length = 100) @NotNull
    private String title;
    @Column(length = 500)
    private String content;
    @NotNull
    private int wantAvg;
    @Column(length = 100)
    private String area;
    @NotNull
    private LocalDateTime playTime;
    @NotNull
    private int playerNumber;
    @Column(length = 45)
    private String matchingCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(columnDefinition = "A")
    private String status;
}