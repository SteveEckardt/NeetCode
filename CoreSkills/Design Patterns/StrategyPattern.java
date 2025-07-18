/**
 * Problem: Strategy Pattern (NeetCode Design Patterns)
 * Author: Steve Eckardt
 * Revision Date: July 18, 2025
 *
 * Description: Uses the Strategy Design Pattern to count people matching different dynamic filtering criteria.
 *
 * Time Complexity: O(n), where n is the number of people in the list
 * Space Complexity: O(1), aside from the input list — filtering is done in-place with no extra space
 */

class Person {
    private String lastName;
    private int age;
    private boolean isMarried;

    public Person(String lastName, int age, boolean isMarried) {
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return isMarried;
    }
}

// Strategy interface for person filtering
interface PersonFilter {
    boolean apply(Person person);
}

// Strategy: filter by adult (age >= 18)
class AdultFilter implements PersonFilter {
    @Override
    public boolean apply(Person person) {
        return person.getAge() >= 18;
    }
}

// Strategy: filter by senior (age >= 65)
class SeniorFilter implements PersonFilter {
    @Override
    public boolean apply(Person person) {
        return person.getAge() >= 65;
    }
}

// Strategy: filter by marital status
class MarriedFilter implements PersonFilter {
    @Override
    public boolean apply(Person person) {
        return person.isMarried();
    }
}

// Context class that uses a strategy to count people
class PeopleCounter {
    private PersonFilter filter;

    // Set filtering strategy at runtime
    public void setFilter(PersonFilter filter) {
        this.filter = filter;
    }

    // Count people that satisfy the current strategy
    public int count(List<Person> people) {
        int result = 0;
        for (Person person : people) {
            if (filter.apply(person)) {
                result++;
            }
        }
        return result;
    }
}
