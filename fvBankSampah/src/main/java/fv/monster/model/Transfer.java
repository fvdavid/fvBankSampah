package fv.monster.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Entity
@Table(name="transfer")
public class Transfer {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    @NotEmpty
    private String notujuan;

    @NotNull
    @Min(50000)
    private BigDecimal jumlah;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "waktutransaksi")
    // @Temporal(javax.persistence.TemporalType.DATE)
    private Date waktuTransfer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotujuan() {
        return notujuan;
    }

    public void setNotujuan(String notujuan) {
        this.notujuan = notujuan;
    }

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getWaktuTransfer() {
        return waktuTransfer;
    }

    public void setWaktuTransfer(Date waktuTransfer) {
        this.waktuTransfer = waktuTransfer;
    }

}
