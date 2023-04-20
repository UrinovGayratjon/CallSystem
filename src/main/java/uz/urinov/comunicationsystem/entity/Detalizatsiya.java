package uz.urinov.comunicationsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import uz.urinov.comunicationsystem.entity.enums.Action;

import java.sql.Timestamp;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Detalizatsiya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Action action;

    private Double amount;

    private Double price = 0D;

    @ManyToOne
    private SimCard simCard;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    public Detalizatsiya(Action action, Double amount, SimCard simCard) {
        this.action = action;
        this.amount = amount;
        this.simCard = simCard;
    }

    public Detalizatsiya(Action action, Double amount, SimCard simCard, Double price) {
        this.action = action;
        this.amount = amount;
        this.simCard = simCard;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Detalizatsiya that = (Detalizatsiya) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
