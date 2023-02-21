package Capstone.uou.domain.user.service;

import Capstone.uou.config.BaseException;
import Capstone.uou.config.BaseResponse;
import Capstone.uou.domain.user.dto.PostSignUpReq;
import Capstone.uou.domain.user.dto.PostSignUpRes;
import Capstone.uou.domain.user.entity.Member;
import Capstone.uou.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static Capstone.uou.config.BaseResponseStatus.POST_USERS_EXISTS_ID;
import static Capstone.uou.config.BaseResponseStatus.POST_USERS_EXISTS_PW;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입 구현 미완
    public ResponseEntity<BaseResponse<PostSignUpRes>> signUp(PostSignUpReq postSignUpReq) throws BaseException {
        if (memberRepository.findByUid(postSignUpReq.getUid()).isPresent()){
            throw new BaseException(POST_USERS_EXISTS_ID);
        }
        if (!postSignUpReq.getPassword().equals(postSignUpReq.getCheckedPassword())){
            throw new BaseException(POST_USERS_EXISTS_PW);
        }
        Member member = memberRepository.save(postSignUpReq.toEntity());
        return null;
    }
}
