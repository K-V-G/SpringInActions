package tacos.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name="Taco_Order")
public class TacoOrder implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  private Date placedAt;

  @ManyToOne
  private User user;

  @NotBlank(message="Delivery name is required")
  private String deliveryName;

  @NotBlank(message="Street is required")
  private String deliveryStreet;

  @NotBlank(message="City is required")
  private String deliveryCity;

  @NotBlank(message="State is required")
  private String deliveryState;

  @NotBlank(message="Zip code is required")
  private String deliveryZip;

  private String ccNumber;

  private String ccExpiration;

  private String ccCVV;

  @ManyToMany(targetEntity= Taco.class)
  private List<Taco> tacos = new ArrayList<>();

  public void addTaco(Taco design) {
    this.tacos.add(design);
  }

  @PrePersist
  void placedAt() {
    this.placedAt = new Date();
  }

  @Override
  public String toString() {
    return "TacoOrder{" +
            "id=" + id +
            ", placedAt=" + placedAt +
            ", deliveryName='" + deliveryName + '\'' +
            ", deliveryStreet='" + deliveryStreet + '\'' +
            ", deliveryCity='" + deliveryCity + '\'' +
            ", deliveryState='" + deliveryState + '\'' +
            ", deliveryZip='" + deliveryZip + '\'' +
            ", ccNumber='" + ccNumber + '\'' +
            ", ccExpiration='" + ccExpiration + '\'' +
            ", ccCVV='" + ccCVV + '\'' +
            '}';
  }
}
