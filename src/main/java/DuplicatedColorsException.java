public class DuplicatedColorsException extends RuntimeException {
    public DuplicatedColorsException() {
        super("El color principal y secundario no pueden ser iguales");
    }
}
