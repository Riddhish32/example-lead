import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.order.demo.controller.LeadController;
import com.order.demo.model.Lead;
import com.order.demo.repository.LeadTableRepository;
import com.order.demo.response.LeadResponseDetails;

class Test {

    @InjectMocks
    private LeadController leadController;

    @Mock
    private LeadTableRepository leadTableRepository;

    @Test
    void createLead() {
        
        Lead leadToCreate = new Lead();
        leadToCreate.setLeadId(123);
        when(leadTableRepository.createLead(any(Lead.class))).thenReturn(leadToCreate);

        ResponseEntity<?> responseEntity = leadController.createLead(leadToCreate);
        
        LeadResponseDetails leadResonseDetails = new LeadResponseDetails();
        leadResonseDetails.setData("Created Leads Successfully");
        leadResonseDetails.setStatus("success");
		
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("success", ((LeadResponseDetails) responseEntity.getBody()).getStatus());
        assertEquals("Created Leads Successfully", ((LeadResponseDetails) responseEntity.getBody()).getData());
    }

    @Test
    void getLeadByMobileNumber() {
        // Arrange
        Long mobileNumber = 8877887788L;
        Lead lead = new Lead();
        lead.setLeadId(1234);
        lead.setMobileNumber(mobileNumber);
        when(leadTableRepository.findByMobileNumber(mobileNumber)).thenReturn(lead);

        // Act
        ResponseEntity<?> responseEntity = leadController.getLeadByMobileNumber(mobileNumber);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("success", ((LeadResponseDetails) responseEntity.getBody()).getStatus());
        assertEquals(lead, ((LeadResponseDetails) responseEntity.getBody()).getData());
    }
}
