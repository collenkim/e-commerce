package com.collenkim.ecommerce.cart.domain;

import com.collenkim.ecommerce.cd.CartStatus;
import com.collenkim.ecommerce.common.domain.BaseEntity;
import com.collenkim.ecommerce.member.domain.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Getter
@Entity
@Table(name = "cart",
    indexes = {
        @Index(name = "idx_member_id", columnList = "member_id"),
        @Index(name = "idx_status", columnList = "status")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, unique = true)
    private Member member;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    private Cart(Member member, String status) {
        this.member = member;
        this.status = status;
    }

    /**
     * 장바구니 생성 (담기 버튼 클릭 시 혹은 회원 가입 시)
     *
     * @param member
     * @return
     */
    public static Cart createCart(Member member) {
        return new Cart(member, CartStatus.CREATED.name());
    }

    public void updateTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = this.totalPrice.add(totalPrice);
    }

    public void updateStatus(CartStatus status) {
        this.status = status.name();
    }
}
