package edu.attractor.onlineshop.Repository;

import edu.attractor.onlineshop.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
