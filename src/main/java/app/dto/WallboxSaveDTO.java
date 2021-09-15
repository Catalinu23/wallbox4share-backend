package app.dto;

import app.entity.Wallbox;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class WallboxSaveDTO implements Serializable {
    private Long userId;
    private Wallbox wallbox;

}
