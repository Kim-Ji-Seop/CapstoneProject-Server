package Capstone.uou.domain.history.entity;

import Capstone.uou.config.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class BowlingScore extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Long id;

    private int firstPitch;

    private int secondPitch;

    private int thirdPitch;

    private int frameNumber;

    private int accumulateScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_id")
    private History historyIdx;

    @Enumerated(EnumType.STRING)
    private ScoreType scoreType;
}
