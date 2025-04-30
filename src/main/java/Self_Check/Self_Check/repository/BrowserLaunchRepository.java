package Self_Check.Self_Check.repository;

import Self_Check.Self_Check.entity.BrowserLaunch; // 엔티티 패키지가 맞는지 확인
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowserLaunchRepository extends JpaRepository<BrowserLaunch, Long> {
}
