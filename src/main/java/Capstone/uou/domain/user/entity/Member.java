package Capstone.uou.domain.user.entity;

import Capstone.uou.config.BaseEntity;
import Capstone.uou.domain.history.entity.History;
import Capstone.uou.domain.match.entity.MatchRoom;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 45) @NotNull
    private String uid;

    @Column(length = 50) @NotNull
    private String password;

    @Column(length = 50) @NotNull
    private String name;

    @Column(length = 50) @NotNull
    private String nickname;

    @OneToMany(mappedBy = "userIdx") // 매칭방과 1:N
    private List<MatchRoom> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "userIdx") // 경기기록(유저-매칭방 매핑 엔티티)과 1:N
    private List<History> histories = new ArrayList<>();
}
