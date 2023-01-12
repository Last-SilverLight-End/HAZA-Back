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
public class Genre_BulletinBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Genre_BulletinBoard_Id")
    private int Id;
    private int MainCategory_Id;
    private int MidCategory_Id;
    @ManyToOne
    @JoinColumn(name = "User_Email")
    private User UserEmail;
    private String Title;
    private String UserName;
    @Column(nullable = false, length = 50)
    private String Email;
    @Column(nullable = false , length = 200)
    private String Name;
    @Convert// 나중에 여기에 컨버터 클래스 넣기
    private boolean IsAdmin;

}
