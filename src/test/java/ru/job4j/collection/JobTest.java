package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Comparator;

public class JobTest {
    @Test
    public void whenComparatorJobAscByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int rsl = cmpAscName.compare(new Job("Ivan", 1), new Job("Petr", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorJobAscByPriority() {
        Comparator<Job> cmpAscName = new JobAscByPriopity();
        int rsl = cmpAscName.compare(new Job("Ivan", 1), new Job("Petr", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorJobDescByName() {
        Comparator<Job> cmpAscName = new JobDescByName();
        int rsl = cmpAscName.compare(new Job("Ivan", 1), new Job("Petr", 2));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorJobDescByPriority() {
        Comparator<Job> cmpAscName = new JobDescByPriority();
        int rsl = cmpAscName.compare(new Job("Ivan", 1), new Job("Petr", 2));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> cmpAscName = new JobAscByName().thenComparing(new JobAscByPriopity());
        int rsl = cmpAscName.compare(new Job("Ivan", 1), new Job("Petr", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        Comparator<Job> cmpAscName = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpAscName.compare(new Job("Ivan", 1), new Job("Petr", 2));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndNameAsc() {
        Comparator<Job> cmpAscName = new JobAscByPriopity().thenComparing(new JobAscByName());
        int rsl = cmpAscName.compare(new Job("Petr", 1), new Job("Ivan", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndNameDesc() {
        Comparator<Job> cmpAscName = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpAscName.compare(new Job("Petr", 1), new Job("Ivan", 2));
        assertThat(rsl).isGreaterThan(0);
    }
}
