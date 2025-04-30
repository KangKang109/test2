package Self_Check.Self_Check.service;

import Self_Check.Self_Check.entity.BrowserLaunch;  // ✅ BrowserLaunch import 추가
import Self_Check.Self_Check.repository.BrowserLaunchRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;  // ✅ LocalDateTime import 추가

@Service
public class BrowserLaunchService {
    private long launchCount = 0;  // 실행 횟수 카운터
    public void saveLaunch() {
        launchCount++;
    }

    public long getLaunchCount() {
        return launchCount;
    }

    public void resetLaunchCount() {
        this.launchCount = 0;
    }
}

