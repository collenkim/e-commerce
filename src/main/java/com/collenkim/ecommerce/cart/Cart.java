package com.collenkim.ecommerce.cart;

import com.collenkim.ecommerce.cd.CartStatus;
import com.collenkim.ecommerce.common.domain.BaseEntity;
import com.collenkim.ecommerce.member.domain.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
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

        @Index(name = "idx_status", columnList = "status")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToMany
    @JoinColumn(name = "cart_id")
    private List<CartItem> cartItemList;

    private Cart(Member member, String status) {
        this.member = member;
        this.status = status;
    }

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
