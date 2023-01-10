package HAZAGroup.HAZACommunity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "User_Email",nullable = false,length = 200)
    private String Email;
    @Column(nullable = false , length = 200)
    private String Name;
    @Convert// 나중에 여기에 컨버터 클래스 넣기
    private boolean IsAdmin;

    @OneToMany(mappedBy= "member")
    private List<Genre_BulletinBoard> Bulletins = new ArrayList<Genre_BulletinBoard>();

}
