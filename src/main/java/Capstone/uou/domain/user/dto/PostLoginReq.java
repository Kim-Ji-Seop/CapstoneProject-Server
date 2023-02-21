package Capstone.uou.domain.user.dto;

import lombok.Data;

@Data
public class PostLoginReq {
    private String uid;
    private String password;
    private String accessToken;
}
