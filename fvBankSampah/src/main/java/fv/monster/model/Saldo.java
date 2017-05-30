package fv.monster.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Entity
@Table(name="saldo")
public class Saldo {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private BigDecimal money;

    @NotNull
    @NotEmpty
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTerakhir;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUpdateTerakhir() {
        return updateTerakhir;
    }

    public void setUpdateTerakhir(Date updateTerakhir) {
        this.updateTerakhir = updateTerakhir;
    }

}
