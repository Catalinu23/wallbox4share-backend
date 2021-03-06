package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "USER")
@JsonIgnoreProperties({"hibernateLazyInitializer",
                       "handler"})
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "ADDRESS")
//    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;


    @OneToMany
    private List<Wallbox> ownWallboxes;

    public void addWallbox(Wallbox wallbox) {
        this.ownWallboxes.add(wallbox);
        wallbox.setOwner_id(this.id);
    }

    public void removeWallbox(Wallbox wallbox) {
        this.ownWallboxes.remove(wallbox);
        wallbox.setOwner_id(null);
    }
}
