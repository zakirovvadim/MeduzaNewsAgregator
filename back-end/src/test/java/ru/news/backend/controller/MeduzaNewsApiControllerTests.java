package ru.news.backend.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.news.backend.NewsApplication;


import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest(classes={NewsApplication.class})
public class MeduzaNewsApiControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNews_thenReturnCorrect() {
        String url = "/news?pageNumber=0";
        try {
            MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url)) // составляем запрос
                    .andDo(print()) //
                    .andExpect(status().isOk()) //
                    .andReturn(); //
            assertEquals(200, mvcResult.getResponse().getStatus());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
// Примеры
//    @Test
//    void testList_thenReturnCorrect() {
//        List<Integer>  list1= Arrays.asList(1,32,34,42343,1,4312,432,4,21,5);
//        List<Integer> list2 = Arrays.asList(1,32,34,42343,1,4312,432,4,21,5);
//        assertEquals(list1, list2);
//    }
//
//    @Test
//    void testList_thenReturnFalse() {
//        List<Integer>  list1= Arrays.asList(1,32,34,42343,1,4312,432,4,21,0);
//        List<Integer> list2 = Arrays.asList(1,32,34,42343,1,4312,432,4,21,5);
//        assertNotEquals(list1, list2);
//    }
//
//    @Test
//    void testList_thenReturnException() {
//        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> {
//            int a = 2/0;
//        });
//        assertTrue(arithmeticException.getMessage().contains("by zero"));
//    }
//    @Test
//    void testList_thenReturnGroupTest() {
//        List<Integer>  list1= Arrays.asList(1,32,34,42343,1,4312,432,4,21,0);
//        List<Integer> list2 = Arrays.asList(1,32,34,42343,1,4312,432,4,21,6);
//        List<Integer> list3 = Arrays.asList(1,32,34,42343,1,4312,432,4,21,5);
//        List<Integer> list4 = Arrays.asList(1,32,34,42343,1,4312,432,4,21,5);
//        assertAll(() -> {
//            assertEquals(list3, list4);
//            assertNotEquals(list1, list2);
//        });
//    }


}