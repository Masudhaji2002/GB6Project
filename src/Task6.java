import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// 1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2) Создать коллекцию ноутбуков.
// 3) Написать мапу, которая будет содержать критерий (или критерии) фильтрации и выведет
//      ноутбуки, отвечающие фильтру.
//      Пример: ОЗУ - Значение, Объем ЖД - Значение, Операционная система - Значение, Цвет - Значение
// 4) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

public class Task6 {
    static class Notebook {
        private final String brand;
        private final int memory;
        private final int storage;
        private final String operatingSystem;
        private final String color;

        public Notebook(String brand, int memory, int storage, String operatingSystem, String color) {
            this.brand = brand;
            this.memory = memory;
            this.storage = storage;
            this.operatingSystem = operatingSystem;
            this.color = color;
        }

        public String getBrand() {
            return brand;
        }

        public int getMemory() {
            return memory;
        }

        public int getStorage() {
            return storage;
        }

        public String getOperatingSystem() {
            return operatingSystem;
        }

        public String getColor() {
            return color;
        }
    }

    public static void main(String[] args) {
        List<Notebook> notebooks = initListNotebooks();
        Map<String, String> params = Map.of("Memory", "8", "Storage", "256", "Operating System", "Windows");
        List<Notebook> filteredNotebooks = filter(params, notebooks);
        System.out.println("Filtered notebooks: " + filteredNotebooks);

    }

    public static List<Notebook> initListNotebooks() {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Dell", 8, 256, "Windows", "Black"));
        notebooks.add(new Notebook("HP", 8, 128, "MacOS", "Silver"));
        notebooks.add(new Notebook("Lenovo", 16, 512, "Windows", "Black"));
        notebooks.add(new Notebook("Asus", 16, 256, "Windows", "Silver"));
        return notebooks;
    }

    public static List<Notebook> filter(Map<String, String> params, List<Notebook> notebooks) {
        List<Notebook> filteredNotebooks = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            boolean isValid = true;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                switch (key) {
                    case "Memory":
                        if (notebook.getMemory() != Integer.parseInt(value)) {
                            isValid = false;
                        }
                        break;
                    case "Storage":
                        if (notebook.getStorage() != Integer.parseInt(value)) {
                            isValid = false;
                        }
                        break;
                    case "Operating System":
                        if (!notebook.getOperatingSystem().equals(value)) {
                            isValid = false;
                        }
                        break;
                    case "Color":
                        if (!notebook.getColor().equals(value)) {
                            isValid = false;
                        }
                        break;
                    case "Brand":
                        if (notebook.getBrand().equals(value)) {
                            isValid = false;
                        }
                }
            }
            if (isValid) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}
