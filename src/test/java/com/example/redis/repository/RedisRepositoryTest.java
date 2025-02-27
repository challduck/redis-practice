package com.example.redis.repository;

import com.example.redis.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    void test() {
        // given
        Item item = Item.builder()
                .id(1L)
                .name("keyboard")
                .description("very Expensive Keyboard")
                .price(100000)
                .build();

        itemRepository.save(item);
    }

    @Test
    void readOneTest(){
        Item item = itemRepository.findById(1L)
                .orElseThrow();
        System.out.println(item.getDescription());
    }

    @Test
    void updateTest(){
        Item item = itemRepository.findById(1L)
                .orElseThrow();

        item.setDescription("On Sale!!!");
        itemRepository.save(item);

        System.out.println(item.getDescription());
    }

    @Test
    void deleteTest(){
        itemRepository.deleteById(1L);
    }
}
