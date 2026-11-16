package lambdy.dil05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lekce05 {
    public static void main(String[] args) {
        // Podle snímku odkomentuj právě jedno volání.
        // ukazkaLimit();
        // ukazkaSeznam();
        // zachyceni(); // 5.1
        // soucet(); // 5.2
        propojeni(); // 5.3, rozšiřující
    }

    // Ukázka zachycení limitu.
    static void ukazkaLimit() {
        int limit = 10;
        Runnable r = () -> System.out.println(limit);
        r.run();
        // TODO Doplň lambdu a spusť ji přes run().
    }

    // Ukázka změny obsahu seznamu.
    static void ukazkaSeznam() {
        List<String> names = new ArrayList<>();
        names.add("Eva");
        Runnable read = () -> System.out.println(names);
        names.add("Adam");
        read.run();
        // TODO Doplň lambdu, přidej Adama a spusť výpis.
    }

    // Úloha 5.1. Výstup 2.
    static void zachyceni() {
        int changing = 1;
        changing++;
        int finalChanging = changing;
        Runnable r = () -> System.out.println(finalChanging);
        changing++;
        r.run();
        // TODO Ulož průběžnou hodnotu do snapshot a vypiš ji lambdou.
    }

    // Úloha 5.2. Pro [1, 2, 3] výstup 6. Pro [] výstup 0.
    static void soucet() {
        List<Integer> numbers = List.of(1, 2, 3);
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
        // TODO Sečti čísla cyklem a vypiš součet.
    }

    // Rozšiřující úloha 5.3. Výstup Adam a Alena na dvou řádcích.
    static void propojeni() {
        List<String> names = List.of("Eva", "", "Adam", "Alena");
        String prefix = "A";
        Predicate<String> isPrefix = s -> s.startsWith(prefix);
        Function<String, Student> newStudent = Student::new;
        Supplier<List<Student>> listSellected = ArrayList::new;
        //Consumer<Student> addStudent = s -> listSellected.get().add(s);
        Consumer<Student> printStudent = s -> System.out.println(s.getName());
        List<Student> students = listSellected.get();
        for(String name : names) {
            if(isPrefix.test(name)) {
                Student s = newStudent.apply(name);
                students.add(s);
                //addStudent.accept(s);
                printStudent.accept(s);
            }
        }
        // TODO Vyber jména podle prefix a vytvoř z nich studenty.
    }
}