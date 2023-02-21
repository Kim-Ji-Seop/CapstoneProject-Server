package Capstone.uou.domain.history.entity;

import Capstone.uou.config.BaseEntity;
import Capstone.uou.domain.match.entity.MatchRoom;
import Capstone.uou.domain.user.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class History extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩 : N+1문제 해결방안
    @JoinColumn(name = "user_id") // (기록 - 유저)
    private Member memberIdx;

    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩 : N+1문제 해결방안
    @JoinColumn(name = "match_id") // (기록 - 매칭방)
    private MatchRoom matchIdx;

    private int teamIdx;

    @Enumerated(EnumType.STRING)
    @Column(name = "settle_type")
    private SettleType settleType;

    @Column(name = "total_score")
    private int totalScore;

    @OneToMany(mappedBy = "historyIdx")
    private List<BowlingScore> scores = new ArrayList<>();
}
