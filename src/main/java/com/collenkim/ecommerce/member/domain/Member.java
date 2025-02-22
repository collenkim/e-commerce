package com.collenkim.ecommerce.member.domain;

import com.collenkim.ecommerce.cd.Yn;
import com.collenkim.ecommerce.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Getter
@Entity
@Table(name = "member",
    indexes = {
        @Index(name = "idx_user_id", columnList = "user_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "use_yn", nullable = false)
    private String useYn;

    private Member(String userId, String password, String name, String phone, String useYn) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.useYn = useYn;
    }

    /**
     * 회원 생성
     *
     * @param userId
     * @param password
     * @param name
     * @param phone
     * @return
     */
    public static Member createMember(String userId, String password, String name, String phone) {
        return new Member(userId, password, name, phone, Yn.Y.getCode());
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateUseYn(String useYn) {
        this.useYn = useYn;
    }

}
