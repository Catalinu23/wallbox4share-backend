package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CAR")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car implements Serializable  {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name ="CAR_BRAND")
    private String car_brand;


}
