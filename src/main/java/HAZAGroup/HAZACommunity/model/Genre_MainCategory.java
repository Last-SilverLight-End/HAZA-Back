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
public class Genre_MainCategory {
    @Id
    @GeneratedValue
    @Column(name = "Genre_MainCategory_Id")
    private String User_Email;

    private int MainCategory_Id;
    private String Name;
}
