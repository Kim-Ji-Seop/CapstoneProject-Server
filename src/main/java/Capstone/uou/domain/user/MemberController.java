package Capstone.uou.domain.user;

import Capstone.uou.config.BaseException;
import Capstone.uou.config.BaseResponse;
import Capstone.uou.domain.user.dto.PostSignUpReq;
import Capstone.uou.domain.user.dto.PostSignUpRes;
import Capstone.uou.domain.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static Capstone.uou.config.BaseResponseStatus.FORBIDDEN;
import static Capstone.uou.config.BaseResponseStatus.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/test")
    public ResponseEntity<BaseResponse> userTest(){
        try{
            return ResponseEntity.ok(new BaseResponse<>(SUCCESS));
        } catch(BaseException exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new BaseResponse<>(FORBIDDEN));
        }

    }
    @PostMapping("/sign-up")
    public ResponseEntity<BaseResponse<PostSignUpRes>> signUp(@RequestBody PostSignUpReq postSignUpReq){
        return memberService.signUp(postSignUpReq);
    }
}
