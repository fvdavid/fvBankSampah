package fv.monster.model;

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
@Table(name ="jual")
public class Jual {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    @Min(1000)
    private BigDecimal harga;

    @NotNull
    @Min(0)
    private BigDecimal jumlah;

    @NotNull
    @NotEmpty
    private String jenis;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_jual")
    private Date waktuJual;

    @NotNull
    @NotEmpty
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }

    public Date getWaktuJual() {
        return waktuJual;
    }

    public void setWaktuJual(Date waktuJual) {
        this.waktuJual = waktuJual;
    }
    
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
