package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionDoesHaveManeParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }
        @Parameterized.Parameters
        public static Object[][] doesHaveManeData() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
            };
        }

        @Test
        public void testDoesHaveMane() throws Exception {
            Lion lion = new Lion(sex, new FelineInterface() {
                @Override
                public List<String> getFood(String type) {
                    return new ArrayList<>();
                }
                @Override
                public int getKittens() {
                    return 0;
                }
            });

            assertEquals(expectedHasMane, lion.doesHaveMane());
        }
    }