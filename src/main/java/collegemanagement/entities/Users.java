package collegemanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users
{
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int  UserId;

    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role role;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
