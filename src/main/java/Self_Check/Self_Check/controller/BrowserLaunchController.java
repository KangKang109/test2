package Self_Check.Self_Check.controller;

import Self_Check.Self_Check.service.BrowserLaunchService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000") // 👈 React의 포트를 명시
@RestController
@RequestMapping("/api")
public class BrowserLaunchController {
    private final BrowserLaunchService service;

    public BrowserLaunchController(BrowserLaunchService service) {
        this.service = service;
    }

    @PostMapping("/launch")
    public ResponseEntity<String> registerLaunch() {
        service.saveLaunch();
        return ResponseEntity.ok("Launch registered.");
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> getLaunchCount() {
        long count = service.getLaunchCount();
        String lastLaunch = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  // 최근 실행 시간
        Map<String, Object> response = new HashMap<>();
        response.put("count", count);
        response.put("lastLaunch", lastLaunch);
        return ResponseEntity.ok(response);
    }

    // 자정에 카운트를 초기화하는 스케줄링
    @Scheduled(cron = "0 0 0 * * *")  // 매일 자정에 실행
    public void resetLaunchCount() {
        service.resetLaunchCount();
    }
}
