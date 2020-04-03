package nl.openweb.hippo.repository;

import nl.openweb.hippo.domain.Journal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface JournalRepository extends JpaRepository<Journal, Long> {
    Page<Journal> findAllByOrderByIdDesc(Pageable pageable);

}
