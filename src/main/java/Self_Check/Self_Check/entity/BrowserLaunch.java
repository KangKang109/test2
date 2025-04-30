package Self_Check.Self_Check.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class BrowserLaunch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    // ✅ Getter 추가
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // ✅ Setter 추가 (이 부분이 없어서 오류 발생)
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
