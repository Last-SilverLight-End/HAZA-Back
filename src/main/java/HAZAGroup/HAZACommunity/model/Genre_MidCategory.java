package HAZAGroup.HAZACommunity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Genre_MidCategory {
    @Id
    @GeneratedValue
    @Column(name = "Genre_MidCategory_Id")
    private int MidCategory_Id;
    private int ParentsCategory_Id;
    private String Name;
}

