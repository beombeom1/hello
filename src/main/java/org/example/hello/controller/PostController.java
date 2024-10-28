package org.example.hello.controller;

import org.example.hello.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PostController {

    //http://localhost:8080/api/v1/put-api/domain
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post Api";
    }

    //http://localhost:8080/api/v1/put-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " + " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //http://localhost:8080/api/v1/put-api/member2
    @PostMapping(value = "/member2")
    public String postMember(@RequestBody MemberDto memberDto){

        return memberDto.toString();
    }

//http://localhost:8080/api/v1/post-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
