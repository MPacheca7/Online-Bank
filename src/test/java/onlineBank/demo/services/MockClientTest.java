package onlineBank.demo.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import onlineBank.demo.models.BankAccount;
import onlineBank.demo.models.Client;
import onlineBank.demo.models.ERole;
import onlineBank.demo.repository.BankAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class MockClientTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ClientService clientService;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void mockClient(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        BankAccount bankAccount = new BankAccount();
        bankAccount.setIBAN("ES893704004405320132587");
        bankAccountRepository.save(bankAccount);

        Client holder = new Client();

        holder.setName("Saso");
        holder.setPassword("121");
        holder.setDni("20118051D");
        holder.setEmail("holder1@prueba.com");
        holder.setRole(ERole.ROLE_HOLDER);
        holder.setBankAccount(bankAccount);

        clientService.saveClient(holder);
    }

    @Test
    void validCreated() throws Exception {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setIBAN("ES893704004405320132587");
        bankAccountRepository.save(bankAccount);

        Client holder = new Client("Francisco", "99999999Z", "holder5@prueba.com", ERole.ROLE_HOLDER, bankAccount, "121");
        String body = objectMapper.writeValueAsString(holder);
        MvcResult mvcResult = mockMvc.perform(post("/bank/holder/register/accounts")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Francisco"));
    }

}
