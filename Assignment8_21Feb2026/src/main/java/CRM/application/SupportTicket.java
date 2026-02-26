package CRM.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SupportTicket {
    @Id
    @GeneratedValue
    private Long id;
    private String issueDescription;

    @OneToOne
    private OrderEntity order;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIssueDescription() { return issueDescription; }
    public void setIssueDescription(String issueDescription) { this.issueDescription = issueDescription; }
    public OrderEntity getOrder() { return order; }
    public void setOrder(OrderEntity order) { this.order = order; }
}