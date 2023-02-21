package Capstone.uou.domain.match.entity;

import Capstone.uou.config.BaseEntity;
import Capstone.uou.domain.history.entity.History;
import Capstone.uou.domain.user.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class MatchRoom extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @Column(length = 100) @NotNull
    private String title;

    @Column(length = 500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member memberIdx;

    private LocalDateTime gameTime; // 예정시간

    @Column(name = "target_score")
    private int targetScore; // 원하는 점수대

    @Embedded
    private Address address; // 장소

    @Enumerated(EnumType.STRING)
    @Column(name = "network_type")
    private NetworkType networkType; // 온/오프라인 [ONLINE, OFFLINE]

    private int count; // 인원수

    private int cost; // 참가비

    @Column(name = "match_code", length = 45)
    private String matchCode; // 매칭코드

    @OneToMany(mappedBy = "matchIdx")
    private List<History> histories = new ArrayList<>();
}
