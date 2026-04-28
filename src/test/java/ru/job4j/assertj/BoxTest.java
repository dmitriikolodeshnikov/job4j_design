package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotNull()
                .startsWithIgnoringCase("s")
                .contains("h")
                .endsWith("re");
    }
    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .startsWithIgnoringCase("cu")
                .contains("ube")
                .endsWith("e").
                doesNotEndWith("re");
    }
    @Test
    void whenTetrahedron() {
        Box box = new Box(4, 6);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4)
                .isNotZero()
                .isEven()
                .isLessThan(8)
                .isBetween(3, 6);
    }
    @Test
    void whenSphere() {
        Box box = new Box(0, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(0)
                .isNotNull()
                .isLessThan(4)
                .isZero();
    }
    @Test
    void whenExist() {
        Box box = new Box(0, 10);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }
    @Test
    void whenDoesNotExist() {
        Box box = new Box(10, 10);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }
    @Test
    void whenSphere5Then314() {
        Box box = new Box(0, 5);
        double area = box.getArea();
        assertThat(area).isEqualTo(314.1d, withPrecision(0.1d))
                .isGreaterThan(314.0d)
                .isCloseTo(314.0, Percentage.withPercentage(1.0d));
    }
    @Test
    void whenCube10Then314() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(600.0d)
                .isGreaterThan(314.0d)
                .isCloseTo(605.0d, Percentage.withPercentage(1.0d));
    }

}