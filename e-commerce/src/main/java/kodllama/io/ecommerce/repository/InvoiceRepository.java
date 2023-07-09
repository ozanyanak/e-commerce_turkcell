package kodllama.io.ecommerce.repository;

import kodllama.io.ecommerce.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}