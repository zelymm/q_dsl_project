package com.ll.exam.qsl.base;

import com.ll.exam.qsl.user.entity.SiteUser;
import com.ll.exam.qsl.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test") // 이 클래스 정의된 Bean 들은 test 모드에서만 활성화된다
public class TestInitData {
    // CommandLineRunner : 주로 앱 실행 직후 초기데이터 세팅 및 초기화에 사용 -> 알아서 나중에 실행된다
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            SiteUser u1 = SiteUser.builder()
                    .username("user1")
                    .password("{noop}1234")
                    .email("user1@test.com")
                    .build();

            SiteUser u2 = SiteUser.builder()
                    .username("user2")
                    .password("{noop}1234")
                    .email("user2@test.com")
                    .build();

            SiteUser u3 = SiteUser.builder()
                    .username("user3")
                    .password("{noop}1234")
                    .email("user3@test.com")
                    .build();

            SiteUser u4 = SiteUser.builder()
                    .username("user4")
                    .password("{noop}1234")
                    .email("user4@test.com")
                    .build();

            SiteUser u5 = SiteUser.builder()
                    .username("user5")
                    .password("{noop}1234")
                    .email("user5@test.com")
                    .build();

            SiteUser u6 = SiteUser.builder()
                    .username("user6")
                    .password("{noop}1234")
                    .email("user6@test.com")
                    .build();

            SiteUser u7 = SiteUser.builder()
                    .username("user7")
                    .password("{noop}1234")
                    .email("user7@test.com")
                    .build();

            SiteUser u8 = SiteUser.builder()
                    .username("user8")
                    .password("{noop}1234")
                    .email("user8@test.com")
                    .build();

            u1.addInterestKeywordContent("축구");
            u1.addInterestKeywordContent("농구");

            u2.addInterestKeywordContent("클라이밍");
            u2.addInterestKeywordContent("마라톤");
            u2.addInterestKeywordContent("농구");

            userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8)); // PERSIST

            u8.follow(u7);
            u8.follow(u6);
            u8.follow(u5);
            u8.follow(u4);
            u8.follow(u3);

            u7.follow(u6);
            u7.follow(u5);
            u7.follow(u4);
            u7.follow(u3);

            userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8)); // MERGE
        };
    }
}
