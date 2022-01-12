public class Computer {

    private final CPU cpu = new CPU();
    private final HardDrive hardDrive = new HardDrive();
    private final Memory memory = new Memory();

    void run() {
        cpu.calculate();
        hardDrive.storeData();
        memory.allocate();
    }
}
