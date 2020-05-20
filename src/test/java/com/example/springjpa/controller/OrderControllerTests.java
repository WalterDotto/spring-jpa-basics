package com.example.springjpa.controller;

import com.example.springjpa.data.entity.OrderEntity;
import com.example.springjpa.data.repository.OrderRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderControllerTests {

    @Mock
    private OrderRepository mockedOrderRepository;

    private OrderController controller;
    private MockMvc mockMvc;

    @BeforeAll

    public void setUp() {

        controller = new OrderController(mockedOrderRepository);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void test_that_orders_are_successfully_retrieved() throws Exception {

        List<OrderEntity> orderEntityList = new ArrayList<>();

        orderEntityList.add(new OrderEntity(1, null, 1));
        orderEntityList.add(new OrderEntity(2, null, 1));
        orderEntityList.add(new OrderEntity(3, null, null));


        when(mockedOrderRepository.findAll()).thenReturn(orderEntityList);

        MvcResult result = mockMvc.perform(get("/orders"))
                .andExpect(status().isOk()).andReturn();


        assertEquals("[{\"id\":1,\"createdDate\":null,\"cancelReason\":1},{\"id\":2,\"createdDate\":null,\"cancelReason\":1},{\"id\":3,\"createdDate\":null,\"cancelReason\":null}]", result.getResponse().getContentAsString());

    }


}
