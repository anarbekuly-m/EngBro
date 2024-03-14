package kz.engbro.entity.model;

import jakarta.persistence.*;
import kz.engbro.entity.enumuration.Language;
import kz.engbro.entity.enumuration.Level;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "count")
    private Long count;

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Level level;

    public User(Long id, String username, String password, Long count, Language language, Level level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.count = count;
        this.language = language;
        this.level = level;
    }

    public User() {
    }

    public static UserFactory builder() {
        return new UserFactory();
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Long getCount() {
        return this.count;
    }

    public String getLanguage() {
        return this.language.name();
    }

    public Level getLevel() {
        return this.level;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$count = this.getCount();
        final Object other$count = other.getCount();
        if (this$count == null ? other$count != null : !this$count.equals(other$count)) return false;
        final Object this$language = this.getLanguage();
        final Object other$language = other.getLanguage();
        if (this$language == null ? other$language != null : !this$language.equals(other$language)) return false;
        final Object this$level = this.getLevel();
        final Object other$level = other.getLevel();
        if (this$level == null ? other$level != null : !this$level.equals(other$level)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $count = this.getCount();
        result = result * PRIME + ($count == null ? 43 : $count.hashCode());
        final Object $language = this.getLanguage();
        result = result * PRIME + ($language == null ? 43 : $language.hashCode());
        final Object $level = this.getLevel();
        result = result * PRIME + ($level == null ? 43 : $level.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", count=" + this.getCount() + ", language=" + this.getLanguage() + ", level=" + this.getLevel() + ")";
    }

    public static class UserFactory {
        private Long id;
        private String username;
        private String password;
        private Long count;
        private Language language;
        private Level level;

        UserFactory() {
        }

        public UserFactory id(Long id) {
            this.id = id;
            return this;
        }

        public UserFactory username(String username) {
            this.username = username;
            return this;
        }

        public UserFactory password(String password) {
            this.password = password;
            return this;
        }

        public UserFactory count(Long count) {
            this.count = count;
            return this;
        }

        public UserFactory language(Language language) {
            this.language = language;
            return this;
        }

        public UserFactory level(Level level) {
            this.level = level;
            return this;
        }

        public User build() {
            return new User(this.id, this.username, this.password, this.count, this.language, this.level);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", username=" + this.username + ", password=" + this.password + ", count=" + this.count + ", language=" + this.language + ", level=" + this.level + ")";
        }
    }
}

