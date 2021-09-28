package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "WALLBOX")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Wallbox implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

//    @Column(name="OWNER_NAME")
//    private String owner_name;

    @Column(name ="LATITUDE")
    private Double latitude;

    @Column(name ="LONGITUDE")
    private Double longitude;

    @Column(name="PHONE_NUMBER")
    private String phone_number;

    @Column(name="DESCRIPTION")
    private String description;

    //@ManyToOne
    @Column(name ="OWNER_ID")
    private Long owner_id;
}


