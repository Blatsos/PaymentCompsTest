package Payment.components.test.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", unique = true, nullable = false)
    private long userId;

    @Column(name = "USER_NAME", unique = true)
    @NotBlank(message = "User name is mandatory")
    @Size(min = 1, max = 20)
    private String userName;

    @Column(name = "USER_PASSWORD", unique = true)
    @NotBlank(message = "Password field is mandatory")
    @Size(min = 4, max = 60)
    private String password;

    @Column(name = "USER_ISACTIVE")
    private boolean isActive;

    @Column(name = "USER_ROLES")
    private String userRoles;

//    @Column(name = "USER_TIMEZONE")
//    private String userTimezone;

    @Column(name = "USER_TIMEZONE")
    private TimeZone userTimezone = Calendar.getInstance().getTimeZone();

    public User() {
    }

    public TimeZone getUserTimezone() {
        return userTimezone;
    }

    public void setUserTimezone(TimeZone userTimezone) {
        this.userTimezone = userTimezone;
    }

    //    public String getUserTimezone() {
//        return userTimezone;
//    }
//
//    public void setUserTimezone(String userTimezone) {
//        this.userTimezone = userTimezone;
//    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }
}
