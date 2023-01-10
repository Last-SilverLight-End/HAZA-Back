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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="User_ID")
    private int id;

    @Column(nullable = false,length = 200)
    private String Email;
    @Column(nullable = false , length = 200)
    private String Name;
    @Convert// 나중에 여기에 컨버터 클래스 넣기
    private boolean IsAdmin;

}
