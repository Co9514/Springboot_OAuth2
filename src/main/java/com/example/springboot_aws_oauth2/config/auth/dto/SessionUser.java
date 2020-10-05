package com.example.springboot_aws_oauth2.config.auth.dto;

import com.example.springboot_aws_oauth2.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//세션에 저장하기 위해 직렬화가 필요하지만 entity를 그대로 직렬화 할 경우 연관맵핑이 되어있는 다른 자식들까지 포함됨
//때문에 성능이슈, 부수효과가 발생할 확률이 높으므로 따로 dto를 만들어 직렬화합니다.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
