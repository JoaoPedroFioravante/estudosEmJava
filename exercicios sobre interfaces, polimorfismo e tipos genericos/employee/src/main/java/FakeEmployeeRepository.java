public class FakeEmployeeRepository implements Repository<Employee, String> {
    private final Employee[] employees = new Employee[100];
    private int employesQtd;

    public FakeEmployeeRepository() {
        this.employesQtd = 0;
    }

    @Override
    public boolean register(Employee e) {
        if (100 == employesQtd)
            return false; //TODO comparação Yoda (comparar ao contrário) faz mais sentido quando do lado direito há um objeto (String, por exemplo).
        employees[employesQtd++] = e;
        return true;
    }

    @Override
    public Employee findById(String id) {
        int index = indexOf(id);
        return index >= 0 ? employees[index] : null;
    }

    private int indexOf(String id) {
        for (int i = 0; i < employesQtd; i++) {
            if (employees[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
